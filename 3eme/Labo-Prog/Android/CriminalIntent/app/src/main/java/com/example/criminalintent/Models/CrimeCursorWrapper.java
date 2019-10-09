package com.example.criminalintent.Models;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.criminalintent.Models.Database.CrimeDbSchema;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Crime getCrime(){
        String uuidString = getString(getColumnIndex(CrimeDbSchema.CrimeTable.cols.UUID));
        String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.cols.TITLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.cols.SOLVED));
        String gravity = getString(getColumnIndex(CrimeDbSchema.CrimeTable.cols.GRAVITY));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setmTitle(title);
        crime.setmDate(new Date(date));
        crime.setmSolved(isSolved != 0);
        crime.setmCrimeGravity(Gravity.valueOf(gravity));

        return crime;
    }
}

/*
 * Question 2: Quelles sont les méthodes de CursorWrapper utilisée dans la classe CrimeCursorWrapper ?
 * TODO: getString, getLong, getInt, getColumnIndex.
 *  TODO: C'est un wrap pour l'interface Cursor qui permet de déléguer les calls au curseur. (Les curseurs permettent de parcourir les résultats des requêtes)
 */
