package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaudiCheckPageObjects extends MainPageObject {

    public SaudiCheckPageObjects(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "national-id")
    public WebElement partnernationalid;

    @FindBy(id="getDetails")
    public WebElement partnergetDetails;

    @FindBy(xpath = "//*[contains(text(),\"Saudi Citizen Check\")]")
    public  WebElement saudichecktitle;

    @FindBy(xpath = "//*[contains(text(),\"Enter OTP\")]")
    public WebElement saudiCheckVerifyOTPTitle;

    @FindBy(id = "otpDigit_1")
    public  WebElement FirstOTP;

    @FindBy(id = "otpDigit_2")
    public  WebElement SecondOTP;

    @FindBy(id = "otpDigit_3")
    public  WebElement ThirdOTP;

    @FindBy(id = "otpDigit_4")
    public  WebElement FourthOTP;

    @FindBy(id = "validateOTP")
    public  WebElement validaOTPButton;


   // @FindBy(xpath = "//span[contains(@class,'r-p-name') and contains(text(), 'welcome partner')]")
    @FindBy(xpath = "//div[3]/div[1]/div[1]/div/div[2]/div/div[2]/div[3]/div/a[2]/span")
    public WebElement profileIcon;

    @FindBy(id = "citizenIdentification_NationalId")
    public  WebElement nationalID;

    @FindBy(id = "BasicDetails_FullName")
    public WebElement partnerfullname;

    @FindBy(id = "mobile-popup")
    public WebElement partnermobilenumber;

    @FindBy(id = "gregDate0")
    public  WebElement partnerDOB;


    @FindBy(id = "panel1-label")
    public WebElement basicprofiletab;

    @FindBy(id = "id=panel2-label")
    public WebElement bankaccounttab;

    @FindBy(id = "panel3-label")
    public WebElement documentstab;

    @FindBy(id = "totalPremium")
    public WebElement totalPremium;






}
