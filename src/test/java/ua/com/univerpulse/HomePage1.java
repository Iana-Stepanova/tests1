package ua.com.univerpulse;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.Random;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public class HomePage1 {
    @FindBy(xpath = "//span[text()='Enter new payment ']/parent::button")
    private SelenideElement buttonEnterNewPayment;
    @FindBy(xpath = "//button[@class='mat-paginator-navigation-last mat-icon-button mat-button-base ng-star-inserted']")
    private SelenideElement buttonPaginatorLast;

    private SelenideElement arrow1;
    private double paymentAmount = Math.random()*100;
    private String paymentChannel = UUID.randomUUID().toString().replace("-","").substring(0,10);




    public void findArrow() {
        $(By.xpath("//tbody/tr")).waitUntil(Condition.visible, 5000);
        arrow1 = $(By.xpath("//div[@class='mat-select-arrow']/parent::*")).waitUntil(Condition.enabled, 2000);
    }

    public void arrowClick() {
        arrow1.click();
    }

    public void chooseNumberOfRows(String numberOfRows) {
        $(By.xpath("//span[@class='mat-option-text' and text()=" + numberOfRows + "]/parent::mat-option")).waitUntil(Condition.enabled, 2000).click();

    }

    public void assertNumberOfRows(String numberOfRows) {
        ElementsCollection counter = $$(By.xpath("//tbody/tr"));
        assertEquals(Integer.parseInt(numberOfRows), counter.size(), "Not equals");
    }

    public void enterNewPaymentClick() {
        buttonEnterNewPayment.click();
    }


    public void enterValuesCustomerId(Integer customerId) {
        $(By.xpath("//input[@placeholder='Enter customerId']")).sendKeys("" + customerId);
    }

    public void enterPaymentAmount() {
        $(By.xpath("//input[@placeholder='Enter Payment paymentAmount']")).sendKeys("" + paymentAmount);
    }


    public void enterPaymentChannel() {
        $(By.xpath("//input[@placeholder='Enter Payment channel']")).sendKeys(paymentChannel);
    }

    public void lastPage() {
        buttonPaginatorLast.click();
    }

    public void checkLastRow() {
        SelenideElement lastString = $(By.xpath("//tbody/tr[last()]"));
        SelenideElement paymentChannel=lastString.$(By.xpath("./td[text()='"+this.paymentChannel+"']"));
        SelenideElement paymentAmount=lastString.$(By.xpath("./td[text()='"+this.paymentAmount+"']"));
        assertTrue(paymentChannel.isDisplayed(),"Not visible 1");
        assertTrue(paymentAmount.isDisplayed(),"Not visible 2");
    }

    public void enterCreatePaymentClick() {
        $(By.xpath("//span[text()='Create Payment']/parent::button")).waitUntil(Condition.enabled, 2000).click();
        sleep(5000);
    }
}

