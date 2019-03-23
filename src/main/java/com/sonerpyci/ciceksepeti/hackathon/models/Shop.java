package com.sonerpyci.ciceksepeti.hackathon.models;

import javax.persistence.*;

@Entity(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String address;

    private String latitude;

    private String longitude;

    private int averageOrderCount;

    private int currentOrderCount;

    private int brokarage;

    @Transient
    private double distance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getAverageOrderCount() {
        return averageOrderCount;
    }

    public void setAverageOrderCount(int averageOrderCount) {
        this.averageOrderCount = averageOrderCount;
    }

    public int getCurrentOrderCount() {
        return currentOrderCount;
    }

    public void setCurrentOrderCount(int currentOrderCount) {
        this.currentOrderCount = currentOrderCount;
    }

    public int getBrokarage() {
        return brokarage;
    }

    public void setBrokarage(int brokarage) {
        this.brokarage = brokarage;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
