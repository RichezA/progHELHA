package com.example.criminalintent.Controllers;

import androidx.fragment.app.Fragment;

import com.example.criminalintent.Fragments.CrimeListFragment;

// Cette classe hérite de `SingleFragmentActivity` étant une classe abstraite permettant comme ça de pouvoir afficher des fragments sur une même page

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
