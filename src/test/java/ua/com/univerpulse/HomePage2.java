package ua.com.univerpulse;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
public class HomePage2 {
    @FindBy(xpath = "//input[@name='paymentId']")
    private SelenideElement inputPaymentId;
    @FindBy(xpath = "//input[@name='paymentAmount']")
    private SelenideElement inputPaymentAmount;
    @FindBy(xpath = "//input[@name='paymentDatePicker']")
    private SelenideElement inputPaymentDatePicker;
    @FindBy(xpath = "//input[@name='channel']")
    private SelenideElement inputPaymentChannel;

    @FindBy(xpath = "//span[text()='Back']/parent::button")
    private SelenideElement buttonBack;
    @FindBy(xpath = "//span[text()='Update']/parent::button")
    private SelenideElement buttonUpdate;
    @FindBy(xpath = "//span[text()='Delete']/parent::button")
    private SelenideElement buttonDelete;

    private double paymentAmount = Math.random() * 100;
    private String paymentChannel = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    private String inputPaymentDatePickerText;

    public void verifyPaymentInformationIsPopulated() {
        sleep(5000);
        assertTrue(inputPaymentId.isDisplayed() &&
                inputPaymentAmount.isDisplayed() &&
                inputPaymentDatePicker.isDisplayed() &&
                inputPaymentChannel.isDisplayed(), "Is not visible");
    }

    public void verifyFieldsAreEdiatable() {
        sleep(5000);
        $(inputPaymentId).shouldNotBe(Condition.enabled);
        $(inputPaymentAmount).shouldBe(Condition.enabled);
        $(inputPaymentDatePicker).shouldBe(Condition.enabled);
        $(inputPaymentChannel).shouldBe(Condition.enabled);

    }

    public void enterPaymentAmount() {
        $(inputPaymentAmount).clear();
        $(inputPaymentAmount).sendKeys("" + paymentAmount);
    }

    public void enterPaymentChannel() {
        $(inputPaymentChannel).clear();
        $(inputPaymentChannel).sendKeys(paymentChannel);

    }

    public void chooseFirstDay() {
        $(By.xpath(("//div[@class='mat-button-ripple mat-ripple mat-button-ripple-round']/parent::button"))).click();
        sleep(5000);
        $(By.xpath(("//div[text()='1']"))).click();
        inputPaymentDatePickerText=$(inputPaymentDatePicker).getText();
    }

    public void clickUpdate() {

        $(buttonUpdate).click();
        sleep(5000);
    }

    public void checkLastRow() {
        SelenideElement lastString = $(By.xpath("//tbody/tr[last()]"));
        SelenideElement paymentChannel = lastString.$(By.xpath("./td[text()='" + this.paymentChannel + "']"));
        SelenideElement paymentAmount = lastString.$(By.xpath("./td[text()='" + this.paymentAmount + "']"));
        SelenideElement paymentDate = lastString.$(By.xpath("./td[text()='" + this.inputPaymentDatePickerText + "']"));
        assertTrue(paymentChannel.isDisplayed(), "Not visible 1");
        assertTrue(paymentAmount.isDisplayed(), "Not visible 2");
        assertTrue(paymentDate.isDisplayed(), "Not visible 3");
    }

}
