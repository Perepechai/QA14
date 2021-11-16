package factortyEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public WebDriver createWebDriver(DriverType driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case IE:
                driver = createIEDriver();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory");
        }
        return driver;
    }
    protected WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver1;
    }
    protected WebDriver createIEDriver() {
        System.setProperty("webdriver.IE.driver", "drivers/IEDriverServer.exe");
        WebDriver driver1 = new InternetExplorerDriver();
        driver1.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        return driver1;
    }
}
