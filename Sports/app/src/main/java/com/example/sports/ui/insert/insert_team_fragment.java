package com.example.sports.ui.insert;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sports.MainActivity;
import com.example.sports.R;
import com.example.sports.db.Team;


public class insert_team_fragment extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button btin;

    public insert_team_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insert_team, container, false);
        editText1 = view.findViewById(R.id.editTextTextPersonName);
        editText2 = view.findViewById(R.id.editTextTextPersonName2);
        editText3 = view.findViewById(R.id.editTextTextPersonName3);
        editText4 = view.findViewById(R.id.editTextTextPersonName4);
        editText5 = view.findViewById(R.id.editTextTextPersonName5);
        btin = view.findViewById(R.id.button4);
        btin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Var_teamname = editText1.getText().toString();
                String Var_stadiumname = editText2.getText().toString();
                String Var_city = editText3.getText().toString();
                String Var_country = editText4.getText().toString();
                int Var_year = 0;
                try {
                    Var_year = Integer.parseInt(editText5.getText().toString());
                }
                catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                try {
                    Team team = new Team();
                    team.setName(Var_teamname);
                    team.setStadiumName(Var_stadiumname);
                    team.setCountry(Var_country);
                    team.setCity(Var_city);
                    team.setCreationYear(Var_year);
                    MainActivity.rDatabase.teamDao().insertTeam(team);
                    Toast.makeText(getActivity(), "Team added", Toast.LENGTH_LONG).show();
                }
                catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });
        return view;
    }
}
