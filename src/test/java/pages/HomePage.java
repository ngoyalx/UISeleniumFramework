package pages;

import org.openqa.selenium.By;
import utils.BaseWebPage;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseWebPage {

    By currentTemperature = By.xpath("//span[@id='temperature']");
    By moisturizersButton = By.xpath("//a[@href='/moisturizer']");
    By sunscreensButton = By.xpath("//a[@href='/sunscreen']");

    public Integer getCurrentTemperature(){
       return Integer.parseInt(driver.findElement(currentTemperature).getText().split(" ")[0]);
    }

    public ProductsPage selectProduct(){
        System.out.println("current temp is " + getCurrentTemperature());
        if(getCurrentTemperature() <= 19){
            selectMoisturizer();
            setProductSelected("moisturizer");
        }else if(getCurrentTemperature() >= 34){
            selectSunscreen();
            setProductSelected("sunscreen");
        }
        return new ProductsPage();
    }

    public void selectMoisturizer(){
       driver.findElement(moisturizersButton).click();
    }

    public void selectSunscreen(){
        driver.findElement(sunscreensButton).click();
    }

    public void openHomePage() throws InterruptedException {
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
