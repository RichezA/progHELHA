// prototyping to see if the OLED screen and the sensor can
// work together without much difficulties

// libraries
#include <Adafruit_SSD1306.h> // permits to manage the OLED screen
#include "MAX30105.h" // permits to manage the sensor
#include <Wire.h>
#include "heartRate.h" // permits to use the algorithm to calculate our bpm ans SPO2

// declaration of sensor-related variables
MAX30105 heartSensor;

const byte AVG_RATE_SIZE = 6; // number of heartbeats taken for the averaging
byte rates[AVG_RATE_SIZE];    // array where we stock our heartbeats
byte rateSpot = 0;            // Where we are in the array
long lastBeatTime = 0;        // Last time based on arduino's clock
float BPM;                    // instantly taken BPM
int AVGBPM = 0;                   // The avg bpm

// definitions
#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 32
#define OLED_RESET -1
// declaration of our screen
Adafruit_SSD1306 screen(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

void setup() {
  Serial.begin(115200); // for testing purposes
  screen.begin(SSD1306_SWITCHCAPVCC, 0x3c); // instantiate the screen
  screen.display(); // setting up the display
  delay(3000); // to fully init the screen

  heartSensor.begin(Wire, I2C_SPEED_FAST);
  heartSensor.setup(); // setting up the sensor
  heartSensor.setPulseAmplitudeRed(0x0A); // turn the red led off
  heartSensor.setPulseAmplitudeGreen(0);
}

void loop() {
    // we first got to calculate the IR values
    long irValue = heartSensor.getIR();
     // then we treat them ( if the value < 50k then there's no finger on it)
    if(irValue > 55000){
      if(checkForBeat(irValue)){
           // This is when we sensed a beat, we buzz but for everyone's ears it's better not to use it
          //tone(3,1000);
          //delay(100);
          //noTone(3);

          // mesure the duration in ms between two beats
          long delta = millis() - lastBeatTime;
          lastBeatTime = millis();
          BPM = 60 / ( delta / 1000.0 );

          if(BPM < 225 && BPM > 40){
            rates[rateSpot++] = (byte)BPM;
            rateSpot %= AVG_RATE_SIZE;
          
            // we then need to take the avg
            AVGBPM = 0;
            for(byte x = 0; x < rateSpot; x++) AVGBPM += rates[x];
            AVGBPM /= AVG_RATE_SIZE;
          }
        }
        if(AVGBPM < 50) {
          displaySyncScreen();
        }
        else{
          screen.clearDisplay();
          screen.setTextSize(2);
          screen.setTextColor(WHITE);
          screen.setCursor(50,0);
          screen.println("BPM");
          screen.setCursor(50,18); // enough space to see a lil padding
          screen.println(AVGBPM);
          screen.display();
          Serial.print(irValue);
          Serial.print(" AVGBPM=");
          Serial.print(AVGBPM);
          Serial.print(" BPM=");
          Serial.print(BPM);
        }
    }
    if(irValue < 50000){
      Serial.print("NO FINGER?");
      displayWaitingScreen(); // if no finger is detected
    }
    Serial.println();
  }

  void displayScreen(int avgbpm){
    screen.clearDisplay();
        screen.setTextSize(2);
        screen.setTextColor(WHITE);
        screen.setCursor(50,0);
        screen.println("BPM");
        screen.setCursor(50,18); // enough space to see a lil padding
        screen.println(avgbpm);
        screen.display();
  }

  void displayWaitingScreen() {
        AVGBPM = 0;
        screen.clearDisplay();
        screen.setTextSize(1);
        screen.setTextColor(WHITE);
        screen.setCursor(30,5);
        screen.println("Please place ");
        screen.setCursor(30,15); // newline
        screen.println("your finger ");
        screen.display();
  }

  void displaySyncScreen() {
        screen.clearDisplay();
        screen.setTextSize(1);
        screen.setTextColor(WHITE);
        screen.setCursor(30,5);
        screen.println("Please wait ");
        screen.setCursor(30,15); // newline
        screen.println("for synch");
        screen.display();
  }

  byte processBPM(long instantTime){
     long delta = instantTime - lastBeatTime;
     lastBeatTime = millis();
     return 60 / ( delta / 1000 );
  }
