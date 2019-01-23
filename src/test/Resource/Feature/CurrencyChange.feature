Feature: TO verify currency is changed to Euro
  @CurrencyChange
  Scenario: changing currency dollar to euro

    Given user is on home page in Demonopcomerce
    When user click on jewelry category
    And user click on currency sign
    Then user shuold able to see euro sign on jewelery