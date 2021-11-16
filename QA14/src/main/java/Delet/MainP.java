package Delet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainP {

    @FindBy(xpath = "//a[@title='My eBay']")
    private WebElement account;
    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private WebElement searchField;
    @FindBy(xpath = "//input[@value='Search']")
    private WebElement buttonForSearching;

}
