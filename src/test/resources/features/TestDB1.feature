Feature: ScenarioDB1

  @TestDB2
  Scenario: Print information about all payments in the log
    When Retrieve information about all payments with amount less than 5 given amount
    Then Print all information in the log


