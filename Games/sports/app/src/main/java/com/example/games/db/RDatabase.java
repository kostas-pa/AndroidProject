package com.example.games.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.games.InsertSport;

@Database(entities = {Sports.class, Team.class, Athlete.class}, version = 1, exportSchema = false)
public abstract class RDatabase extends RoomDatabase {
    public abstract SportsDao sportsDao();
    public abstract TeamDao teamDao();
    public abstract AthleteDao athleteDao();

    private static RDatabase INSTANCE;

    public static RDatabase getDBInstance(InsertSport context) {

        if (INSTANCE == null) {
            INSTANCE =  Room.databaseBuilder(context.getApplicationContext(), RDatabase.class,
                    "rDatabase").allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
