#include <Adafruit_SSD1306.h>
#include <Wire.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 32
#define OLED_RESET -1

Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

void setup() {
  // put your setup code here, to run once:
  display.begin(SSD1306_SWITCHCAPVCC, 0x3c);
  display.display();
  delay(3000);

}

void loop() {
  // put your main code here, to run repeatedly:

  // display is working by his side
  display.clearDisplay();
  display.setTextSize(2);
  display.setTextColor(WHITE);
  display.println("HELLO WORLD");
  display.display();
  delay(10000);
}
