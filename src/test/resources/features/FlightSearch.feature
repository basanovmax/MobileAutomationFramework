Feature: Flight Search

  Scenario: Verify user can search flight
    Given user open application
    Then verify user is on home screen
    When user click on Flights menu
    Then verify user is on flight search screen
    When user enters source to "source.location"
    And flight destination to "destination.location"
    And select date from "travel.date" to "return.date"
    And click on done button
    And click on search button
    Then verify flight listing page is displayed

