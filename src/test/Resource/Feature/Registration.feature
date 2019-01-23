@Register
Feature: user should register successfully

  Scenario: Registration
    Given user is on home page in Demonopcomerce
    When user enters all the details
    Then user should registered successfully