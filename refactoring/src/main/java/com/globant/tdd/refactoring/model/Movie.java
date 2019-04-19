package com.globant.tdd.refactoring.model;

public class Movie {
    private String _title;
    private Price _price;

    public Movie(String title, Price price) {
        _title = title;
        _price = price;
    }

    public Price getPrice() {
        return _price;
    }

    public void setPrice(Price price) {
        _price = price;
    }

    public String getTitle() {
        return _title;
    }

    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}