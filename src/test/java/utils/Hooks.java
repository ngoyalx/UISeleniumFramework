package utils;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks extends BaseWebPage {

    @Before
    public void startWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        BaseWebPage.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        setWait(wait);
        maximizeBrowser();
    }

    @After
    public void quitWebDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    private ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("allow-file-access-from-files");
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--enable-automation");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("test-type=browser");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-background-networking");
        options.addArguments("--disable-client-side-phishing-detection");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-hang-monitor");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-prompt-on-repost");
        options.addArguments("--disable-sync --disable-web-resources --enable-logging --force-fieldtrials=SiteIsolationExtensions/Control --log-level=0 --metrics-recording-only --no-first-run --password-store=basic --safebrowsing-disable-auto-update --test-type=webdriver --use-mock-keychain");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        if (System.getProperty("browserMode").equalsIgnoreCase("headless")) {
            options.addArguments("--headless");
        }
        if (System.getProperties().containsKey("chromeBinary")) {
            options.setBinary(System.getProperty("chromeBinary"));
        }
        options.setExperimentalOption("useAutomationExtension", false);
        return options;
    }

    private void maximizeBrowser() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
