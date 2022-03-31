package com.example.visitefacile.adapter;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Destination")
public class Destination {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name="destinationname")
    private String DestinationName;

    @ColumnInfo(name="destinationpic")
    private int DestinationPic;

    @ColumnInfo(name="traveldate")
    private String TravelDate;

    @ColumnInfo(name="destinationtixprice")
    private double DestinationTicketPrice;

    @ColumnInfo(name="destinationstatus")
    private boolean DestinationStatus;

    @ColumnInfo(name = "destinationprice")
    private double DestinationPrice;

    public Destination(){

    }

    public Destination(@NonNull String destinationName, int destinationPic, String travelDate, double destinationTicketPrice, boolean destinationStatus, double destinationPrice) {
        DestinationName = destinationName;
        DestinationPic = destinationPic;
        TravelDate = travelDate;
        DestinationTicketPrice = destinationTicketPrice;
        DestinationStatus = destinationStatus;
        DestinationPrice = destinationPrice;
    }

    @NonNull
    public String getDestinationName() {
        return DestinationName;
    }

    public void setDestinationName(@NonNull String destinationName) {
        DestinationName = destinationName;
    }

    public int getDestinationPic() {
        return DestinationPic;
    }

    public void setDestinationPic(int destinationPic) {
        DestinationPic = destinationPic;
    }

    public String getTravelDate() {
        return TravelDate;
    }

    public void setTravelDate(String travelDate) {
        TravelDate = travelDate;
    }

    public double getDestinationTicketPrice() {
        return DestinationTicketPrice;
    }

    public void setDestinationTicketPrice(double destinationTicketPrice) {
        DestinationTicketPrice = destinationTicketPrice;
    }

    public boolean isDestinationStatus() {
        return DestinationStatus;
    }

    public void setDestinationStatus(boolean destinationStatus) {
        DestinationStatus = destinationStatus;
    }

    public double getDestinationPrice() {
        return DestinationPrice;
    }

    public void setDestinationPrice(double destinationPrice) {
        DestinationPrice = destinationPrice;
    }
}
