package com.example.criminalintent.Models.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context ctxt){
        super(ctxt, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + CrimeDbSchema.CrimeTable.NAME + " (" + " _id integer primary key autoincrement, "
                + CrimeDbSchema.CrimeTable.cols.UUID + ", " + CrimeDbSchema.CrimeTable.cols.TITLE + ", " + CrimeDbSchema.CrimeTable.cols.DATE + ", " + CrimeDbSchema.CrimeTable.cols.SOLVED + ", " + CrimeDbSchema.CrimeTable.cols.GRAVITY + " )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}



/*
 * Question 1: D'après la javadoc de SQLiteOpenHelper, quand est-ce que onCreate et onUpgrade sont appélées ? A quoi sert le numéro de version
 * TODO: Quand on doit ouvrir la DB, le numéro de version sert à la gestion des mises à jour de la db
 */