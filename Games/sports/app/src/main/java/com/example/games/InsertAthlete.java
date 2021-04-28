package com.example.games;

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

import com.example.games.db.Athlete;

public class InsertAthlete extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button btin;

    public InsertAthlete() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_athlete, container, false);
        editText1 = view.findViewById(R.id.editTextTextPersonName2);
        editText2 = view.findViewById(R.id.editTextTextPersonName5);
        editText3 = view.findViewById(R.id.editTextTextPersonName4);
        editText4 = view.findViewById(R.id.editTextTextPersonName6);
        editText5 = view.findViewById(R.id.editTextTextPersonName3);
        btin = view.findViewById(R.id.button3);
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
