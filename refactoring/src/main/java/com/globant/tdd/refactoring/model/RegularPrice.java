package com.globant.tdd.refactoring.model;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Price.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
