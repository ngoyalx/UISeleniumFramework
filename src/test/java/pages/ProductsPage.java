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


    public void addProducts(){
        if(getProductSelected().equalsIgnoreCase("moisturizer")){
            selectCheapestMoisturizers();
        }else if(getProductSelected().equalsIgnoreCase("sunscreen")){
            selectCheapestSunscreens();
        }
    }

    public void selectCheapestMoisturizers(){
        List<WebElement> allProducts1 = driver.findElements(allProducts);
        List<WebElement> aloeProducts;
        List<WebElement> almondProducts;
        aloeProducts = allProducts1.stream().filter(product -> product.getText().contains("Aloe")).collect(Collectors.toList());
        almondProducts = allProducts1.stream().filter(product -> product.getText().contains("Almond")).collect(Collectors.toList());
        List<String> aloePrices = new ArrayList<>();
        List<String> almondPrices = new ArrayList<>();

        for(int i=0; i<aloeProducts.size();i++){
            String aloePriceArray[] = aloeProducts.get(i).findElement(productPrice).getText().split(" ");
            String aloePriceStr = aloePriceArray[aloePriceArray.length-1];
            aloePrices.add(aloePriceStr);
        }

        for(int i=0; i<almondProducts.size();i++){
            String almondPriceArray[] = almondProducts.get(i).findElement(productPrice).getText().split(" ");
            String almondPriceStr = almondPriceArray[almondPriceArray.length-1];
            almondPrices.add(almondPriceStr);
        }

        int cheapestAloeMoisturizerIndex = aloePrices.indexOf(Collections.min(aloePrices));
        String cheapestAloeMoisturizerPrice = aloePrices.get(cheapestAloeMoisturizerIndex);
        int cheapestAlmondMoisturizerIndex = almondPrices.indexOf(Collections.min(almondPrices));
        String cheapestAlmondMoisturizerPrice = almondPrices.get(cheapestAlmondMoisturizerIndex);
        clickAddButton(cheapestAloeMoisturizerPrice);
        clickAddButton(cheapestAlmondMoisturizerPrice);
    }

    public void selectCheapestSunscreens(){
        List<WebElement> allProducts1 = driver.findElements(allProducts);
        List<WebElement> SPF50Products = new ArrayList<>();
        List<WebElement> SPF30Products = new ArrayList<>();
        SPF50Products = allProducts1.stream().filter(product -> product.getText().contains("SPF-50")).collect(Collectors.toList());
        SPF30Products = allProducts1.stream().filter(product -> product.getText().contains("SPF-30")).collect(Collectors.toList());
        List<String> SPF50Prices = new ArrayList<>();
        List<String> SPF30Prices = new ArrayList<>();

        for(int i=0; i<SPF50Products.size();i++){
            String SPF50PriceArray[] = SPF50Products.get(i).findElement(productPrice).getText().split(" ");
            String SPF50PriceStr = SPF50PriceArray[SPF50PriceArray.length-1];
            SPF50Prices.add(SPF50PriceStr);
        }

        for(int i=0; i<SPF30Products.size();i++){
            String SPF30PriceArray[] = SPF30Products.get(i).findElement(productPrice).getText().split(" ");
            String SPF30PriceStr = SPF30PriceArray[SPF30PriceArray.length-1];
            SPF30Prices.add(SPF30PriceStr);
        }

        int cheapestAloeMoisturizerIndex = SPF50Prices.indexOf(Collections.min(SPF50Prices));
        String cheapestAloeMoisturizerPrice = SPF50Prices.get(cheapestAloeMoisturizerIndex);
        int cheapestAlmondMoisturizerIndex = SPF30Prices.indexOf(Collections.min(SPF30Prices));
        String cheapestAlmondMoisturizerPrice = SPF30Prices.get(cheapestAlmondMoisturizerIndex);
        clickAddButton(cheapestAloeMoisturizerPrice);
        clickAddButton(cheapestAlmondMoisturizerPrice);
    }

    void clickAddButton(String price){
        driver.findElement(By.xpath("//p[@class='font-weight-bold top-space-10']/following-sibling::p[contains(text(),"+price+")]/following-sibling::button")).click();
    }

    public PaymentPage clickCartButton() throws InterruptedException {
        driver.findElement(cart).click();
        Thread.sleep(1000);
        return new PaymentPage();
    }
}
