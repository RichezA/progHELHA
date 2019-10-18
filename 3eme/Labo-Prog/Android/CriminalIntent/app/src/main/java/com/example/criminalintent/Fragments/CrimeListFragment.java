package com.example.criminalintent.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criminalintent.Controllers.MainActivity;
import com.example.criminalintent.Models.Crime;
import com.example.criminalintent.Models.CrimeLab;
import com.example.criminalintent.R;

import java.text.ParseException;
import java.util.List;

public class CrimeListFragment extends Fragment {
    private static final String TAG = "CrimeListFragment";
    // Fragment qui permettra d'afficher une liste de crimes, pour afficher une list (ListView) on utilise un 'RecyclerView'

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mCrimeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crime_list_fragment, container, false);
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getmCrimes();

        if(mCrimeAdapter == null){
            mCrimeAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mCrimeAdapter);
        } else {
            mCrimeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "RESUMING");

        this.updateUI();
    }

    private class CrimeHolder extends RecyclerView.ViewHolder {
        private Crime mCrime;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mCrimeGravityTextView;

        // Notre Holder permet 'd'inflate' une vue sélectionnée et la retourne nous pourrons donc avoir accès aux widgets qui la compose

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            mTitleTextView = itemView.findViewById(R.id.crime_title);
            mDateTextView = itemView.findViewById(R.id.crime_date);
            mCrimeGravityTextView = itemView.findViewById(R.id.crime_gravity);


            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // Le clic sur un élément de notre liste permettra de `switcher` vers la "main activity" qui est le détail du crime sélectionné
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("crime_id", mCrime.getmId());
                    startActivity(intent);
                }
            });
        }

        public void bind(Crime crime){
            // Permet de bind un crime afin d'update la vue

            this.mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getmDate());
            mCrimeGravityTextView.setText(mCrime.getmCrimeGravity().toString());
            itemView.setBackgroundColor(getResources().getColor(mCrime.getmSolved() ? android.R.color.holo_green_light : android.R.color.holo_red_light));
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimes;

        // L'adapter du RecyclerView sert à update la vue via `entre autres` le bind du Holder

        public CrimeAdapter(List<Crime> crimes){
            this.mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(inflater, parent);

        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return this.mCrimes.size();
        }
    }
}

