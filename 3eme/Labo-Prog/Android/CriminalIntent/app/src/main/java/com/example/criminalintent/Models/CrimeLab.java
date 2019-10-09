package com.example.criminalintent.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.criminalintent.Models.Database.CrimeBaseHelper;
import com.example.criminalintent.Models.Database.CrimeDbSchema;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// List de crimes

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;


    public static CrimeLab get(Context ctxt){
        if(sCrimeLab == null) sCrimeLab = new CrimeLab(ctxt);
        return sCrimeLab;
    }

    private CrimeLab(Context ctxt) {
        mContext = ctxt.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
        if(this.getmCrimes().size() == 0) {
            Crime tempCrime;
            for(int i = 0; i < 100; i++){
                tempCrime = new Crime();
                tempCrime.setmTitle("Crime #" + ( i+1 ));
                this.addCrime(tempCrime);
            }
        }
    }

    public void addCrime(Crime crime){
        mDatabase.insert(CrimeDbSchema.CrimeTable.NAME, null, getContentValues(crime));
    }

    public void updateCrime(Crime crime){
        String uuidString = crime.getmId().toString();
        ContentValues values = getContentValues(crime);

        mDatabase.update(CrimeDbSchema.CrimeTable.NAME, values,
                CrimeDbSchema.CrimeTable.cols.UUID
                + "=?", new String[] { uuidString});
    }

    public Crime getCrime(UUID id) {
       CrimeCursorWrapper cursor = queryCrimes(
               CrimeDbSchema.CrimeTable.cols.UUID + "=?", new String[] {id.toString()});
        try {
            if(cursor.getCount() == 0) return null;
            cursor.moveToFirst();
            return cursor.getCrime();
        } finally {
            cursor.close();
        }
    }

    public List<Crime> getmCrimes() {
        ArrayList<Crime> crimes = new ArrayList<>();

        CrimeCursorWrapper cursor = queryCrimes(null, null);
        try {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return crimes;
    }

    private ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(CrimeDbSchema.CrimeTable.cols.UUID, crime.getmId().toString());
        values.put(CrimeDbSchema.CrimeTable.cols.TITLE, crime.getmTitle());
        values.put(CrimeDbSchema.CrimeTable.cols.DATE, crime.getmDate());
        values.put(CrimeDbSchema.CrimeTable.cols.SOLVED, crime.getmSolved() ? 1 : 0);
        values.put(CrimeDbSchema.CrimeTable.cols.GRAVITY, crime.getmCrimeGravity().toString());

        return values;
    }

    private CrimeCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        return new CrimeCursorWrapper(mDatabase.query(
                CrimeDbSchema.CrimeTable.NAME,
                null, // retrieve all columns
                whereClause,
                whereArgs,
                null, null, null )); // no other characteristics to our request
    }
}
