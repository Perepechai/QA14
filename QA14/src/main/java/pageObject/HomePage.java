package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {//img[@class="s-item__image-img"]
    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private WebElement searchInput;
    @FindBy(xpath = "//h3[@class=\"s-item__title\"]")
    private WebElement searchTitle;
    @FindBy(xpath = "//div[@class=\"s-item__image\"]//a")
    private WebElement searchProduct;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public HomePage openPage() {
        driver.get("https://www.ebay.com/");
        return this;
    }
    public HomePage findSearchField() {
        searchInput.isDisplayed();
        searchInput.click();
        return this;
    }

    public HomePage searchProduct(String query) {
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }
    public String getProductTitle() {
        String productTitle = searchTitle.getText();
        return productTitle;
    }
    public ResultPage selectProduct() {
        String url = searchProduct.getAttribute("href");
        driver.get(url);
        return new ResultPage(driver);
    }
}
