package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProspectPageObjects extends MainPageObject {

    AddProspectPageObjects(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//div[3]/div/div[1]/div/div[1]/div/div[2]/a[2]")
    public WebElement addasprospect;


}
