package com.example.games;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.games.local_db.RDatabase;
import com.example.games.local_db.Sports;

import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

    private List<Sports> sportsList;
    private Activity context;
    private RDatabase database;


    public SportsAdapter(Activity context, List<Sports> sportsList) {
        this.context = context;
        this.sportsList = sportsList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Sports sports = sportsList.get(position);
        database = RDatabase.getInstance(context);
        holder.textView.setText(sports.getName());
        holder.textView.append("," + sports.getType());
        holder.btedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sports s = sportsList.get(holder.getAdapterPosition());
                int sID = s.getSid();
                String sName = s.getName();
                String sType = s.getType();

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                Button btupdate = dialog.findViewById(R.id.bt_update);

                editText.setText(sName);
                editText.append("," + sType);

                btupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        String[] words = editText.getText().toString().trim().split(",");
                        String uName = words[0];
                        String uType = words[1];
                        Sports sports1 = new Sports(sID, uName, uType);
                        database.sportsDao().updateSport(sports1);
                        sportsList.clear();
                        sportsList.addAll(database.sportsDao().getAllSports());
                        notifyDataSetChanged();
                    }
                });
            }
        });

        holder.btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sports s = sportsList.get(holder.getAdapterPosition());
                database.sportsDao().delete(s);
                int position = holder.getAdapterPosition();
                sportsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, sportsList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return sportsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView btedit, btdelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            btdelete = itemView.findViewById(R.id.bt_delete);
            btedit = itemView.findViewById(R.id.bt_edit);
        }
    }
}
