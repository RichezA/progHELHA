package com.example.criminalintent.Models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

// Définit un crime

public class Crime {
    UUID mId;
    String mTitle;
    Date mDate;
    DateFormat dateFormat;
    Boolean mSolved;
    Gravity mCrimeGravity;

    public Crime(){
        mId = UUID.randomUUID();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mDate = new Date();
        mSolved =  false;
        mCrimeGravity = Gravity.DEFAULT;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDate() {
        return dateFormat.format(this.mDate);
    }

    public Boolean getmSolved() {
        return mSolved;
    }

    public UUID getmId() {
        return mId;
    }

    public void setmSolved(boolean isChecked) {
        this.mSolved = isChecked;
    }

    public void setmTitle(String string) {
        this.mTitle = string;
    }

    public Gravity getmCrimeGravity() {
        return this.mCrimeGravity;
    }

    public void setmCrimeGravity(Gravity mCrimeGravity) {
        this.mCrimeGravity = mCrimeGravity;
    }
}
