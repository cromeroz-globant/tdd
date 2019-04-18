package com.globant.tdd.refactoring.model;

/**
 * @author Cesar Romero &lt;cesar.romero@salesforce.com&gt;
 */
class Rental {
    private Movie _movie;
    private int _daysRented;
    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }
    public int getDaysRented() {
        return _daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }
}