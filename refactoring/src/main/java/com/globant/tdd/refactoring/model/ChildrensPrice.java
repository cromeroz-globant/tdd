package com.globant.tdd.refactoring.model;

public class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Price.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
