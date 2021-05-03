package com.example.games;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.games.db.RDatabase;
import com.example.games.db.Sports;
import com.example.games.db.Team;

import java.util.ArrayList;
import java.util.List;

public class InsertTeam extends Fragment {

    EditText tname, stdname, city, country, creyear , sname;
    Button btadd;
    RecyclerView recyclerView;
    List<Team> teamList = new ArrayList<>();
    List<Sports> sportList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    TeamAdapter adapter;
    RDatabase rDatabase;

    public InsertTeam() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.insert_team, container, false);
        sname = view.findViewById(R.id.Sname);
        tname = view.findViewById(R.id.tname);
        stdname = view.findViewById(R.id.stdname);
        city = view.findViewById(R.id.city);
        country = view.findViewById(R.id.country);
        creyear = view.findViewById(R.id.creyear);
        btadd = view.findViewById(R.id.bt_addteam);
        recyclerView = view.findViewById(R.id.recycler_view1);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new TeamAdapter((Activity) getContext(), teamList);
        recyclerView.setAdapter(adapter);
        rDatabase = RDatabase.getInstance(getContext());
        teamList = rDatabase.teamDao().getAllTeams();
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Var_sname = sname.getText().toString().trim();
                String Var_teamname = tname.getText().toString().trim();
                String Var_stadiumname = stdname.getText().toString().trim();
                String Var_city = city.getText().toString().trim();
                String Var_country = country.getText().toString().trim();
                int Var_year = Integer.parseInt(creyear.getText().toString().trim());
                sportList = rDatabase.sportsDao().searchSportByName(Var_sname);
                Sports sports = sportList.get(0);
                int Var_Sid = sports.getSid();

                Team team = new Team();
                team.setSid(Var_Sid);
                team.setName(Var_teamname);
                team.setStadiumName(Var_stadiumname);
                team.setCountry(Var_country);
                team.setCity(Var_city);
                team.setCreationYear(Var_year);

                rDatabase.teamDao().insertTeam(team);
                teamList.clear();
                teamList.addAll(rDatabase.teamDao().getAllTeams());
                adapter.notifyDataSetChanged();

                sname.setText("");
                tname.setText("");
                stdname.setText("");
                city.setText("");
                country.setText("");
                creyear.setText("");
            }
        });
        return view;
    }
}
