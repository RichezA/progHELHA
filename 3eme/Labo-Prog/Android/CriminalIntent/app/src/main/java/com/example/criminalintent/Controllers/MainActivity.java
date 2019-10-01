package com.example.criminalintent.Controllers;

import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.criminalintent.Fragments.CrimeFragment;
import com.example.criminalintent.R;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }






    /*
        - Question 1:
            Que signifie le ? dans style=?blablabla : TODO Qu'il est optionnel
        - Question 2:
            Quelle est la classe permettant d'écouter:
            - Un TextView : TODO TextWatcher
            - Un CheckBox : TODO CompoundButton.OnCheckedChangeListener
        - Question 3:
            Outre le nom du fichier, quels sont le/les changements effectués par le refactoring (renommage du fichier XML) que vous venez de faire ? TODO readonly abstraction de la classe
    */
}
