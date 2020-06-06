package ua.com.univerpulse;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public class MyStepdefs1 implements En {
    private SelenideElement arrow1;
    private HomePage1 homePage1;

    public MyStepdefs1() {

        Given("^Open my browser and navigate to http://localhost:8090$", () -> {
            open("http://admin:admin@localhost:8090/");
            sleep(2000);
            homePage1 = page(HomePage1.class);
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
    }
}
