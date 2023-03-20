
Feature: Etsy title verification

  Background:
    Given user is on etsy website

  Scenario:

    Then user is able to see the title as expected

  Scenario:
    When user types Wooden Spoon in the search box
    And user clicks search button
    Then user sees Wooden spoon is in the title


  Scenario:
    When user types "Wooden Spoon" in the search box
    And user clicks search button
    Then user sees "Wooden spoon" is in the title
