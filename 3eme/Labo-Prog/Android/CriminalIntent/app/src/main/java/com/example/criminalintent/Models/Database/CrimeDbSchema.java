package com.example.criminalintent.Models.Database;

public class CrimeDbSchema {
    public static final class CrimeTable {
        public static final String NAME = "Crimes";
        public static final class cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String GRAVITY = "gravity";
        }
    }
}
