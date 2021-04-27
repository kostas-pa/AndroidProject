package com.example.games.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SportsDao {

    @Query("SELECT * FROM Sports")
    public List<Sports> getAllSports();

    @Query("SELECT * FROM Sports WHERE Name like :sName")
    public List<Sports> searchSportByName(String sName);

    @Query("SELECT * FROM Sports WHERE Type = :sType")
    public List<Sports> searchSportByType(String sType);

    @Update
    void updateSport(Sports sport);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSport(Sports sport);

    @Delete
    void delete(Sports sport);
}