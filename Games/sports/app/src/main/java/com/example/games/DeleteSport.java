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

import com.example.games.db.Sports;

public class DeleteSport extends Fragment {
    EditText editText;
    Button button;

    public DeleteSport() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_delete_sport, container, false);
        editText = view.findViewById(R.id.tableLayout);
        button = view.findViewById(R.id.button);
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
