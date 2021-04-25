package com.example.sports.ui.insert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sports.MainActivity;
import com.example.sports.R;

public class InsertFragment extends Fragment implements View.OnClickListener {
    Button Bn_ins_team, Bn_ins_athlete, Bn_ins_sport;
    public InsertFragment() {
    }

    private InsertViewModel galleryViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(InsertViewModel.class);
        View view = inflater.inflate(R.layout.fragment_insert, container, false);
        Bn_ins_team = view.findViewById(R.id.button2);
        Bn_ins_team.setOnClickListener(this);
        Bn_ins_athlete = view.findViewById(R.id.button3);
        Bn_ins_athlete.setOnClickListener(this);
        Bn_ins_sport = view.findViewById(R.id.button5);
        Bn_ins_sport.setOnClickListener(this);
        return view;
    }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button2:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insert_team_fragment()).addToBackStack(null).commit();
                    break;
                case R.id.button3:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insert_athlete_fragment()).addToBackStack(null).commit();
                    break;
                case R.id.button5:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insert_sport_fragment()).addToBackStack(null).commit();
                    break;
            }
        }

        //galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
          //  @Override
            //public void onChanged(@Nullable String s) {
           // }
        //});
        //return view;
    }