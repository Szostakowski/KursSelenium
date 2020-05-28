Feature: Qlo hotel

  // Scenario Outline: psuje test 

  Scenario: new account

    Given an open browser with qloapps.coderslab.pl/pl
    When click "Zaloguj sie" on website
    And enter email address in input filed "Create new account"
    Then wait 5sek, should open new website to create new account
    And add account data: gender, first name, surname, password, date of birth, email address was added automatically
    And check newsletter





