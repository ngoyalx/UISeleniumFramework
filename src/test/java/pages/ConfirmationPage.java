package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseWebPage;

public class ConfirmationPage extends BaseWebPage {

    By successMessage = By.xpath("//div[@class='row justify-content-center']/h2");

    private String waitAndGetTextFromElement(By element){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).getText();
    }

    public void verifyPaymentIsSuccessful(){
        Assert.assertEquals("Payment was not successful", "PAYMENT SUCCESS", waitAndGetTextFromElement(successMessage));
    }
}
