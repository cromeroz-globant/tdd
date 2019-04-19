package com.globant.tdd.refactoring.model;

public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Price.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
