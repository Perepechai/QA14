package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage  extends BasePage {
    @FindBy(xpath = "//a[@id=\"isCartBtn_btn\"]")
    private WebElement searchBuyButton;
    @FindBy(xpath = "//span[@class=\"notranslate\"]")
    private WebElement searchPrice;
    @FindBy(xpath = "//div[@id=\"vi-atl-lnk\"]")
    private WebElement searchAddButton;
    public ResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CartPage buyProduct()
    {
        String url = searchBuyButton.getAttribute("href");
        driver.get(url);
        return new CartPage(driver);
    }
    public String getPrice()
    {
        //String url = searchBuyButton.getAttribute("href");
        String price = searchPrice.getText();
        return price;
    }
    public ResultPage addProduct()
    {
        searchAddButton.click();
        return this;
    }
//    public String getProductColors(){
//        driver.findElement(helpClick).click();
//        return driver.findElement(productColorTitle).getText();
//    }
//    public String getProductCharacter() {
//        driver.findElement(helpClick).click();
//        return driver.findElement(productCharacter).getText();
//    }

}
