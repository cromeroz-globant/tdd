package com.globant.tdd.refactoring.model;

import org.junit.Test;

public class MovieTest {
    @Test(expected = IllegalArgumentException.class)
    public void testThatInvalidPriceThrowsIllegalArgumentException() {
        // Execute
        new Movie("TITLE", 999);
    }
}