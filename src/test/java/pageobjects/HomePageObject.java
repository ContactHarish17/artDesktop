package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends MainPageObject {

    public HomePageObject(WebDriver driver)
    {
        super(driver);
    }

   // @FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[1]/a/span")
    @FindBy(xpath = "//*[contains(text(),'Home')]")
    public WebElement home;

//    @FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[2]/a/span")
   // @FindBy(xpath = "//*[contains(text(),'Contacts')]")
    @FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[2]/a/span")
    public WebElement contacts;

  //  @FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[3]/a/span")
  @FindBy(xpath = "//*[contains(text(),'Prospects')]")
    public WebElement prospects;

    //@FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[4]/a/span")
    @FindBy(xpath = "//*[contains(text(),'Customers')]")
    public WebElement customers;

    //@FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[5]/a/span")
    @FindBy(xpath = "//*[contains(text(),'Activities')]")
    public WebElement activities;

    //@FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[6]/a/span")
    @FindBy(xpath = "//*[contains(text(),'Targets')]")
    public WebElement target;

    //@FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[7]/a/span")
    @FindBy(xpath = "//*[contains(text(),'Products')]")
    public WebElement products;

    //@FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[8]/a/span")
    @FindBy(xpath = "//*[contains(text(),'Learning')]")
    public WebElement learning;

    //@FindBy(xpath = "//*[@id=\"app-dashboard-sidebar\"]/ul/li[9]/a/span")
    @FindBy(xpath = "//*[contains(text(),'Settings')]")
    public WebElement settings;

//    @FindAll(
//            {
//                    @FindBy(xpath = "//*[contains(text(),\"welcome partner!\")]"),
//                    @FindBy(xpath = "//*[@class=\"r-p-name\"]")
//            }
//    )
@FindBy(xpath = "//*[contains(text(),\"welcome partner!\")]")
    public WebElement partnerProfile;


    @FindBy(css = "[id=\"fullName\"]")
    public WebElement partnerFullname;

    @FindBy(css = "[id=\"gender\"]")
    public WebElement partnerGender;

    @FindBy(css = "[id=\"email\"]")
    public WebElement partnerEmail;

    @FindBy(xpath = "//*[@class=\"button float-left register-submit-cls\"]")
    public WebElement letsgetStartedButton;

    @FindBy(xpath = "//*[contains(text(),\"Update Profile\")]")
    public WebElement updateprofileText;

    @FindBy(xpath = "//*[contains(text(),\"START WITH QUICK LEARNING TOUR\")]")
    public WebElement quickLearnigText;


}
