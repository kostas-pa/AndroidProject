package com.example.games;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.games.local_db.RDatabase;
import com.example.games.local_db.Team;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder>{

    private List<Team> teamList;
    private Activity context;
    private RDatabase database;

    public TeamAdapter(Activity context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent,
                false);
        return new SportsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {

        Team team = teamList.get(position);
        database = RDatabase.getInstance(context);
        holder.textView.setText(team.getSid());
        holder.textView.append("," + team.getName());
        holder.textView.append("," + team.getStadiumName());
        holder.textView.append("," + team.getCity());
        holder.textView.append("," + team.getCountry());
        holder.textView.append("," + team.getCreationYear());
        holder.btedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Team t = teamList.get(holder.getAdapterPosition());
                int sid = t.getSid();
                int tID = t.getTid();
                String Name = t.getName();
                String stdName = t.getStadiumName();
                String city = t.getCity();
                String country = t.getCountry();
                int creyear = t.getCreationYear();


                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                Button btupdate = dialog.findViewById(R.id.bt_update);

                editText.setText(sid);
                editText.append("," + Name);
                editText.append("," + stdName);
                editText.append("," + city);
                editText.append("," + country);
                editText.append("," + creyear);

                btupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Object[] words = editText.getText().toString().trim().split(",");
                        int uSid = Integer.parseInt(words[0].toString());
                        String uName = words[1].toString();
                        String ustdName = words[2].toString();
                        String ucity = words[3].toString();
                        String ucountry = words[4].toString();
                        int ucreyear = Integer.parseInt(words[5].toString());
                        Team team1 = new Team(uSid, tID, uName, ustdName, ucity, ucountry, ucreyear);
                        database.teamDao().updateTeam(team1);
                        teamList.clear();
                        teamList.addAll(database.teamDao().getAllTeams());
                        notifyDataSetChanged();
                    }
                });
            }
        });

        holder.btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Team t = teamList.get(holder.getAdapterPosition());
                database.teamDao().delete(t);
                int position = holder.getAdapterPosition();
                teamList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, teamList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

}
