Feature: User Login
  Scenario: Successfull login with valid credentials
    Given User is on the login page
    When User submit valid credentials
    Then User should be redirected to the dashboard