package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductsPage;

public class ShoppingSteps {

    HomePage homePage = new HomePage();
    ProductsPage productsPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;

    @Given("I am on weather shopper home page")
    public void iAmOnWeatherShopperHomePage() throws InterruptedException {
        homePage.openHomePage();
    }

    @When("I select product to cart based on temperature")
    public void iSelectProductToCartBasedOnTemperature() {
        productsPage = homePage.selectProduct();
    }

    @And("I add cheapest products to cart")
    public void iAddCheapestProductsToCart() {
        productsPage.addProducts();
    }

    @And("I click on Cart")
    public void iClickOnCart() throws InterruptedException {
        paymentPage = productsPage.clickCartButton();
    }

    @And("I make the payment")
    public void iMakeThePayment() throws InterruptedException {
        confirmationPage = paymentPage.makePayment();
    }

    @Then("I verify payment is successful")
    public void iVerifyPaymentIsSuccessful() {
        confirmationPage.verifyPaymentIsSuccessful();
    }
}
