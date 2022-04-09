package com.example.visitefacile.adapter;

import android.os.Bundle;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "flight")
public class FlightEntity {
    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "userId")
    String userId;

    @ColumnInfo(name = "from")
    String from;

    @ColumnInfo(name = "to")
    String to;

    @ColumnInfo(name = "price")
    double price;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FlightEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FlightEntity(Integer id, String userId, String from, String to, double price) {
        this.id = id;
        this.userId = userId;
        this.from = from;
        this.to = to;
        this.price = price;
    }
}

