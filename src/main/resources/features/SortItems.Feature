Feature: Sort Items by Price
  As a user
  I want to verify that items are sorted from high to low price
  So that I can make informed purchasing decisions

  Scenario: Verify sorting items from high to low price
    Given User is on the inventory page
    When User sorts items by price from high to low
    Then Items should be displayed in descending order of price
