package com.example.criminalintent.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// List de crimes

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context ctxt){
        if(sCrimeLab == null) sCrimeLab = new CrimeLab(ctxt);
        return sCrimeLab;
    }

    private CrimeLab(Context ctxt) {
        mCrimes = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i % 2 == 0);
            crime.setmCrimeGravity((i % 2 == 0) ? Gravity.MILD : Gravity.DEFAULT);
            mCrimes.add(crime);
        }
    }

    public Crime getCrime(UUID id) {
        for(Crime crime: mCrimes){
            if(crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    public List<Crime> getmCrimes() {
        return this.mCrimes;
    }
}
