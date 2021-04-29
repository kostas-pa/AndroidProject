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

public class DeleteFragment extends Fragment implements View.OnClickListener{
    Button bn_sport, bn_athlete, bn_team, bn_game;

    public DeleteFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        bn_sport = view.findViewById(R.id.buttonTeam);
        bn_sport.setOnClickListener(this);
        bn_athlete = view.findViewById(R.id.buttonSport);
        bn_athlete.setOnClickListener(this);
        bn_team = view.findViewById(R.id.buttonAthlete);
        bn_team.setOnClickListener(this);
        bn_game = view.findViewById(R.id.buttonGame);
        bn_game.setOnClickListener(this);
        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonGame:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteGame()).commit();
                break;
            case R.id.buttonTeam:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteSport()).commit();
                break;
            case R.id.buttonSport:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteAthlete()).commit();
                break;
            case R.id.buttonAthlete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteTeam()).commit();
                break;
        }
    }
}
