package com.example.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.games.db.Sports;

public class DeleteSport extends Fragment {
    TableLayout editText;
    Button button;

    public DeleteSport() {

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_delete_sport, container, false);
       editText = view.findViewById(R.id.tableLayout3);
        button = view.findViewById(R.id.buttonds);
        button.setOnClickListener(v -> {
            int Var_id = 0;
            try {
                //Var_id = Integer.parseInt(editText.get.toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse " + ex);
            }

            Sports sports = new Sports();
            sports.setSid(Var_id);
            Toast.makeText(getActivity(), "Sport deleted ", Toast.LENGTH_LONG).show();
        });
        return view;
    }
}
