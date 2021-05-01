package com.example.games.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "Team", foreignKeys = {
        @ForeignKey(entity = Sports.class, parentColumns = "ID", childColumns = "ID",
                onDelete = CASCADE)})
public class Team  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int tid;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Stadium_Name")
    private String stadiumName;
    private String City;
    private String Country;
    private int Sid;
    @ColumnInfo(name = "Creation_Year")
    private int creationYear;


    public Team() {

    }

    public Team(int Sid, int tid, String name, String stadiumName, String City, String Country, int creationYear) {
        this.Sid = Sid;
        this.tid = tid;
        this.name = name;
        this.stadiumName = stadiumName;
        this.City = City;
        this.Country = Country;
        this.creationYear = creationYear;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
}
