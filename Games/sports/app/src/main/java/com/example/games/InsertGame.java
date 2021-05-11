package com.example.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.Random;

public class InsertGame extends Fragment {

    EditText addsport, addCountry, addCity, addDate;
    Button ButtonGame;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_game, container, false);

        addsport = view.findViewById(R.id.Sport_name);
        addCountry = view.findViewById(R.id.Country_name);
        addCity = view.findViewById(R.id.City_name);
        addDate = view.findViewById(R.id.Date);
        ButtonGame = view.findViewById(R.id.buttonAddGame);

        ButtonGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Game");

                Random rand = new Random();
                int id = rand.nextInt(1000000); // Gives n such that 0 <= n < 20

                String sportName = addsport.getText().toString();
                String countryName = addCountry.getText().toString();
                String cityName = addCity.getText().toString();
                String date = addDate.getText().toString();
                String setId = String.valueOf(id);

                GameHelper gameHelper = new GameHelper(setId, sportName, date, cityName, countryName);

                databaseReference.child(setId).setValue(gameHelper);

            }
        });

        return view;
    }
}
