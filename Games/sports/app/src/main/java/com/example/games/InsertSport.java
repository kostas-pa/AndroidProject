package com.example.games;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.games.db.RDatabase;
import com.example.games.db.Sports;

import java.util.ArrayList;
import java.util.List;

public class InsertSport extends Fragment {

    EditText editText;
    Button btadd;
    RecyclerView recyclerView;
    List<Sports> sportsList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    SportsAdapter adapter;
    RDatabase rDatabase;
    RadioGroup rg;
    RadioButton rb;

    public InsertSport() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.insert_sport, container, false);
        editText = view.findViewById(R.id.edit1);
        btadd = view.findViewById(R.id.bt_add);
        recyclerView = view.findViewById(R.id.recycler_view);
        rDatabase = RDatabase.getInstance(getContext());
        sportsList = rDatabase.sportsDao().getAllSports();
        rg = view.findViewById(R.id.radioGroup2);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SportsAdapter((Activity) getContext(), sportsList);
        recyclerView.setAdapter(adapter);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = editText.getText().toString().trim();
                int radioid = rg.getCheckedRadioButtonId();
                View radiob = rg.findViewById(radioid);
                int idx = rg.indexOfChild(radiob);
                rb = (RadioButton) rg.getChildAt(idx);
                String uType = rb.getText().toString();

                    if (!uName.equals("")) {
                        Sports sports = new Sports();
                        sports.setName(uName);
                        sports.setType(uType);
                        rDatabase.sportsDao().insertSport(sports);
                        sportsList.clear();
                        sportsList.addAll(rDatabase.sportsDao().getAllSports());
                        adapter.notifyDataSetChanged();
                    }
                editText.setText("");
            }
        });
        return view;
    }
}

