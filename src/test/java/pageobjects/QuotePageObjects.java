package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class QuotePageObjects extends MainPageObject {

    public QuotePageObjects(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Create New Quote')]")
    public WebElement createQuote;

//    @FindAll(
//            {
//             @FindBy(id="MultiNationalId"),
//             @FindBy(id = "NationalId") }
//    )
    @FindBy(id = "vehicle-owner-id")
    public WebElement ownernationalID;

    @FindBy(css = "[id=\"singleInd\"]")
    public WebElement individaul;

    @FindBy(css = "[id=\"singleSme\"]")
    public WebElement singleSME;

    @FindBy(id = "panel1-label")
    public WebElement singleVehicle;

    @FindBy(id="panel2-label")
    public WebElement multiVehicle;

    @FindBy(id = "gregDate0")
    public  WebElement ownerdob;

    @FindBy(id = "hijrDate0")
    public  WebElement hijriownerDOB;

    @FindBy(id = "sequenceNum")
    public WebElement sequenceNumber;

    @FindBy(xpath = "//*[contains(text(),'GET DETAILS')]")
    public WebElement getDetailsButton;


    @FindBy(xpath = "//*[contains(text(),'Generate Quote')]")
    public WebElement GenerateQuoteTitle;

    @FindBy(id = "policy-tab-1-label")
    public  WebElement basciTPL;

    @FindBy(id = "policy-tab-2-label")
    public WebElement supersave;

    @FindBy(id = "policy-tab-3-label")
    public  WebElement comprehensive;

    @FindBy(id = "drivingExperience-1")
    public  WebElement drivingexperience;

    @FindBy(id="drivingUsage-1")
    public WebElement driverusage;

    @FindBy(id = "childrenCount-owner-info")
    public WebElement chidlren;

    @FindBy(id = "occupation-owner-info")
    public WebElement occuption;

    @FindBy(id = "education-owner-info")
    public WebElement education;

    @FindBy(xpath = "//*[contains(text(),'Calculate Premium')]")
    public WebElement submitQuote;

    @FindBy(xpath = "//*[contains(text(),'Save as Draft')]")
    public WebElement saveasDraft;

    @FindBy(xpath = "//*[contains(text(),'Next')]")
    public WebElement nextbutton;

    @FindBy(xpath = "//*[contains(text(),'Policy Customization')]")
    public WebElement policyCustomization;

    @FindBy(xpath = "//*[contains(text(),'Processing please wait ...')]")
    public WebElement quoteprocessing;

    @FindBy(xpath = "//*[@id=\"alert-type\"]")
    public WebElement quoteProcessed;

    //@FindBy(xpath = "//*[contains(text(),'click here']")
    @FindBy(xpath = "//*[@id=\"alert-type\"]/a")
    public WebElement clickquote;

    @FindBy(id = "totalPremium")
    public WebElement premiumAmount;

    @FindBy(xpath = "//*[@class='todaydatetime']")
    public WebElement todaydate;

    @FindBy(xpath = "//*[@class='btn-blue mr20 share-quote-btn']")
    public WebElement sharequotebutton;

    @FindBy(id = "OwnerDriverInfo_Owner_CompanyName")
    public WebElement ownerCompany;

    @FindBy(id = "OwnerDriverInfo_Owner_HomeAddress_CityId")
    public WebElement ownerCity;

    @FindBy(id = "OwnerDriverInfo_Owner_HomeAddress_PostalCode")
    public WebElement ownerPostalCode;

    @FindBy(xpath = "//*[@class=\"sarvalue\"]")
    public WebElement sarValue;

    @FindBy(id = "totalPremium")
    public WebElement totalPremium;

    @FindBy(xpath = "//*[contains(text(),'SHARE QUOTE')]")
    public WebElement sharebutton;

    //@FindBy(id="quote-shared")
    @FindBy(xpath = "//*[@id=\"alert-type\"]/h5")
    public WebElement quoteshared;

    @FindBy(id = "checkbox12")
    public WebElement previousOwnerTransfer;

    @FindBy(id = "previousOwnerId")
    public WebElement previousOwnerId;

    @FindBy(name = "PreviousOwnerDetails.DateOfBirth")
    public  WebElement previousWonerDOB;

    //@FindBy(id="checkbox12")
    @FindBy(xpath = "//*[@name='DrivingInfo.IsCarOwnerMainDriver']//parent::*")
    public WebElement carOwnerMainDriver;

    @FindBy(id = "national-id")
    public WebElement maindriverownerID;

    @FindBy(id = "gregDate00")
    public WebElement mainDriverDOB;

    @FindBy(xpath = "//div[@class=\"timeline-edit\"]/a")
    public WebElement editQUote;

    @FindBy(id = "multiVehicleId")
    public WebElement ultivehicle;

    @FindBy(id = "hijrDate2")
    public WebElement hijrDate;

    @FindBy(id="seqNoId1")
    public WebElement sequenceTwo;

    @FindBy(id="seqNoId2")
    public WebElement sequenceThree;

    @FindBy(xpath = "//*[@id=\"panelc1-label\"]")
    public WebElement multivehicleOne;

    @FindBy(xpath = "//*[@id=\"panelc2-label\"]")
    public WebElement multivehicleTwo;

    @FindBy(xpath = "//*[@id=\"panelc3-label\"]")
    public WebElement multivehicleThree;

    @FindBy(id = "PersonDetails_HomeAddress_Street")
    public WebElement streetname;

    @FindBy(xpath = "//*[@id=\"alert-type\"]/h5")

    public WebElement calcuatingmessage;

    @FindBy(xpath = "//div[@class='verification-alert']")
    public  WebElement calculation;

//    @FindBy(xpath = "//*[@id=\"singleFormID\"]/div[1]/div[1]/div/div/label[2]/span[2]")
  //  @FindBy(xpath = "//*[@id=\"singleFormID\"]/div[1]/div[2]/div/div/label[2]/span[2]")

    @FindAll(
            {
                    @FindBy(xpath = "//*[@id=\"singleFormID\"]/div[1]/div[2]/div/div/label[2]/span[2]"),
                    @FindBy(css = ".checkmark")
            }
    )
    public WebElement smeCheckbox;

    @FindBy(id = "CRNumber")
    public WebElement smeCRNumber;

    @FindBy(xpath = "//div[11]/div[1]/div[3]/select[2]")
    public WebElement individualyear;

    @FindBy(xpath = "//div[11]/div[1]/div[3]/select[1]")
    public WebElement individualmonth;

    @FindBy(xpath = "//div[11]/div[2]/div[5]/button[6]")
    public  WebElement individaulDate;

    //@FindBy(id = "login-username")
    @FindBy(id = "identifierId")
    public WebElement gmailUserName;

    @FindBy(id = "captchaimg")
    public WebElement captchaimg;

    //@FindBy(xpath = "//*[@id=\"identifierNext\"]/span/span")
    @FindBy(xpath = "//*[@class=\"CwaK9\"]")
    public  WebElement nextGButton;

    @FindBy(id = "Ca")
    public  WebElement captchaimagTextBox;
    //*[@id="ca"]

    //@FindBy(className = "CwaK9")
    //@FindBy(xpath = "//*[@id=\"passwordNext\"]/div[2]")
    //@FindBy(id = "login-signin")
    //@FindBy(xpath = "//*[@id=\"login-signin\"]")
    @FindBy(xpath = "//*[@class='orko-button-primary orko-button challenge-button']")
    public WebElement nextGmailButton;

    //@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    //@FindBy(id = "login-passwd")
    @FindBy(xpath = "//*[@class=\"password\"]")
    public WebElement gmailPassword;

    @FindBy(xpath = "//*[@id=\":lx\"]/div[1]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/p[2]/a")
    public WebElement quoteLink;

    @FindAll(
            {
                    @FindBy(xpath = "//*[contains(text(),'رابط الإقتباس')]"),
                    @FindBy(xpath = "//tr[2]/td/table/tbody/tr[2]/td/p[2]/a")
            }
    )
    public WebElement arabicQuoteLink;



    @FindBy(xpath = "//*[@class=\"pro-search-orange\"]/text()")
    public WebElement quottationStatusOrange;









}
