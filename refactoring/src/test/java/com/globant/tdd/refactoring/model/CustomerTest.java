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

    /**
     * GIVEN the customer has one regular movie rental for 2 days
     * WHEN the statement is calculated
     * THEN the resulting statement is
     * <pre><code>
     *     Rental Record for John Doe
     *         Gone in 60 seconds    2.0
     *     Amount owed is 2.0
     *     You earned 1 frequent renter points
     * </code></pre>
     */
    @Test
    public void testThatRegularMovieRentalTwoDayStatementIsCalculatedCorrectly() {
        // Prepare
        customer.addRental(new Rental(new Movie("Gone in 60 seconds", Movie.REGULAR), 2));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tGone in 60 seconds\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    /**
     * GIVEN the customer has one regular movie rental for more than 2 days
     * WHEN the statement is calculated
     * THEN the resulting statement is
     * <pre><code>
     *     Rental Record for John Doe
     *         Avengers Age of Ultron    3.5
     *     Amount owed is 3.5
     *     You earned 1 frequent renter points
     * </code></pre>
     */
    @Test
    public void testThatRegularMovieRentalMoreThanTwoDaysStatementIsCalculatedCorrectly() {
        // Prepare
        customer.addRental(new Rental(new Movie("Avengers Age of Ultron", Movie.REGULAR), 3));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tAvengers Age of Ultron\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    /**
     * GIVEN the customer has one children movie rental 3 days
     * WHEN the statement is calculated
     * THEN the resulting statement is
     * <pre><code>
     *     Rental Record for John Doe
     *         Brother Bear    1.5
     *     Amount owed is 1.5
     *     You earned 1 frequent renter points
     * </code></pre>
     */
    @Test
    public void testThatChildrenMovieRentalThreeDaysStatementIsCalculatedCorrectly() {
        // Prepare
        customer.addRental(new Rental(new Movie("Brother Bear", Movie.CHILDRENS), 3));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tBrother Bear\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    /**
     * GIVEN the customer has one children movie rental more than 3 days
     * WHEN the statement is calculated
     * THEN the resulting statement is
     * <pre><code>
     *     Rental Record for John Doe
     *         Lego Batman    3.0
     *     Amount owed is 3.0
     *     You earned 1 frequent renter points
     * </code></pre>
     */
    @Test
    public void testThatChildrenMovieRentalMoreThanThreeDaysStatementIsCalculatedCorrectly() {
        // Prepare
        customer.addRental(new Rental(new Movie("Lego Batman", Movie.CHILDRENS), 4));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tLego Batman\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    /**
     * GIVEN the customer has one new release movie rental 1 day
     * WHEN the statement is calculated
     * THEN the resulting statement is
     * <pre><code>
     *     Rental Record for John Doe
     *         Avengers: Endgame    3.0
     *     Amount owed is 3.0
     *     You earned 1 frequent renter points
     * </code></pre>
     */
    @Test
    public void testThatNewReleaseMovieRentalOneDayStatementIsCalculatedCorrectly() {
        // Prepare
        customer.addRental(new Rental(new Movie("Avengers: Endgame", Movie.NEW_RELEASE), 1));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tAvengers: Endgame\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    /**
     * GIVEN the customer has one new release movie rental more than 1 day
     * WHEN the statement is calculated
     * THEN the resulting statement is
     * <pre><code>
     *     Rental Record for John Doe
     *         Roma    6.0
     *     Amount owed is 6.0
     *     You earned 2 frequent renter points
     * </code></pre>
     */
    @Test
    public void testThatNewReleaseMovieRentalMoreThanOneDayStatementIsCalculatedCorrectly() {
        // Prepare
        customer.addRental(new Rental(new Movie("Roma", Movie.NEW_RELEASE), 2));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tRoma\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", statement);
    }
}