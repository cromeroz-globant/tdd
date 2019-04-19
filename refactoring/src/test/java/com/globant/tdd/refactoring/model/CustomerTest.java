package com.globant.tdd.refactoring.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        customer.addRental(new Rental(new Movie("Gone in 60 seconds", new RegularPrice()), 2));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tGone in 60 seconds\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    /**
     * GIVEN the customer has one regular movie rental for 2 days
     * WHEN the statement is calculated
     * THEN the resulting HTML statement is
     * <pre><code>
     *   <h1>Rental Record for John Doe</h1>
     *   <ul>
     *   <li>Gone in 60 seconds: <em>2.0</em></li>
     *   </ul>
     *   <p>Amount owed is <em>2.0</em></p>
     *   <p>You earned <em>1</em> frequent renter points</p>
     * </code></pre>
     */
    @Test
    public void testThatRegularMovieRentalTwoDayHtmlStatementIsCalculatedCorrectly() {
        // Prepare
        customer.addRental(new Rental(new Movie("Gone in 60 seconds", new RegularPrice()), 2));

        // Execute
        String statement = customer.htmlStatement();

        // Assert
        assertEquals("<h1>Rental Record for John Doe</h1>\n" +
                "<ul>\n" +
                "<li>Gone in 60 seconds: <em>2.0</em></li>\n" +
                "</ul>\n" +
                "<p>Amount owed is <em>2.0</em></p>\n" +
                "<p>You earned <em>1</em> frequent renter points</p>", statement);
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
        customer.addRental(new Rental(new Movie("Avengers Age of Ultron", new RegularPrice()), 3));

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
        customer.addRental(new Rental(new Movie("Brother Bear", new ChildrensPrice()), 3));

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
        customer.addRental(new Rental(new Movie("Lego Batman", new ChildrensPrice()), 4));

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
        customer.addRental(new Rental(new Movie("Avengers: Endgame", new NewReleasePrice()), 1));

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
        customer.addRental(new Rental(new Movie("Roma", new NewReleasePrice()), 2));

        // Execute
        String statement = customer.statement();

        // Assert
        assertEquals("Rental Record for John Doe\n" +
                "\tRoma\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", statement);
    }
}