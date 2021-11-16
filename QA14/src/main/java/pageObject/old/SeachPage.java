package pageObject.old;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SeachPage {

    WebDriver driver;

    @FindBy(xpath = "//h3[contains(text(), 'Apple iPhone 12 Pro MAX 512GB Graphite Unlocked')]")
    private WebElement iphone;


    public SeachPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyIphonePresented() {
        Assert.assertTrue(iphone.isDisplayed());
    }
}
