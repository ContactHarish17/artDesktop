package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnerProfilePageObjects extends MainPageObject {



    public PartnerProfilePageObjects(WebDriver webDriver)
    {
        super(webDriver);
    }


//    @FindBy(xpath = "//*[contains(text(),\"welcome partner!\")]")
  //  @FindBy(xpath = "//a[@href ='\\Profile\\Profile']/span[1]")
    @FindBy(xpath = "//div/div[2]/div[2]/div/a[2]/span[1]")
    public WebElement welcomepartner;

    @FindBy(xpath = "//*[contains(text(),'Update Profile')]")
    public  WebElement updateprofileText;

    @FindBy(id = "panel1-label")
    public WebElement basicprofile;

    @FindBy(id = "panel2-label")
    public WebElement bankaccount;

    @FindBy(id = "panel3-label")
    public WebElement otherdocuments;

    @FindBy(xpath = "//*[@id=\"panel4-label\"]/div")
    public WebElement  accountpref;

    @FindBy(xpath = "//*[@id=\"tab-0\"]/form/div/div[1]/div[1]/div[2]/div/h4")
    public WebElement nationalIDDoc;

    @FindBy(xpath = "//*[@id=\"tab-0\"]/form/div/div[2]/div/div[2]/div/h4")
    public WebElement ifcecertDoc;

    @FindBy(xpath = "//*[@id=\"tab-0\"]/form/div/div[1]/div[2]/div[2]/div/h4")
    public WebElement educationDoc;


    @FindBy(xpath = "//*[contains(text(),\"Update Profile\")]")
    public WebElement updateprofile;

    @FindBy(css = "select[id=\"PreferedGender\"]")
    public  WebElement preferedGender;

    @FindBy(css = "select[id=\"MediumOfEngagement\"]")
    public  WebElement mediumOfEngagement;

//    @FindBy(id = "rdnfur-accordion-label")
    @FindBy(xpath = "//*[contains(text(),\"Privacy Settings\")]")
    public WebElement privacysettings;



    @FindBy(css = "input[name=\"ShowBasicProfile\"][type=\"checkbox\"]")
    public WebElement showbasicprofile;

    @FindBy(css = "input[name=\"ShowProfilePicture\"][type=\"checkbox\"]")
    public WebElement showProfilePicture;

    @FindBy(css = "input[name=\"ShowWorkAndEdu\"][type=\"checkbox\"]")
    public WebElement showWorkAndEdu;

    @FindBy(css = "input[name=\"ShowSocialMedia\"][type=\"checkbox\"]")
    public WebElement showSocialMedia;

    @FindBy(xpath = "//*[@id=\"panel1\"]/div/div[2]/div[6]")
    public WebElement maleGender;

    @FindBy(xpath = "//*[contains(text(),\"Verify Email\")]")
    public WebElement verifyEmailButton;

    @FindBy(xpath = "//*[contains(text(),\" Work Location \")]")
    //@FindBy(xpath = "//*[@id=\"4lgkq0-accordion-label\"]/div/h3")
    public WebElement workLocation;

    @FindBy(xpath = "//*[contains(text(),\"National Address\")]")
    public WebElement nationaladdress;

    @FindBy(id = "WorkRegion")
    public WebElement workRegion;

    @FindBy(id = "WorkCity")
    public  WebElement workcity;

    @FindBy(id = "building-num")
    public WebElement buildingNumber;

    @FindBy(id = "street")
    public WebElement addressStreet;

    @FindBy(id = "district")
    public WebElement district;

    @FindBy(id = "postal-code")
    public WebElement postcalcode;

    @FindBy(id = "dp_b_profile_DOB")
    public WebElement profileDOB;

    @FindBy(id = "BasicDetails_FullName")
    public WebElement Prospectfullname;

    @FindBy(id = "mobile-popup")
    public WebElement mobilepopup;

    @FindBy(id = "citizenIdentification_NationalId")
    public WebElement nationalID;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "jobtitle")
    public WebElement jobtitle;

    @FindBy(id = "education")
    public WebElement education;

    @FindBy(id = "profession")
    public WebElement profession;

    @FindBy(id = "linkedin")
    public WebElement linkedin;

    @FindBy(xpath = "//*[@id=\"tab-2\"]/div/div[1]/div/img")
    public WebElement linkedinIcon;

    @FindBy(id = "twitter")
    public WebElement twitter;

    @FindBy(xpath = "//*[@id=\"tab-2\"]/div/div[2]/div/img")
    public WebElement twitterIcon;

    @FindBy(id = "instagram")
    public WebElement instagram;

    @FindBy(xpath = "//*[@id=\"tab-2\"]/div/div[3]/div/img")
    public WebElement instagramIcon;

    @FindBy(xpath = "//*[contains(text(),\"Documents (Optional)\")]")
    public WebElement documents;

    @FindBy(xpath = "//*[contains(text(),\"Work Experience & Education (Optional)\")]")
    public WebElement workExperience;

    @FindBy(xpath = "//*[contains(text(),\"Social Media (Optional)\")]")
    public WebElement socialMedia;

    @FindBy(xpath = "//*[@id=\"saveChangesDocument\"]")
    public WebElement saveButon;

    @FindBy(xpath = "//*[contains(text(),'Go')]")
    public  WebElement contactquote;

    @FindBy(xpath = "//*[contains(text(),'View Quote Now')]")
    public  WebElement viequote;

    @FindBy(xpath = "//*[contains(text(),'Send A Reminder')]")
    public WebElement sendreminderButton;

    @FindBy(xpath = "//*[@class='pro-search-orange']/text()")
    public WebElement quotestatustext;

    @FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[2]/ul/li[1]/b")
    public WebElement quoteAmount;

    @FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[2]/ul/li[3]")
    public WebElement policyType;

    @FindBy(xpath = "//*[@class=\"pro-search-date\"]/text()")
    public WebElement quoreSharedDate;

    @FindBy(xpath = "//*[contains(text(),'Basic (TPL)')]")
    public WebElement producttype;

    @FindBy(xpath = "//*[@id=\"singleFormID\"]/div[1]/div[3]/div/div/label[2]/span")
    public WebElement customID;

    @FindBy(id = "customNum")
    public WebElement customNumber;

    @FindBy(id = "vehicleYear")
    public WebElement vehicleYear;

    @FindBy(id="bank-iban")
    public WebElement bankIban;

    @FindBy(id = "IBAN")
    public WebElement enterIban;

    @FindBy(id = "accountHolderName")
    public WebElement accountHolderName;

    @FindBy(id = "btnSave")
    public  WebElement ibanSaveButton;

    @FindBy(xpath = "//*[contains(text(),'Enter OTP')")
    public  WebElement iBanOTP;

    @FindBy(id = "otpDigit_1")
    public  WebElement OTP1;

    @FindBy(id = "otpDigit_2")
    public  WebElement OTP2;

    @FindBy(id = "otpDigit_3")
    public  WebElement OTP3;

    @FindBy(id = "otpDigit_4")
    public  WebElement OTP4;

    @FindBy(id = "validateOTP")
    public WebElement iBanOTPValidate;

    //@FindBy(id = "nationalId")
    //*[@id="tab-0"]/form/div/div[1]/div[1]/div[1]/label[2]
    //@FindBy(xpath = "//*[@id=\"tab-0\"]/form/div/div[1]/div[1]/div[1]/label[2]")
    @FindBy(xpath = "//*[@id=\"nationalId\"]")
    public WebElement IdCopy;

    //@FindBy(xpath = "//*[@id=\"tab-0\"]/form/div/div[1]/div[2]/div[1]/label[2]")
    @FindBy(id = "se-certificate")
    public WebElement seCopy;

    @FindBy(id = "ifce-certificate")
   // @FindBy(xpath = "//*[@id=\"tab-0\"]/form/div/div[2]/div/div[1]/label[2]")
    public  WebElement ifceCopy;

    @FindBy(id = "linkedin")
    public WebElement Linkedin;

    @FindBy(id = "twitter")
    public WebElement Twitter;

    @FindBy(id = "instagram")
    public  WebElement Instagram;

    @FindBy(id = "tab-0-label")
    public  WebElement documentsSection;

    @FindBy(id = "tab-1-label")
    public WebElement workExperienceSection;

    @FindBy(id = "tab-2-label")
    public  WebElement socialMediaSection;


}
