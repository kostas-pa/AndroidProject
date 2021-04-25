package com.example.sports.ui.delete;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sports.MainActivity;
import com.example.sports.R;
import com.example.sports.db.Sports;

public class delete_sport_fragment  extends Fragment {
    EditText editText;
    Button button;

    public delete_sport_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.delete_sport, container, false);
        editText = view.findViewById(R.id.table1);
        button = view.findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_id = 0;
                try {
                    Var_id = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                Sports sports = new Sports();
                sports.setSid(Var_id);
                Toast.makeText(getActivity(), "Sport deleted ", Toast.LENGTH_LONG).show();
                editText.setText("");

            }
        });
        return view;
    }
}
