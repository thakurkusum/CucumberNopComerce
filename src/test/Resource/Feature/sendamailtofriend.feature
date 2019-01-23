
@sendamail
Feature: sending a mail to friend

  Scenario: user should send a mail successfully
    Given user is already login in Demonopcomerce
    And he is in homepage
    When user select any product
    Then user should able to send a mail to his friend successfully