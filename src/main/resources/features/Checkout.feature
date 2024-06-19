Feature: Checkout Process
  As a user
  I want to complete the checkout process successfully
  So that I can purchase items from Saucedemo

  Scenario: User successfully completes checkout process
    Given User is logged in to Saucedemo
    When User adds "Sauce Labs Backpack" to the cart
    And User adds "Sauce Labs Bolt T-Shirt" to the cart
    And User proceeds to the cart
    And User clicks on checkout button
    And User fills in checkout information with:
      | First Name | Last Name | Postal Code |
      | Yohanna    | Sihotang  | 12345       |
    And User finishes the checkout process
    Then User should see a success message confirming the order completion
