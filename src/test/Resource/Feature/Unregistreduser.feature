Feature: sending a mail to friend by unregistered user

  @Unregistereduser
  Scenario: unregistred user should not be able to send a mail

    Given user is on home page in Demonopcomerce
    When user select jewelry from list
    And user enters his friend email id
    And user tries to send a mail without registering
    Then user should not be able to send a mail to friend