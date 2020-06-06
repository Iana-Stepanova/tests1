Feature: Web-scenario

  Background:

    Given Open your browser and navigate to http://localhost:8090

  Scenario: Customer Info button
    When I find "Customer Info" button of second row payment
    And I click on "Customer Info" button
    Then I see "Customer Info" section on the top of the page
    When I find "Close customer view" button
    And I click on "Close customer view" button
    Then I don't see "Customer Info" section on the top of the page



