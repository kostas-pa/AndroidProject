package com.example.games.local_db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AthleteDao {

    @Query("SELECT * FROM Athlete")
    List<Athlete> getAllAthletes();

    @Query("SELECT * FROM Athlete WHERE First_Name = :fName")
    List<Athlete> searchAthleteByFirstName(String fName);

    @Query("SELECT * FROM Athlete WHERE Last_Name = :lName")
    List<Athlete> searchAthleteByLastName(String lName);

    @Query("SELECT * FROM Athlete WHERE City like :aCity")
    List<Athlete> searchAthleteByCity(String aCity);

    @Query("SELECT * FROM Athlete WHERE Country like :aCountry")
    List<Athlete> searchAthleteByCountry(String aCountry);

    @Query("SELECT * FROM Athlete WHERE BirthYear = :aBirthYear")
    List<Athlete> searchAthleteByBirthYear(String aBirthYear);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateAthlete(Athlete athlete);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAthlete(Athlete athlete);

    @Delete
    void delete(Athlete athlete);
}
