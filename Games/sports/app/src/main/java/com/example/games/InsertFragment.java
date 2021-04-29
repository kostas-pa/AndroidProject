package com.example.games;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class InsertFragment extends Fragment implements View.OnClickListener {
    Button Bn_ins_team, Bn_ins_athlete, Bn_ins_sport, Bn_ins_game;

    public InsertFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_insert, container, false);
        Bn_ins_team = view.findViewById(R.id.buttonAthlete);
        Bn_ins_team.setOnClickListener(this);
        Bn_ins_athlete = view.findViewById(R.id.buttonSport);
        Bn_ins_athlete.setOnClickListener(this);
        Bn_ins_sport = view.findViewById(R.id.buttonTeam);
        Bn_ins_sport.setOnClickListener(this);
        Bn_ins_game = view.findViewById(R.id.buttonGame);
        Bn_ins_game.setOnClickListener(this);
        return view;
    }
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonGame:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertGame()).commit();
                    break;
                case R.id.buttonTeam:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertSport()).commit();
                    break;
                case R.id.buttonAthlete:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertTeam()).commit();
                    break;
                case R.id.buttonSport:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertAthlete()).commit();
                    break;
            }
        }
    }
