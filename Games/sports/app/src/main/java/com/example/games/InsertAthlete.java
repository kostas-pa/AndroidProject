package com.example.games;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.games.db.Athlete;
import com.example.games.db.RDatabase;
import com.example.games.db.Sports;
import com.example.games.db.Team;

import java.util.ArrayList;
import java.util.List;

public class InsertAthlete extends Fragment {
    //EditText editText1, editText2, editText3, editText4, editText5;
    //Button btin;

    EditText Fname, Lname, Acity, country, Byear , Sname;
    Button btadd;
    RecyclerView recyclerView;
    List<Athlete> athleteList = new ArrayList<>();
    List<Sports> sportList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    AthleteAdapter adapter;
    RDatabase rDatabase;

    public InsertAthlete() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insert_athlete, container, false);
        Sname = view.findViewById(R.id.Sname);
        Fname = view.findViewById(R.id.Fname);
        Lname = view.findViewById(R.id.Lname);
        Acity = view.findViewById(R.id.Acity);
        country = view.findViewById(R.id.country);
        Byear = view.findViewById(R.id.Byear);
        recyclerView = view.findViewById(R.id.recycler_view2);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new AthleteAdapter((Activity) getContext(), athleteList);
        recyclerView.setAdapter(adapter);
        rDatabase = RDatabase.getInstance(getContext());
        athleteList = rDatabase.athleteDao().getAllAthletes();
        btadd = view.findViewById(R.id.bt_addathlete);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Var_firstname = Fname.getText().toString().trim();
                String Var_lasttname = Lname.getText().toString().trim();
                String Var_city = Acity.getText().toString().trim();
                String Var_country = country.getText().toString().trim();
                int Var_byear = Integer.parseInt(Byear.getText().toString().trim());
                String Var_sport = Sname.getText().toString().trim();
                sportList = rDatabase.sportsDao().searchSportByName(Var_sport);
                Sports sports = sportList.get(0);
                int Var_Sid = sports.getSid();

                Athlete athlete = new Athlete();
                athlete.setSid(Var_Sid);
                athlete.setFirstName(Var_firstname);
                athlete.setLastName(Var_lasttname);
                athlete.setCity(Var_city);
                athlete.setCountry(Var_country);
                athlete.setBirthYear(Var_byear);

                rDatabase.athleteDao().insertAthlete(athlete);
                athleteList.clear();
                athleteList.addAll(rDatabase.athleteDao().getAllAthletes());
                adapter.notifyDataSetChanged();

                Sname.setText("");
                Fname.setText("");
                Lname.setText("");
                Acity.setText("");
                country.setText("");
                Byear.setText("");
            }
        });
        return view;
    }
}
