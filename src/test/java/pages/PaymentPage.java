package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseWebPage;

public class PaymentPage extends BaseWebPage {

    By paymentButton = By.xpath("//button[@type='submit']/span");
    By email = By.xpath("//input[@id='email']");
    By cardNumber = By.xpath("//input[@id='card_number']");
    By expiry = By.xpath("//input[@id='cc-exp']");
    By cvv = By.xpath("//input[@id='cc-csc']");
    By zipcode = By.xpath("//input[@id='billing-zip']");
    By payButton = By.xpath("//span[@class='iconTick']");

    void waitAndClickElement(By element){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).click();
    }

    void waitAndTypeInElement(By element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).sendKeys(text);
        Thread.sleep(2000);
    }

    void clickElement(By element){
        driver.findElement(element).click();
    }

    public ConfirmationPage makePayment() throws InterruptedException {
        waitAndClickElement(paymentButton);
        driver.switchTo().frame("stripe_checkout_app");
        waitAndTypeInElement(email, "test@test.com");
        waitAndTypeInElement(cardNumber,"4242");
        waitAndTypeInElement(cardNumber,"4242");
        waitAndTypeInElement(cardNumber,"4242");
        waitAndTypeInElement(cardNumber,"4242");
        waitAndTypeInElement(expiry, "11");
        waitAndTypeInElement(expiry, "25");
        waitAndTypeInElement(cvv,"345");
        waitAndTypeInElement(zipcode,"1005");
        clickElement(payButton);
        clickElement(payButton);
        return new ConfirmationPage();
    }
}
