package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebPage {

    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    public static String productSelected;
    public static String aloePrice;
    public static String almondPrice;
    public static String SPF_30_Price;
    public static String SPF_50_Price;
    public static WebDriverWait wait;

    public static void setWait(WebDriverWait wait) {
        BaseWebPage.wait = wait;
    }

    public static void setProductSelected(String productSelected) {
        BaseWebPage.productSelected = productSelected;
    }

    public static String getProductSelected() {
        return productSelected;
    }

    public static void setPriceForAloeProduct(String price) { BaseWebPage.aloePrice = price; }

    public static void setPriceForAlmondProduct(String price) {
        BaseWebPage.almondPrice = price;
    }

    public static void setPriceForSPF30Product(String price) { BaseWebPage.SPF_30_Price = price; }

    public static void setPriceForSPF50Product(String price) { BaseWebPage.SPF_50_Price = price; }

    public static String getAloePrice() { return aloePrice; }

    public static String getAlmondPrice() { return almondPrice; }

    public static String getSPF_30_Price() {
        return SPF_30_Price;
    }

    public static String getSPF_50_Price() {
        return SPF_50_Price;
    }
}
