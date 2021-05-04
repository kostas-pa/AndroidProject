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

import com.example.games.db.Athlete;
import com.example.games.db.RDatabase;
import com.example.games.db.Team;

import java.util.List;

public class AthleteAdapter  extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

    private List<Athlete> athleteList;
    private Activity context;
    private RDatabase database;

    public AthleteAdapter(Activity context, List<Athlete> athleteList) {
        this.context = context;
        this.athleteList = athleteList;
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

        Athlete athlete = athleteList.get(position);
        database = RDatabase.getInstance(context);
        holder.textView.setText(athlete.getSid());
        holder.textView.append("," + athlete.getFirstName());
        holder.textView.append("," + athlete.getLastName());
        holder.textView.append("," + athlete.getCity());
        holder.textView.append("," + athlete.getCountry());
        holder.textView.append("," + athlete.getBirthYear());
        holder.btedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Athlete a = athleteList.get(holder.getAdapterPosition());
                int aid = a.getAid();
                String fname = a.getFirstName();
                String lname = a.getLastName();
                String city = a.getCity();
                String country = a.getCountry();
                int byear = a.getBirthYear();

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                Button btupdate = dialog.findViewById(R.id.bt_update);

                editText.setText(fname);
                editText.append("," + lname);
                editText.append("," + city);
                editText.append("," + country);
                editText.append("," + byear);
                btupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Object[] words = editText.getText().toString().trim().split(",");
                        int uSid = Integer.parseInt(words[0].toString());
                        String ufname = words[1].toString();
                        String ulname = words[2].toString();
                        String ucity = words[3].toString();
                        String ucountry = words[4].toString();
                        int ubyear = Integer.parseInt(words[5].toString());
                        Athlete athlete1 = new Athlete(uSid, aid, ufname, ulname, ucity, ucountry, ubyear);
                        database.athleteDao().updateAthlete(athlete1);
                        athleteList.clear();
                        athleteList.addAll(database.athleteDao().getAllAthletes());
                        notifyDataSetChanged();
                    }
                });

            }
        });

        holder.btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Athlete a = athleteList.get(holder.getAdapterPosition());
                database.athleteDao().delete(a);
                int position = holder.getAdapterPosition();
                athleteList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, athleteList.size());
            }
        });
    }

    @Override
    public int getItemCount() { return athleteList.size(); }

}
