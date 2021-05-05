package com.example.games.local_db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sports.class, Team.class, Athlete.class}, version = 2, exportSchema = false)
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
