package com.example.sports.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


    @Entity(foreignKeys = @ForeignKey(entity = Sports.class, parentColumns = "sid", childColumns = "Sid",
           onDelete = ForeignKey.CASCADE))
    public class Athlete {

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "ID")
        private int aid;
        @ColumnInfo(name = "First Name")
        private String firstName;
        @ColumnInfo(name = "Last Name")
        private String lastName;
        @ColumnInfo(name = "City")
        private String city;
        @ColumnInfo(name = "Country")
        private String country;
        @ColumnInfo(name = "BirthYear")
        private int BirthYear;
        private int Sid;

        public Athlete(int aid, String firstName, String lastName, String city, String country, int sid,
                       int BirthYear) {
            this.aid = aid;
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
            this.country = country;
            this.BirthYear = BirthYear;
            Sid = sid;
        }

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getSid() {
            return Sid;
        }

        public void setSid(int sid) {
            Sid = sid;
        }

        public int getBirthYear() {
            return BirthYear;
        }

        public void setBirthYear(int birthYear) {
            BirthYear = birthYear;
        }
    }
