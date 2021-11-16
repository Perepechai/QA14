import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultP {
    @FindBy(xpath = "//a[@id=\"isCartBtn_btn\"]")
    private WebElement searchBuyButton;
    @FindBy(xpath = "//span[@class=\"notranslate\"]")
    private WebElement searchPrice;
    @FindBy(xpath = "//div[@id=\"vi-atl-lnk\"]")
    private WebElement searchAddButton;
}
