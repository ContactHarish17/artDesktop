package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPageObject {

    WebDriver driver;

    public MainPageObject(WebDriver webDriver)
    {
        this.driver = webDriver;
        PageFactory.initElements(webDriver,this);
    }


}
