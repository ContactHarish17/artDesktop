package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ContactPageObject extends  MainPageObject{


    public ContactPageObject(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//div[3]/div[1]/div[2]/div[3]/div/div[1]/div/div/a")
    public WebElement buyingforMyself;

    @FindBy(css = "input[id='FullName']")
    public WebElement fullname;

    @FindBy(css = "input[id='MobileNumber']")
    public  WebElement mobilenumber;

    @FindBy(css = "input[id='EmailAddress']")
    public WebElement emailaddress;

//    @FindBy(xpath = "//*[@id=\"addContact\"]/form/a")
//    public WebElement addmoreDetails;

    @FindBy(id = "OtherDetail_Organisation")
    public WebElement organisation;

    @FindBy(id = "OtherDetail_JobTitle")
    public  WebElement jobtitle;

    @FindBy(id = "OtherDetail_Spouses")
    public WebElement spouses;

    @FindBy(id = "OtherDetail_kids")
    public WebElement kids;

    @FindBy(id = "OtherDetail_NationalID")
    public WebElement nationalID;

    @FindBy(id = "OtherDetail_Twitter")
    public WebElement twitter;

    @FindBy(id="OtherDetail_LinkedIn")
    public WebElement linkedin;

    @FindBy(id = "OtherDetail_MaritalStatus")
    public WebElement martialstatus;

    @FindBy(id = "Motor")
    public WebElement motorproduct;

    @FindBy(id = "Medical")
    public WebElement medicalproduct;

    @FindBy(id = "Travel")
    public WebElement travelproduct;

    @FindBy(id = "Medical Malpractice")
    public WebElement medicalmalpracticeproduct;

    //@FindBy(xpath = "//*[contains(text(),'Add more details?')]")
    @FindBy(xpath = "//*[@id=\"addContact\"]/form/a")
    public WebElement addmoreDetails;

    @FindBy(xpath = "//*[contains(text(),'Cancel')]")
    public WebElement cancelButton;

   // @FindBy(xpath = "//*[contains(text(),'Save')]")
    @FindBy(xpath = "//*[@class=\"btn-blue save-btn-cls\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[2]/div[3]/div/div[1]/div/div[2]/button")
    public WebElement makepaymentButton;

//    @FindAll(
//            {
//                    @FindBy(xpath = "//*[@class={\"text-center c-list-button-b\"]/a[2]"),
//                    @FindBy(xpath = "//*[contains(text(),'Add More ...')]")
//            }
//    )
    @FindBy(xpath = "//*[contains(text(),'Add More ...')]")
    public WebElement addmorebutton;

//    @FindAll(
//            {
//                    @FindBy(xpath = "//*[@class={\"text-center c-list-button-b\"]/a[1]"),
//                    @FindBy(xpath = "//*[contains(text(),'BUY FOR YOURSELF')]")
//            }
//    )
    @FindBy(xpath = "//*[contains(text(),'BUY FOR YOURSELF')]")
    public WebElement buyYourSelfbutton;

    //@FindBy(xpath = "//div[3]/div/div[1]/div/div[1]/div[1]/div[2]/a[2]")
    @FindBy(xpath = "//*[@data-contacttype=\"Contact\"]")
    public WebElement addProspectButton;

    @FindBy(xpath = "//*[@class=\"button not-active\"]")
    public WebElement prospectbutton;

    @FindBy(xpath = "//*[contains(text(),\"HarishRamakrishna\")]")
    public WebElement addedProspectContactName;

    @FindBy(xpath = "//*[contains(text(),\"Krishna\")]")
    public WebElement addedSecondContact;

    @FindBy(xpath = "//*[contains(text(),\"Sameer Rajaram\")]")
    public WebElement addedThirdContact;

    @FindBy(xpath="//*[@class=\"contact-dot\"]/a")
    public WebElement modifyContact;

    @FindBy(xpath = "//*[@id=\"Modify-Contact-0\"]/ul/li[1]/a")
    public WebElement editContact;

    @FindBy(xpath = "//*[@id=\"Modify-Contact-0\"]/ul/li[2]/a")
    public WebElement deletecontact;

    @FindBy(xpath = "//*[@id=\"Modal-A7ADFCD0-C29F-4F75-AF91-C921D3F5C219\"]/div/a[1]")
    public WebElement confirmdelete;

    @FindBy(xpath = "//*[@id=\"Modal-A7ADFCD0-C29F-4F75-AF91-C921D3F5C219\"]/div/a[2]")
    public WebElement nodelete;

    @FindBy(xpath = "//*[@id=\"Modal-A7ADFCD0-C29F-4F75-AF91-C921D3F5C219\"]/div/p/span")
    public WebElement confirmdeletemessage;

   @FindBy(xpath = "//*[@id=\"addContact\"]/form/h2")
    public WebElement editContactText;

   @FindBy(id = "OtherDetail_MaritalStatus")
   public WebElement maritalStatusfilter;

   @FindBy(xpath = "//*[@class=\"contact-nos-cls\"]/text()")
   public WebElement contactCount;

   @FindBy(xpath = "//*[@class=\"contact-list\"]/h2/text()")
    public WebElement contactTitle;


   @FindBy(xpath = "//*[@class=\"text-center c-list-button-b\"]/a[2]")
    public WebElement addmoreContacts;


   @FindBy(xpath = "//*[@class=\"grid-x contacts-list-prospect\"][3]/div[2]/div")
    public WebElement thirdcontact;

   @FindBy(xpath = "//*[@class=\"grid-x contacts-list-prospect\"][1]/div[2]/div")
    public WebElement contactEdit;

   @FindBy(id = "contactSearch")
    public WebElement contactSearch;

   @FindBy(xpath = "//*[contains(text(),\"ADD CONTACT\")]")
    public  WebElement AddContactButton;






}
