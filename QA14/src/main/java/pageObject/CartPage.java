package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(xpath = "//span[@class=\"BOLD\"]")
    private WebElement searchTitle;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getProductTitle() {
        String productTitle = searchTitle.getText();
        return productTitle;
    }
}
