package com.example.criminalintent.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.criminalintent.Models.Crime;
import com.example.criminalintent.Models.CrimeLab;
import com.example.criminalintent.Models.Gravity;
import com.example.criminalintent.R;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.UUID;


public class CrimeFragment extends Fragment {

    // Définit un fragment pour détailler un crime

    Crime mCrime;
    EditText mTitleField;
    Button mDateButton;
    CheckBox mSolvedCheckBox;
    Spinner mCrimeGravityCombo;


    // Equivalent du constructeur en OOP
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("onCreate");
        //mCrime = new Crime();
        UUID crime_id = (UUID) getActivity().getIntent().getSerializableExtra("crime_id");
        mCrime = CrimeLab.get(getActivity()).getCrime(crime_id);
    }


    // Permet de lier la vue à notre fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate the fragment_crime view
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        // Configure view
        mTitleField = v.findViewById(R.id.crime_title);
        mSolvedCheckBox = v.findViewById(R.id.crime_solved);
        mDateButton = v.findViewById(R.id.crime_date);
        mCrimeGravityCombo = v.findViewById(R.id.crime_gravity);
        this.setCombo(mCrimeGravityCombo);

        mTitleField.setText(mCrime.getmTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            // Permet d'update directement la vue selon des prérequis
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nothing to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing to do
            }
        });

        mTitleField.setText(mCrime.getmTitle());

        mDateButton.setText(mCrime.getmDate());
        mDateButton.setEnabled(false);

        mSolvedCheckBox.setChecked(mCrime.getmSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });

        return v;
    }

    private void setCombo(Spinner mCrimeGravityCombo) {
        ArrayAdapter<Gravity> adapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_layout, R.id.spinner_layout, Gravity.values());
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        mCrimeGravityCombo.setAdapter(adapter);
        mCrimeGravityCombo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCrime.setmCrimeGravity((Gravity) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCrime.setmCrimeGravity(Gravity.DEFAULT);
            }
        });
    }
}
