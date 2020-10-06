package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPageObjects extends MainPageObject {

    public ErrorPageObjects(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//*[@class=\"showValidationSummary form-error is-visible mt20\"]")
    public WebElement otperrormessage;

    @FindBy(id = "mobileNumber-error")
    public WebElement mobilenumberError;

    @FindBy(id = "ConsentCheckBox-error")
    public WebElement consentCheckboxError;

    @FindBy(id = "FullName-error")
    public WebElement fullnameError;

    @FindBy(id="MobileNumber-error")
    public WebElement contactmobilenumberError;

    @FindBy(id = "noErr")
    public WebElement noactiivitycontacterror;

    @FindBy(xpath = "//*[contains(text(),\"Please select the Activity Title!\")]")
    public WebElement activitytitleError;

    @FindBy(xpath = "//*[contains(text(),\"Please select the Activity Type!\")]")
    public WebElement activityTypeError;

    @FindBy(xpath = "//*[contains(text(),\"Please enter the valid date format!\")]")
    public WebElement activitydateError;

    @FindBy(xpath = "//*[contains(text(),\"Please enter the valid time!\")]")
    public WebElement activitytimeError;

    @FindBy(xpath = "//*[contains(text(),'Invalid or Expired OTP')]")
    public WebElement invalidOTP;

    @FindBy(xpath = "//*[@id=\"97BFCD5A-E336-4417-9BDB-CD1CE64E7019\"]/form/div[3]")
    public WebElement entervalidOTP;
}
