import factortyEx.DriverType;
import factortyEx.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.ResultPage;
import pageObject.SearchResultPage;
import pageObject.old.MainPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class SimpleTest {
    WebDriver driver;
    WebDriverFactory driverFactory = new WebDriverFactory();

    @BeforeTest
    public void setup() {
        driver = driverFactory.createWebDriver(DriverType.CHROME);
    }

    @Test
    public void test1(){
        String query = "наушники";
        String result;
        HomePage homePage = new HomePage(driver);
        result = homePage.openPage()
                .findSearchField()
                .searchProduct(query)
                .getProductTitle();
        Assert.assertTrue(result.contains(query));
    }
    @Test
    public void test2(){
        String query = "наушники";
        String result;
        ResultPage resultPage;
        CartPage cartPage;
        HomePage homePage = new HomePage(driver);
        resultPage = homePage.openPage()
                .findSearchField()
                .searchProduct(query)
                .selectProduct();
        cartPage = resultPage.buyProduct();
        result = cartPage.getProductTitle();
        Assert.assertTrue(result.contains(query));
    }
    @Test
    public void test3(){
        String query = "наушники";
        String result;
        ResultPage resultPage;
        HomePage homePage = new HomePage(driver);
        resultPage = homePage.openPage()
                .findSearchField()
                .searchProduct(query)
                .selectProduct();
        result = resultPage.getPrice();
        Assert.assertTrue(result.contains("82.63"));
    }
    @Test
    public void test4(){
        String query = "наушники";
        String result;
        ResultPage resultPage;
        HomePage homePage = new HomePage(driver);
        resultPage = homePage.openPage()
                .findSearchField()
                .searchProduct(query)
                .selectProduct();
        resultPage.addProduct();
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result)
    {
        if (!result.isSuccess())
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        driver.quit();
    }
}
