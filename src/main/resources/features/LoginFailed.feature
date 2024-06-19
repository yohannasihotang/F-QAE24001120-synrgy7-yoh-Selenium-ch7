Feature: User Login
  Scenario: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters invalid username "yoana" and invalid password "yohanna123"
    And User clicks on the login button
    Then Error message "Epic sadface: Username and password do not match any user in this service" should be displayed
