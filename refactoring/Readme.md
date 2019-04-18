Overview
========

This is an exercise intended to show how to use refactoring to better 
understand legacy code.

### Preamble

The classes represent a part of a larger system related to movie rentals. The 
functionality under scrutiny is to get a _**statement**_ from a customer's 
rentals.

New requirements
================

#### HTML statement
First they want a statement printed in HTML so that the statement can be 
Web enabled. The key is to identify the current functionality in order to
rearrange it in a way that the statement calculation logic is not affected by 
the presentation logic.

#### Movie/Pricing classification
The users want to make changes to the way they classify movies, but they 
haven't yet decided on the change they are going to make. They have a number of 
changes in mind. These changes will affect both the way renters are charged for 
movies and the way that frequent renter points are calculated.

Tests
=====

A single JUnit test file is provided to help identify the cases inside the logic.
The tests in that file are meant to track any bug introduced by the refactoring
being made. Ideally, with each refactoring cycle the tests should remain green 
(see [Red Green Refactor pattern](http://goo.gl/uW1g0M)) since the changes 
**should not** affect the current functionality.

