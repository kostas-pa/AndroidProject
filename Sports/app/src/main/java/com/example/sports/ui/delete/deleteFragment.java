package com.example.sports.ui.delete;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sports.MainActivity;
import com.example.sports.R;

public class deleteFragment extends Fragment implements View.OnClickListener {
    Button bn_sport, bn_athlete, bn_team;

    public deleteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.delete, container, false);
        bn_sport = view.findViewById(R.id.button12);
        bn_sport.setOnClickListener(this);
        bn_athlete = view.findViewById(R.id.button11);
        bn_athlete.setOnClickListener(this);
        bn_team = view.findViewById(R.id.button13);
        bn_team.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button12:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new delete_sport_fragment()).addToBackStack(null).commit();
                break;
            case R.id.button11:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new delete_athlete_fragment()).addToBackStack(null).commit();
                break;
            case R.id.button13:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new delete_team_fragment()).addToBackStack(null).commit();
                break;
        }
    }
}
