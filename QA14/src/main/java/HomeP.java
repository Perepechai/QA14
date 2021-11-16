import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeP {
    @FindBy(xpath = "//input[@name = 'search']")
    private WebElement searchInput;
    @FindBy(xpath = "//h3[@class=\"s-item__title\"]")
    private WebElement searchTitle;
}
