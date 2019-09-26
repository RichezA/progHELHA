package com.example.criminalintent.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Crime {
    UUID mId;
    String mTitle;
    Date mDate;
    DateFormat dateFormat;
    Boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mDate = new Date();
    }

    public String getmTitle() {
        return mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public Boolean getmSolved() {
        return mSolved;
    }

    public void setmSolved(boolean isChecked) {
        this.mSolved = isChecked;
    }

    public void setmTitle(String string) {
        this.mTitle = string;
    }
}
