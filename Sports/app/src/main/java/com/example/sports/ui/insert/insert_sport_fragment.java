package com.example.sports.ui.insert;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sports.MainActivity;
import com.example.sports.R;
import com.example.sports.db.Sports;
import com.example.sports.db.Team;


public class insert_sport_fragment extends Fragment {
    EditText editText1;
    RadioGroup rg;
    RadioButton rb;
    Button btin;

    public insert_sport_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insert_sport, container, false);
        editText1 = view.findViewById(R.id.editTextTextPersonName11);
        rg = view.findViewById(R.id.group1);
        btin = view.findViewById(R.id.button7);
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
