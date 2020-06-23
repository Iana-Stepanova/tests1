Feature: Web-scenario1

  Background:

    Given Open my browser and navigate to "localhost:8090" with login "user" and password "user"

  @Test3
  Scenario: Enter new payment
    When I click "Enter new payment" button
    And I enter values customerId = 1
    And I enter payment amount = any positive double
    And I enter paymentChannel = a random string
    Then I click "Create payment" other button
    And I navigate to the last page of payments table
    And I verify that the payment is not shown in the table
    And Verify that record with given values was NOT inserted in payments table
