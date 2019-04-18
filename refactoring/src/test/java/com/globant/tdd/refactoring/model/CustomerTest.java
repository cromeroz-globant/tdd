package com.globant.tdd.refactoring.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John Doe");
    }

    @Test
    public void testThatRegularMovieRulesAreApplied() {
        // Prepare
        customer.addRental(new Rental(new Movie("Gone in 60 seconds", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Ocean's eleven", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Avengers Age of Ultron", Movie.REGULAR), 3));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tGone in 60 seconds\t2.0\n" +
                "\tOcean's eleven\t2.0\n" +
                "\tAvengers Age of Ultron\t3.5\n" +
                "Amount owed is 7.5\n" +
                "You earned 3 frequent renter points", statement);
    }

    @Test
    public void testThatChildrenMoviesRulesAreApplied() {
        // Prepare
        customer.addRental(new Rental(new Movie("Cinderella", Movie.CHILDRENS), 2));
        customer.addRental(new Rental(new Movie("Brother Bear", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Lego Batman", Movie.CHILDRENS), 4));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tCinderella\t1.5\n" +
                "\tBrother Bear\t1.5\n" +
                "\tLego Batman\t3.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 3 frequent renter points", statement);
    }

    @Test
    public void testThatNewReleaseMoviesRulesAreApplied() {
        // Prepare
        customer.addRental(new Rental(new Movie("Avengers: Endgame", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Roma", Movie.NEW_RELEASE), 2));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tAvengers: Endgame\t3.0\n" +
                "\tRoma\t6.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 3 frequent renter points", statement);
    }
}