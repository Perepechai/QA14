package pageObject.old;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='My eBay']")
    private WebElement account;
    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private WebElement searchField;
    @FindBy(xpath = "//input[@value='Search']")
    private WebElement buttonForSearching;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openPage() {
        driver.get("https://www.ebay.com/");
        return this;
    }

    public MainPage findSearchField() {
        searchField.isDisplayed();
        searchField.click();
        return this;
    }

    public SeachPage searchForIphone() {
        searchField.sendKeys("Apple iPhone 12 Pro MAX 512GB Graphite Unlocked");
        buttonForSearching.click();
        return new SeachPage(driver);
    }

}
