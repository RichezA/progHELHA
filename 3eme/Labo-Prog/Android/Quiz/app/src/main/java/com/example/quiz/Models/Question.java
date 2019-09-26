package com.example.quiz.Models;

import com.example.quiz.R;

public class Question {

    protected int mTextResId; // Identifiant de la question
    protected boolean mAnswerTrue; // indique si la réponse est true ou false

    public Question(int questionId, boolean isAnswerTrue) {
        this.mTextResId = questionId;
        this.mAnswerTrue = isAnswerTrue;
    }

    public int getmTextResId() {
        return this.mTextResId;
    }

    public boolean ismAnswerTrue() {
        return this.mAnswerTrue;
    }

    public static Question[] fillQuestionBank(){
        return new Question[]{
                new Question(R.string.question_australia, true),
                new Question(R.string.question_oceans, true),
                new Question(R.string.question_mideast, false),
                new Question(R.string.question_africa, false),
                new Question(R.string.question_americas, true),
                new Question(R.string.question_asia, true)
        };
    }
}
