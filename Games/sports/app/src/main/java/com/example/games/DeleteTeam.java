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

import com.example.games.db.Team;

public class DeleteTeam extends Fragment {
    EditText editText;
    Button button;

    public DeleteTeam() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_team, container, false);
        editText = view.findViewById(R.id.tableLayout4);
        button = view.findViewById(R.id.buttondt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_id = 0;
                try {
                    Var_id = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                Team team = new Team();
                team.setTid(Var_id);
                Toast.makeText(getActivity(), "Sport deleted ", Toast.LENGTH_LONG).show();
                editText.setText("");
            }
        });
        return view;
    }
}
