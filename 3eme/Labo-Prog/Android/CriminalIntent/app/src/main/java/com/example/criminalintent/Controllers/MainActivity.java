package com.example.criminalintent.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.criminalintent.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_crime_cont);
        System.out.println("AFTER FRAGMENT FOUND");
        if(fragment != null) {
            System.out.println("FRAGMENT IS NOT NULL");
            fragment = new CrimeFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }






    /*
        - Question 1:
            Que signifie le ? dans style=?blablabla : TODO Qu'il est optionnel
        - Question 2:
            Quelle est la classe permettant d'écouter:
            - Un TextView : TODO TextWatcher
            - Un CheckBox : TODO CompoundButton.OnCheckedChangeListener
    */
}
