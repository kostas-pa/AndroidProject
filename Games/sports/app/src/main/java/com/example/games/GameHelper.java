package com.example.games;

public class GameHelper {
    String id, Sport, Date, City, Country;

    public GameHelper() {
    }

    public GameHelper(String id, String sport, String date, String city, String country) {
        this.id = id;
        Sport = sport;
        Date = date;
        City = city;
        Country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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
}
