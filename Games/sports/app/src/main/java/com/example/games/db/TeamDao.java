package com.example.games.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeamDao {
    @Query("SELECT * FROM Team")
    List<Team> getAllTeams();

    @Query("SELECT * FROM Team WHERE Name = :tName")
    List<Team> searchTeamByName(String tName);

    @Query("SELECT * FROM Team WHERE Stadium_Name = :tStadiumName")
    List<Team> searchTeamByStadiumName(String tStadiumName);

    @Query("SELECT * FROM Team WHERE City = :tCity")
    List<Team> searchTeamByCity(String tCity);

    @Query("SELECT * FROM Team WHERE Country = :tCountry")
    List<Team> searchTeamByCountry(String tCountry);

    @Query("SELECT * FROM Team WHERE Creation_Year = :tCreationYear")
    List<Team> searchTeamByCreationYear(String tCreationYear);

    @Update
    void updateTeam(Team... team);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeam(Team... team);

    @Delete
    void delete(Team... team);
}
