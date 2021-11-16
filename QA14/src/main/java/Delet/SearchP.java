package Delet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchP {

    @FindBy(xpath = "//h3[contains(text(), 'Apple iPhone 12 Pro MAX 512GB Graphite Unlocked')]")
    private WebElement iphone;
}
