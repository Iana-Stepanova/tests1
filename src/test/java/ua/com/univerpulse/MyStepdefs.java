package ua.com.univerpulse;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public class MyStepdefs implements En {
    private SelenideElement button1;
    private SelenideElement button;

    public MyStepdefs() {
        Before(() -> {
            SpringSelenide.getInstance();
            Configuration.browserBinary = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
            Configuration.browser = "chrome"; //chrome/firefox
            System.setProperty("webdriver.chrome.driver", "C:/WORK/chromedriver/chromedriver.exe");
        });


        When("^I find \"Customer Info\" button of second row payment$", () -> {
            button = $(By.xpath("(//span[contains(text(),'Customer Info')])[2]/parent::button")).waitUntil(Condition.enabled, 5000);
        });
        And("^I click on \"([^\"]*)\" button$", (String buttonName) -> {
            if (buttonName.equals("Customer Info")) {
                button.click();
            } else {
                if (buttonName.equals("Close customer view")) {
                    button1.click();
                }
            }
        });
        Then("^I see \"Customer Info\" section on the top of the page$", () -> {
            $(By.xpath("//mat-card-title[contains(text(),'Customer Info')]")).waitUntil(Condition.visible, 2000);
        });
        When("^I find \"Close customer view\" button$", () -> {
            button1 = $(By.xpath("//span[contains(text(),'Close customer view')]/parent::button"));
        });
        Then("^I don't see \"Customer Info\" section on the top of the page$", () -> {
            $(By.xpath("//mat-card-title[contains(text(),'Customer Info')]")).waitUntil(Condition.disappear, 2000);
        });

    }
}
