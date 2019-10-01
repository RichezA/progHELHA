package com.example.quiz.Controllers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiz.R;

public class CheatActivity extends AppCompatActivity {

    public static final String ANSWER_EXTRA = "answer";
    public static final String EXTRA_ANSWER_SHOWN = "answerShown";
    /*private static final String KEY_BOOLEAN = "boolean key";*/
    protected boolean mAnswerIsTrue;
    protected Button mShowAnswerButton;
    protected TextView mAnswerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(ANSWER_EXTRA, false);
        mShowAnswerButton = findViewById(R.id.show_answer_button);
        mAnswerTextView = findViewById(R.id.answer_text_view);

        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(EXTRA_ANSWER_SHOWN, true);
                setResult(RESULT_OK, data);

                // mAnswerTextView.setText("The answer is: " + mAnswerIsTrue);
                finish();
            }
        });
    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_BOOLEAN, mAnswerIsTrue);
    }*/
}
