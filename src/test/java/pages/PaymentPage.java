package pages;

import org.junit.Assert;
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

    /**
     * compare and validate the prices of products added in the cart is as per product page
     */
    public void verifyProductPrices(){
        if(getProductSelected().equalsIgnoreCase("moisturizer")){
            Assert.assertEquals("Aloe price not matched", getAloePrice(), getPriceForProductInCart("Aloe"));
            Assert.assertEquals("Almond price not matched", getAlmondPrice(), getPriceForProductInCart("Almond"));
        }else if(getProductSelected().equalsIgnoreCase("sunscreen")){
            Assert.assertEquals("SPF-30 price not matched", getSPF_30_Price(), getPriceForProductInCart("30"));
            Assert.assertEquals("SPF-50 price not matched", getSPF_50_Price(), getPriceForProductInCart("50"));
        }
    }

    public String getPriceForProductInCart(String product){
        return driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[contains(text(),'"+product+"')]/following-sibling::td")).getText();
    }

    /***
     * method to fill in credit card details on the payment page
     * @return
     * @throws InterruptedException
     */
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
        Thread.sleep(5000);
        return new ConfirmationPage();
    }

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

}
