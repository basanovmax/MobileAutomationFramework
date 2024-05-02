Feature: Flight Search

  Scenario: Verify user can search flight
    Given user open application
    Then verify user is on home screen
    When user click on Flights menu
    Then verify user is on flight search screen
    When user enters source to "Chicago"
    And flight destination to "New York"
    And select date from "Fri, May 10" to "Fri, May 17"
    And click on done button
    And click on search button
    Then verify flight listing page is displayed

