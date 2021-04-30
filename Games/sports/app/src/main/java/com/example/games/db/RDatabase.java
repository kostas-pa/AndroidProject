package com.example.games.db;

import android.app.Activity;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.games.InsertSport;

import java.util.Objects;

@Database(entities = {Sports.class, Team.class, Athlete.class}, version = 1, exportSchema = false)
public abstract class RDatabase extends RoomDatabase {

    public abstract SportsDao sportsDao();
    public abstract TeamDao teamDao();
    public abstract AthleteDao athleteDao();

    private static RDatabase database;
    private static String DATABASE_NAME = "database";

    public synchronized static RDatabase getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), RDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return database;
    }
}
