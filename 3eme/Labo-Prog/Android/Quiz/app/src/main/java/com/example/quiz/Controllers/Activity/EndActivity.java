package com.example.quiz.Controllers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz.R;

public class EndActivity extends AppCompatActivity {

    protected String mEndScoreFormattedText;
    protected TextView mEndScoreTextView;
    protected Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        mEndScoreFormattedText = getIntent().getStringExtra("END_SCORE_DATA");
        mEndScoreTextView = findViewById(R.id.end_score_text_view);
        mResetButton = findViewById(R.id.reset_button);

        mEndScoreTextView.setText(mEndScoreFormattedText);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    public void resetGame() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
