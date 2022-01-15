package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseWebPage;

public class ConfirmationPage extends BaseWebPage {

    By successMessage = By.xpath("//div[@class='row justify-content-center']/h2");

    /***
     * verify the payment success message on the confirmation page
     */
    public void verifyPaymentIsSuccessful(){
        waitAndGetTextFromElement(successMessage);
        Assert.assertEquals("Payment was not successful", "PAYMENT SUCCESS", waitAndGetTextFromElement(successMessage));
    }

    private String waitAndGetTextFromElement(By element){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).getText();
    }
}
