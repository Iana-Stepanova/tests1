Feature: Web-scenario1

  Background:

    Given Open my browser and navigate to "localhost:8090" with login "admin" and password "admin"

  @Test1
  Scenario Outline: Choose items in combobox
    When I find "Combobox" arrow on the bottom of the page
    And I click on "Combobox" arrow
    Then I choose "<Number>"
    And I check "<Number>"
    Examples:
      | Number |
      | 10     |
      | 20     |

  @Test2
  Scenario: Enter new payment
    When I click "Enter new payment" button
    And I enter values customerId = 1
    And I enter payment amount = any positive double
    And I enter paymentChannel = a random string
    Then I click "Create payment" other button
    And I navigate to the last page of payments table
    And I verify that the payment is shown in the table(in the last row)

  @Test4
  Scenario: Preparing to edit the last payment
    When I navigate to the last page of payments table
    And I click "Payment Info" new button
    Then I verify that Payment Information is getting populated
    And I verify that all fields except paymentID are editable

  @Test5
  Scenario: Edit the last payment
    When I navigate to the last page of payments table
    And I click "Payment Info" new button
    And I enter new payment amount = any positive double
    And I enter new paymentChannel = a random string
    And I choose first day of current month (from date picker control) as payment date
    Then I click “Update” button
    And I verify that payment was successfully updated
