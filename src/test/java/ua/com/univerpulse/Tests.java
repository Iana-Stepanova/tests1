package ua.com.univerpulse;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for AutoQA project.
 */
public class Tests {
    @BeforeAll
    public static void testConfiguration() {
        Configuration.browserBinary = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
        Configuration.browser = "chrome"; //chrome/firefox

//        System.setProperty("webdriver.gecko.driver", "C:/WORK/geckodriver/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:/WORK/chromedriver/chromedriver.exe");
    }

    @Test
    public void shouldSectionCustomerWork() {
        open("http://admin:admin@localhost:8090/");
//        $(By.xpath("(//button[@class='mat-stroked-button mat-button-base mat-accent'])[3]")).click();
//        sleep(2000);
//        assertTrue($(By.xpath("//mat-card[@class='mat-card ng-star-inserted']")).isDisplayed(), "jjjj");
//
//        $(By.xpath("//button[@class='mat-stroked-button mat-button-base']")).click();
//        sleep(2000);
//        assertFalse($(By.xpath("//mat-card[@class='mat-card ng-star-inserted']")).isDisplayed(), "rrrr");
//
     //   $(By.xpath("(//span[contains(text(),'Customer Info')])[2]/parent::button")).click();
        $(By.xpath("(//span[contains(text(),'Customer Info')])[2]/parent::button")).click();

        $(By.xpath("//mat-card-title[contains(text(),'Customer Info')]")).waitUntil(Condition.visible,2000);
    //    assertTrue($(By.xpath("//mat-card-title[contains(text(),'Customer Info')]")).isDisplayed(), "The panel is not displayed");
        $(By.xpath("//span[contains(text(),'Close customer view')]/parent::button")).click();
        $(By.xpath("//mat-card-title[contains(text(),'Customer Info')]")).waitUntil(Condition.disappear,2000);
    //    assertTrue($(By.xpath("//mat-card-title[contains(text(),'Customer Info')]")).isDisplayed(), "The panel is not disappears");




    }





}



