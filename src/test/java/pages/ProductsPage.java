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
    public void addProducts() throws InterruptedException {
        if(getProductSelected().equalsIgnoreCase("moisturizer")){
            setPriceForAloeProduct(getLeastExpensiveProductPrice("Aloe"));
            setPriceForAlmondProduct(getLeastExpensiveProductPrice("Almond"));
            Thread.sleep(2000);
            selectLeastExpensiveProducts(getLeastExpensiveProductPrice("Aloe"));
            Thread.sleep(3000);
            selectLeastExpensiveProducts(getLeastExpensiveProductPrice("Almond"));
            Thread.sleep(3000);
        }else if(getProductSelected().equalsIgnoreCase("sunscreen")){
            setPriceForSPF30Product(getLeastExpensiveProductPrice("SPF-30"));
            setPriceForSPF50Product(getLeastExpensiveProductPrice("SPF-50"));
            Thread.sleep(2000);
            selectLeastExpensiveProducts(getLeastExpensiveProductPrice("SPF-30"));
            Thread.sleep(3000);
            selectLeastExpensiveProducts(getLeastExpensiveProductPrice("SPF-50"));
            Thread.sleep(3000);
        }
    }

    /**
     * Add the least expensive products to the cart
     * @param price
     */
    public void selectLeastExpensiveProducts(String price){
        clickAddButton(price);
    }

    private String getLeastExpensiveProductPrice(String product){
        List<WebElement> allProducts1 = driver.findElements(allProducts);
        List<WebElement> product1List = getFilteredProductsByName(allProducts1,product);
        List<String> product1PriceList = getPriceList(product1List);
        return getLeastExpensiveProductPrice(product1PriceList);
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
    private String getLeastExpensiveProductPrice(List<String> priceList){
        int leastExpensiveProductIndex = priceList.indexOf(Collections.min(priceList));
        return priceList.get(leastExpensiveProductIndex);
    }

    void clickAddButton(String price){
        driver.findElement(By.xpath("//p[@class='font-weight-bold top-space-10']/following-sibling::p[contains(text(),'"+price+"')]/following-sibling::button")).click();
    }

    public PaymentPage clickCartButton() throws InterruptedException {
        driver.findElement(cart).click();
        Thread.sleep(2000);
        return new PaymentPage();
    }
}
