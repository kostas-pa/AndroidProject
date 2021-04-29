package com.example.games.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Sports")
public class Sports {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int sid;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Type")
    private String type;


    public Sports() {

    }

    public Sports (int sid, String name, String type) {
        this.sid = sid;
        this.name = name;
        this.type = type;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
