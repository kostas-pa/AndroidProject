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
import com.example.sports.db.Athlete;
import com.example.sports.db.Team;


public class insert_athlete_fragment extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button btin;

    public insert_athlete_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insert_athlete, container, false);
        editText1 = view.findViewById(R.id.editTextTextPersonName6);
        editText2 = view.findViewById(R.id.editTextTextPersonName7);
        editText3 = view.findViewById(R.id.editTextTextPersonName8);
        editText4 = view.findViewById(R.id.editTextTextPersonName9);
        editText5 = view.findViewById(R.id.editTextTextPersonName10);
        btin = view.findViewById(R.id.button6);
        btin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Var_firstname = editText1.getText().toString();
                String Var_lasttname = editText2.getText().toString();
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
                    Athlete athlete = new Athlete();
                    athlete.setFirstName(Var_firstname);
                    athlete.setLastName(Var_lasttname);
                    athlete.setCity(Var_city);
                    athlete.setCountry(Var_country);
                    athlete.setBirthYear(Var_year);
                    MainActivity.rDatabase.athleteDao().insertAthlete(athlete);
                    Toast.makeText(getActivity(), "Athlete added", Toast.LENGTH_LONG).show();
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
