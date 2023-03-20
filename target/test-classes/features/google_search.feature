Feature: Google search functionality title verification
User story: As a user, when I am on the google search page
            I should be able to search whatever I want and see
            relevant information

  Background:
    Given User is on Google search page

 @smoke
  Scenario: Search functionality result title verification
    When User types apple in the google search box and clicks enter
    Then user sees apple - Google Search is in the google title


    Scenario: Search functionality result title verification
      When User types "orange" in the google search box and clicks enter
      Then user sees "orange - Google Search" is in the google title