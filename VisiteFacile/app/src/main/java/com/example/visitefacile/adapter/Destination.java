package com.example.visitefacile.adapter;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mydestination")
public class Destination {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name="destinationname")
    private String DestinationName;

    @ColumnInfo(name="destinationcountry")
    private String DestinationCountryName;

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

    @ColumnInfo(name = "destinationabout")
    private String DestinationAbout;

    public String getDestinationAbout() {
        return DestinationAbout;
    }

    public void setDestinationAbout(String destinationAbout) {
        DestinationAbout = destinationAbout;
    }


    public Destination(){

    }

    public Destination(@NonNull String destinationName, String destinationCountryName, int destinationPic, String travelDate, double destinationTicketPrice, boolean destinationStatus,String destinationAbout) {
        DestinationName = destinationName;
        DestinationCountryName = destinationCountryName;
        DestinationPic = destinationPic;
        TravelDate = travelDate;
        DestinationTicketPrice = destinationTicketPrice;
        DestinationStatus = destinationStatus;
        double destinationPrice = 0;
        DestinationPrice = destinationPrice;
        DestinationAbout = destinationAbout;
    }

    @NonNull
    public String getDestinationName() {
        return DestinationName;
    }

    public void setDestinationName(@NonNull String destinationName) {
        DestinationName = destinationName;
    }

    public String getDestinationCountryName() {
        return DestinationCountryName;
    }

    public void setDestinationCountryName(String destinationCountryName) {
        DestinationCountryName = destinationCountryName;
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
