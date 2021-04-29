package com.example.games;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {

    List<GameHelper> gameHelperList;

    public HelperAdapter(List<GameHelper> gameHelperList) {
        this.gameHelperList = gameHelperList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_games,parent,false);
        viewHolderClass viewHolderClass = new viewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewHolderClass viewHolderClass = (viewHolderClass)holder;
        GameHelper gameHelper = gameHelperList.get(position);
        viewHolderClass.id.setText(gameHelper.getId());
        viewHolderClass.sport.setText(gameHelper.getSport());
        viewHolderClass.date.setText(gameHelper.getDate());

    }

    @Override
    public int getItemCount() {
        return gameHelperList.size();
    }

    public class viewHolderClass extends RecyclerView.ViewHolder{
        TextView id,sport,date;

        public viewHolderClass(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.text_game_id);
            sport = itemView.findViewById(R.id.text_game_sport);
            date = itemView.findViewById(R.id.text_game_date);
        }
    }
}
