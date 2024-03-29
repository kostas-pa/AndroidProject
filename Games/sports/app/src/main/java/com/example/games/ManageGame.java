package com.example.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ManageGame extends Fragment {

    List<GameHelper> gameHelper;
    RecyclerView recyclerView;
    HelperAdapter helperAdapter;
    DatabaseReference databaseReference;

    TextView game_id;
    ImageView edit_game, delete_game;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference referenceParticipant;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manage_game, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        gameHelper = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Game");

        edit_game = view.findViewById(R.id.bt_edit_game);
        delete_game = view.findViewById(R.id.bt_delete_game);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot ds:datasnapshot.getChildren()){
                    GameHelper data = ds.getValue(GameHelper.class);
                    gameHelper.add(data);
                }
                helperAdapter = new HelperAdapter(gameHelper);
                recyclerView.setAdapter(helperAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*delete_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Game");

                String gameId = view.findViewById(R.id.text_game_id).toString();

                databaseReference.child(gameId).removeValue();
            }
        }); */

        return view;
    }

}
