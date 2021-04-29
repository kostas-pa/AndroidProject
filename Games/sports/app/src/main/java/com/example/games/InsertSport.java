package com.example.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.games.db.RDatabase;
import com.example.games.db.Sports;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class InsertSport extends Fragment {
    EditText editText1;
    RadioGroup rg;
    RadioButton rb;
    Button btin;


    EditText editText;
    Button btadd;
    RecyclerView recyclerView;
    List<Sports> sportsList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    MainAdapter adapter;
    public static RDatabase rDatabase;

    public InsertSport() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_test, container, false);
        editText = view.findViewById(R.id.edit1);
        btadd = view.findViewById(R.id.bt_add);
        recyclerView = view.findViewById(R.id.recycler_view);
        rDatabase = RDatabase.getDBInstance(this);
        sportsList = rDatabase.sportsDao().getAllSports();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(MainActivity.this, sportsList);
        recyclerView.setAdapter(adapter);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = editText.getText().toString().trim();

                if (!sName.equals("")) {
                    Sports sports = new Sports();
                    sports.setName(sName);
                    rDatabase.sportsDao().insertSport(sports);
                    editText.setText("");
                    sportsList.clear();
                    adapter.notifyDataSetChanged();
                }
            }
        });
        return view;




        /*View view = inflater.inflate(R.layout.fragment_insert_sport, container, false);
        editText1 = view.findViewById(R.id.editTextTextPersonName);
        rg = view.findViewById(R.id.radioGroup2);
        btin = view.findViewById(R.id.button2);
        btin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Var_name = editText1.getText().toString();
                int radioid = rg.getCheckedRadioButtonId();
                View radiob = rg.findViewById(radioid);
                int idx = rg.indexOfChild(radiob);
                rb = (RadioButton) rg.getChildAt(idx);
                String Var_type = rb.getText().toString();
                try {
                    Sports sports = new Sports();
                    sports.setName(Var_name);
                    sports.setType(Var_type);
                }
                catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
            }
        });
        return view;*/
    }
}

