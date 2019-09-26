package com.richeza.me.intro;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    protected TextView textView;
    protected Button button;
    protected int nb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.helloWorldTV);

        button = findViewById(R.id.clickButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                nb++;
                textView.setText("Vous avez cliqué " + nb + " fois");
            }
        });
    }

    public void openNewActivity(View view){
        /*Button btn = (Button)view;
        System.out.println(btn.getText());*/
        Intent intent = new Intent(this, /* MainActivity.class*/ SecondActivity.class);
        startActivity(intent);
        //this.finish();
    }
}
