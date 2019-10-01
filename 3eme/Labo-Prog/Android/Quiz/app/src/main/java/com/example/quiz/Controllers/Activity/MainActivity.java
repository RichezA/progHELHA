package com.example.quiz.Controllers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.Controllers.Interfaces.MainPageToControllerInteraction;
import com.example.quiz.Models.Question;
import com.example.quiz.R;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private static final String KEY_SCORE = "mScore";
    private static final String KEY_CHEAT = "cheating times";
    private static final String KEY_BUNDLE = "bundle";
    protected Button mTrueButton; // m == convention pour les membres de classes en Android
    protected Button mFalseButton;
    protected Button mNextButton;
    protected TextView mQuestionTextView;
    protected int mCurrentIndex;
    protected Question[] mQuestionBank;
    protected int mPlayerScore;
    protected int mMaxQuestions;
    protected Button mEndSessionBtn;
    protected String mScore;
    protected final String KEY_INDEX = "index";
    protected Button mCheatButton;
    protected int mCheatingTimes;

    protected MainPageToControllerInteraction interaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setIds();

        if(savedInstanceState != null) recoverState(savedInstanceState);

        this.updateScore(null);

        View.OnClickListener handleAnswer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedBtn = (Button) v;
                mNextButton.setEnabled(true);
                if(clickedBtn.getId() == R.id.true_button) disableButton(mFalseButton);
                else disableButton(mTrueButton);

                handleQuestionAnswer(clickedBtn);
            }
        };

        mTrueButton.setOnClickListener(handleAnswer);
        mFalseButton.setOnClickListener(handleAnswer);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex == 5) openEndActivity(v);
                else {
                    mCurrentIndex++;
                    updateScore(null);
                }
            }
        });
        if(mEndSessionBtn != null){
            mEndSessionBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                /*mCurrentIndex = 0;
                mPlayerScore = 0;
                updateScore();*/
                    openEndActivity(v);
                }
            });
        }
        
        if(mCheatButton != null) {
            mCheatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToCheatActivity(v);
                }
            });
        }

    }

    private void handleQuestionAnswer(Button clickedBtn) {
        if(mQuestionBank[mCurrentIndex].ismAnswerTrue()){
            if(clickedBtn.getId() == R.id.true_button) {
                updateScore(true);
            } else {
                updateScore(false);
            }
        } else {
            if(clickedBtn.getId() == R.id.false_button) {
                updateScore(true);
            } else {
                updateScore(false);
            }
        }
    }

    private void recoverState(Bundle savedInstanceState) {
        Bundle bundle = savedInstanceState.getBundle(KEY_BUNDLE);
        mPlayerScore = bundle.getInt(KEY_SCORE);
        mCurrentIndex = bundle.getInt(KEY_INDEX);
        mCheatingTimes = bundle.getInt(KEY_CHEAT);
    }

    private void setIds() {
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mNextButton = findViewById(R.id.next_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mCurrentIndex = 0;
        mQuestionBank = Question.fillQuestionBank();
        mPlayerScore = 0;
        mEndSessionBtn = findViewById(R.id.end_session_button);
        mMaxQuestions = mQuestionBank.length;
        mCheatButton = findViewById(R.id.cheat_button);
        mCheatingTimes = 0;
    }

    private void disableButton(Button button) {
        button.setEnabled(false);
    }
/*
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("tag", "on start method");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("tag", "on destroy method");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("tag", "on stop method");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("tag", "on resume method");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("tag", "on pause method");
    }
*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("TAG", "onSaveInstanceState");
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_INDEX, mCurrentIndex);
        bundle.putInt(KEY_SCORE, mPlayerScore);
        bundle.putInt(KEY_CHEAT, mCheatingTimes);
        outState.putBundle(KEY_BUNDLE ,bundle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == CheatActivity.RESULT_OK){
            if(data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN, false)) {
                mCheatingTimes++;
                Toast.makeText(this,  getString(R.string.answer_is) +" " + getCurrentQuestion().ismAnswerTrue(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private Question getCurrentQuestion() {
        return this.mQuestionBank[mCurrentIndex];
    }

    protected void updateScore(Boolean answer) {
        // TODO Get total questions
        // TODO Get current mScore
        // TODO Update the textVieW
        this.mQuestionTextView.setText(getCurrentQuestion().getmTextResId());
        if(answer == null){
            this.resetButtonsState();
        } else if(answer){
            mScore = ++mPlayerScore + "/" + mMaxQuestions + ". You cheated: " + mCheatingTimes + "/" + mMaxQuestions + " times.";
            Toast.makeText(MainActivity.this, this.mScore, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, this.mScore, Toast.LENGTH_SHORT).show();

        }
    }

    private void resetButtonsState() {
        mTrueButton.setEnabled(true);
        mFalseButton.setEnabled(true);
        mNextButton.setEnabled(false);
    }

    protected void openEndActivity(View view) {
        Intent intent = new Intent(this, EndActivity.class);
        intent.putExtra("END_SCORE_DATA", mScore);
        intent.putExtra("END_CHEAT_DATA", mCheatingTimes);
        startActivity(intent);
        this.finish();
    }
    
    protected void goToCheatActivity(View v){
        Intent intent = new Intent(MainActivity.this, CheatActivity.class);
        intent.putExtra(CheatActivity.ANSWER_EXTRA, getCurrentQuestion().ismAnswerTrue());
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void setInteraction(MainPageToControllerInteraction interaction) { this.interaction = interaction; }

    /*
        - Question 1 : Expliquez les attributs
            match_parent : TODO Utilise les mêmes paramètres qui ont été fixés par le widget / layout parent.
            wrap_content : TODO Utilise un espace minimal autout du texte à l'intérieur du widget
            android:orientation : Pour le LinearLayout : TODO Permet de déterminer l'orientation dans lequel les widget seront mis à la suite l'un de l'autre.
            android:text : TODO Set le text d'un widget. Recommandé d'utiliser le fichier `strings.xml` se trouvant dans /res/values/.

        - Question 2:
            Où se trouve le fichier R.java ? TODO Dans les fichiers générés lors du build de l'application, sous /app/build/generated/not_namespaced.../debug/r/com/example/quiz/R.java
            Dans le fichier R, quel est l'identifiant de la ressource de type layout se nommant `activity_quiz` ? TODO Le type int ?
                Donnez sa valeur numérique et le nom de la variable associée ? TODO 0x7f09001c -> activity_main
            Dans le fichier R, quel est l'identifiant de la string true_button ? TODO int true_button = 0x7f0b002c

        - Question 3:
            Dans quelle classe du fichier R apparaissent les string ? TODO `public static final class string`
            Dans quelle classe apparaissent les id des boutons ? TODO `public static final class id`
            Dans quelle classe apparaissent l'id du layout `activity_quiz` ? TODO `public static final class layout`

        - Question 4:
            Quel est le package de la classe Button ? TODO android.widget
            Donnez 5 autres classes de ce package qui vous sont familières : TODO  CheckBox, GridView, ImageView, ListView, TextView

        - Question 5:
            Dans quelle classe est définie la méthode `findViewById` ? TODO Dans la classe AppCompatActivity.java
            Quel est son type de retour ? TODO `<T extends View>` c-à-d n'importe quel type mais qui DOIT hériter de la classe View

        - Question 6:
            Quel type d'élément est View.onClickListener, une classe, une méthode, un constructeur ou autre chose ? TODO une interface statique publique.
            Dans quel package se trouve cet élément ? TODO Du package Android.View

        - Question 7:
            Quel est le package de la classe Log ? TODO android.util
            Quelles sont les méthodes disponibles dans la classe Log ? TODO v(), d(), i(), w(), e(), getStackTracePrint(), println()

        - Question 8:
            Où allons-nous utiliser l'id du bouton 'Next' ? TODO Dans le contrôleur
            Quand allons-nous utiliser l'id du TextView ? TODO Quand on va vouloir changer de question
     */

    /*
        - Question 1: Quelles méthodes de callback sont appelées quand:
            on lance: TODO start et resume
            on quitte (bouton back): TODO stop et destroy
            on change d'app (avec task manager): TODO pause et stop
            on revient (avec task manager): TODO start et resume
            on effectue une rotation: TODO pause, stop, destroy, start, resume

        - Question 2:
            Quels sont les types d'éléments que l'on peut enregistrer dans un bundle ? TODO Les types primitifs
     */
}
