package com.example.criminalintent.Models;

import androidx.annotation.NonNull;

public enum Gravity {
    DEFAULT ("Not defined"),
    MILD ("Mild"),
    MODERATE ("Moderate"),
    SEVERE ("Severe");

    private String name;

    Gravity(String name){
        this.name = name;
    }


    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
