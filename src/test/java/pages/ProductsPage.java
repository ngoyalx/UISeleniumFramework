package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseWebPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BaseWebPage {

    By allProducts = By.xpath("//p[@class='font-weight-bold top-space-10']");
    By productPrice = By.xpath("following-sibling::p");
    By cart = By.xpath("//span[@id='cart']");


    /***
     * select cheapest product based on the current product page(moisturizer or sunscreen)
     */
    public void addProducts(){
        if(getProductSelected().equalsIgnoreCase("moisturizer")){
            selectCheapestProducts("Aloe", "Almond");
        }else if(getProductSelected().equalsIgnoreCase("sunscreen")){
            selectCheapestProducts("SPF-50", "SPF-30");
        }
    }

    /**
     * Add the cheapest products to the cart
     * @param product1
     * @param product2
     */
    public void selectCheapestProducts(String product1, String product2){
        List<WebElement> allProducts1 = driver.findElements(allProducts);
        List<WebElement> product1List = getFilteredProductsByName(allProducts1,product1);
        List<WebElement> product2List = getFilteredProductsByName(allProducts1, product2);
        List<String> product1PriceList = getPriceList(product1List);
        List<String> product2PriceList = getPriceList(product2List);
        clickAddButton(getCheapestProductPrice(product1PriceList));
        clickAddButton(getCheapestProductPrice(product2PriceList));
    }

    /**
     * filters the products from all products based on the name
     * @param allProducts
     * @param productName
     * @return
     */
    private List<WebElement> getFilteredProductsByName(List<WebElement> allProducts, String productName){
        return allProducts.stream()
                .filter(product -> product.getText().contains(productName)).collect(Collectors.toList());
    }

    /**
     * gives back the price list of all products
     * @param productList
     * @return
     */
    private List<String> getPriceList(List<WebElement> productList){
        List<String> priceList = new ArrayList<>();
        for (WebElement webElement : productList) {
            String[] priceArray = webElement.findElement(productPrice).getText().split(" ");
            String priceStr = priceArray[priceArray.length - 1];
            priceList.add(priceStr);
        }
        return priceList;
    }

    /***
     * return the cheapest product price
     * @param priceList
     * @return
     */
    private String getCheapestProductPrice(List<String> priceList){
        int cheapestProductIndex = priceList.indexOf(Collections.min(priceList));
        return priceList.get(cheapestProductIndex);
    }

    void clickAddButton(String price){
        driver.findElement(By.xpath("//p[@class='font-weight-bold top-space-10']/following-sibling::p[contains(text(),"+price+")]/following-sibling::button")).click();
    }

    public PaymentPage clickCartButton() throws InterruptedException {
        driver.findElement(cart).click();
        Thread.sleep(2000);
        return new PaymentPage();
    }
}
