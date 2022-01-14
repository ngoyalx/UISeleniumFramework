package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebPage {

    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    public static String productSelected;
    public static WebDriverWait wait;

    public static void setProductSelected(String productSelected) {
        BaseWebPage.productSelected = productSelected;
    }

    public static String getProductSelected() {
        return productSelected;
    }

    public static void setWait(WebDriverWait wait) {
        BaseWebPage.wait = wait;
    }
}
