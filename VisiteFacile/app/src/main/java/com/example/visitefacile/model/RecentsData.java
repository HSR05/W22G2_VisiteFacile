package com.example.visitefacile.model;

public class RecentsData {

    String placeName;
    String countryName;
    String price;

    public RecentsData(String placeName, String countryName, String price) {
        this.placeName = placeName;
        this.countryName = countryName;
        this.price = price;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
