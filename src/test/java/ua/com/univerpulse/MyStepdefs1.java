package ua.com.univerpulse;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java8.En;
import ua.com.univerpulse.pageobject.HomePage1;
import ua.com.univerpulse.pageobject.HomePage2;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public class MyStepdefs1 implements En {
    private SelenideElement arrow1;
    private HomePage1 homePage1;
    private HomePage2 homePage2;


    public MyStepdefs1() {

        Given("^Open my browser and navigate to \"([^\"]*)\" with login \"([^\"]*)\" and password \"([^\"]*)\"$", (String page, String login, String password) -> {
            open("http://"+login+":"+password+"@"+page);
            sleep(2000);
            homePage1 = SpringSelenide.page(HomePage1.class);
        });
        When("^I find \"([^\"]*)\" arrow on the bottom of the page$", (String arg0) -> {
            homePage1.findArrow();
        });
        And("^I click on \"([^\"]*)\" arrow$", (String arg0) -> {
            homePage1.arrowClick();
        });
        Then("^I choose \"([^\"]*)\"$", (String numberOfRows) -> {
            homePage1.chooseNumberOfRows(numberOfRows);
        });
        And("^I check \"([^\"]*)\"$", (String numberOfRows) -> {
            homePage1.assertNumberOfRows(numberOfRows);
        });
        When("^I click \"([^\"]*)\" button$", (String arg0) -> {
            homePage1.enterNewPaymentClick();
        });
        And("^I enter values customerId = (\\d+)$", (Integer customerId) -> {
            homePage1.enterValuesCustomerId(customerId);
        });
        And("^I enter payment amount = any positive double$", () -> {
            homePage1.enterPaymentAmount();
        });
        And("^I enter paymentChannel = a random string$", () -> {
            homePage1.enterPaymentChannel();
        });
        And("^I navigate to the last page of payments table$", () -> {
            homePage1.lastPage();
        });
        And("^I verify that the payment is shown in the table\\(in the last row\\)$", () -> {
            homePage1.checkLastRow();
        });
        Then("^I click \"([^\"]*)\" other button$", (String arg0) -> {
            homePage1.enterCreatePaymentClick();
        });
        And("^I verify that the payment is not shown in the table$", () -> {
            homePage1.checkLastRowNegative();
        });
        And("^I click \"([^\"]*)\" new button$", (String arg0) -> {
            homePage1.clickPaymentButton();
            sleep(2000);
            homePage2 = SpringSelenide.page(HomePage2.class);
        });
        Then("^I verify that Payment Information is getting populated$", () -> {
            homePage2.verifyPaymentInformationIsPopulated();
        });
        And("^I verify that all fields except paymentID are editable$", () -> {
            homePage2.verifyFieldsAreEdiatable();
        });
        And("^I enter new payment amount = any positive double$", () -> {
            homePage2.enterPaymentAmount();
        });
        And("^I enter new paymentChannel = a random string$", () -> {
            homePage2.enterPaymentChannel();
        });
        And("^I choose first day of current month \\(from date picker control\\) as payment date$", () -> {
            homePage2.chooseFirstDay();
        });
        Then("^I click “Update” button$", () -> {
            homePage2.clickUpdate();
        });


        And("^I verify that payment was successfully updated$", () -> {
            homePage2.checkLastRow();

        });
        When("^I select all customers$", () -> {
            homePage1.smokeTest();
        });
    }
}
