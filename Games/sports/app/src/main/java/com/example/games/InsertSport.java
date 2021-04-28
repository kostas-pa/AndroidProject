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

import com.example.games.db.Sports;

public class InsertSport extends Fragment {
    EditText editText1;
    RadioGroup rg;
    RadioButton rb;
    Button btin;

    public InsertSport() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_sport, container, false);
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
        return view;
    }
}
