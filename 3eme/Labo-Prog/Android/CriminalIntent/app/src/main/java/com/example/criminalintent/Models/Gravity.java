package com.example.criminalintent.Models;

import androidx.annotation.NonNull;

public enum Gravity {
    DEFAULT ("Default"),
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

    public String returnGravityEnum() { return this.name.toUpperCase(); }
}
