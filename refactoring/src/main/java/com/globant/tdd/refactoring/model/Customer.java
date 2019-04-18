package com.globant.tdd.refactoring.model;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String statement() {
        StringBuilder result = new StringBuilder(String.format("Rental Record for %s%n", getName()));
        //show figures for each rental
        _rentals.stream()
                .map(rental -> String.format("\t%s\t%.1f%n", rental.getMovie().getTitle(), rental.getCharge()))
                .forEach(result::append);
        //add footer lines
        result.append(String.format("Amount owed is %.1f%n", getTotalCharge()))
                .append(String.format("You earned %d frequent renter points", getTotalFrequentRenterPoints()));
        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder(String.format("<h1>Rental Record for %s</h1>%n", getName()))
                .append(String.format("<ul>%n"));
        //show figures for each rental
        _rentals.stream()
                .map(rental -> String.format("<li>%s: <em>%.1f</em></li>%n", rental.getMovie().getTitle(), rental.getCharge()))
                .forEach(result::append);
        //add footer lines
        result.append(String.format("</ul>%n"))
                .append(String.format("<p>Amount owed is <em>%.1f</em></p>%n", getTotalCharge()))
                .append(String.format("<p>You earned <em>%d</em> frequent renter points</p>", getTotalFrequentRenterPoints()));
        return result.toString();
    }

    private double getTotalCharge() {
        return _rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getTotalFrequentRenterPoints() {
        return _rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}
