package examples.fpluquet.be.serviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ServiceApplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, AService.class);
        intent.putExtra(AService.STRING_TO_SHOW, "Starting " + new Random().nextInt());
        startService(intent);
    }


    public void sendMessageToService(View view) {
        Intent intent = new Intent(this, AService.class);
        intent.putExtra(AService.STRING_TO_SHOW, "From button "  + new Random().nextInt());
        startService(intent);
    }
}
