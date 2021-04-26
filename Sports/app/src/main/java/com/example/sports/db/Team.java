package com.example.sports.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


    @Entity(foreignKeys = {
            @ForeignKey(entity = Sports.class, parentColumns = "sid", childColumns = "Sid",
                    onDelete = ForeignKey.CASCADE),
            @ForeignKey(entity = Athlete.class, parentColumns = "city", childColumns = "City",
                    onDelete = ForeignKey.CASCADE),
            @ForeignKey(entity = Athlete.class, parentColumns = "country", childColumns = "Country",
                    onDelete = ForeignKey.CASCADE)})
    public class Team {

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "ID")
        private int tid;
        @ColumnInfo(name = "Name")
        private String name;
        @ColumnInfo(name = "Stadium Name")
        private String stadiumName;
        private String City;
        private String Country;
        private int Sid;
        @ColumnInfo(name = "Creation Year")
        private int creationYear;



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
