package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends MainPageObject {

    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//html/body/div[3]/div[1]/div[2]/div/div/a[2]")
    public WebElement ArabicButton;

    @FindBy(xpath = "//html/body/div[3]/div[1]/div[2]/div/div/a[1]")
    public WebElement EnglishButton;

    @FindBy(xpath = "//*[contains(text(),'Are you a Saudi Citizen?')]")
    public WebElement SaudiCheck;

  //  @FindBy(xpath = "//*[@id=\"CFE90E99-8332-43FD-BE89-1AA708A9AF10\"]/div/div[1]/a[2]")
    @FindBy(xpath = "//*[contains(text(),\"NO, I AM NOT\")]")
    public WebElement NonSaudi;

  //  @FindBy(xpath = "//*[@id=\"saudhiReferral\"]/div/div/a[1]")
    @FindBy(xpath = "//*[contains(text(),\"Yes, Maybe\")]")
    public WebElement nosaudi_yesmaybeButton;

    @FindBy(xpath = "//*[@id=\"saudhiReferral\"]/div/div/a[2]")
    public WebElement nonsaudi_noButton;

    @FindBy(xpath = "//*[@id=\"inviteName\"]")
    public WebElement invitename;

    @FindBy(xpath = "//*[@id=\"inviteMobile\"]")
    public WebElement invitemobile;

    @FindBy(xpath = "//*[@id=\"inviteEmail\"]")
    public WebElement inviteemail;

    @FindBy(xpath = "//*[@id=\"form-list\"]/div/div[2]/h3")
    public WebElement invitedName;

    @FindBy(xpath = "//*[@id=\"form-list\"]/div/div[2]/p[1]/span[2]")
    public WebElement invitedmobile;

    @FindBy(xpath = "//*[@id=\"form-invite\"]")
    public WebElement inviteNow;

    @FindBy(xpath = "//*[@id=\"form-invite-cancel\"]")
    public WebElement cancelInvite;

    @FindBy(xpath = "//*[@id=\"referralThankyou\"]/div/div/h2")
    public WebElement thankyoumessage;

    //@FindBy(css = "a[id='add-item-id']")
    @FindBy(xpath = "//*[contains(text(),'Add New')]")
    public WebElement addnew;


    @FindBy(xpath = "//*[@id=\"CFE90E99-8332-43FD-BE89-1AA708A9AF10\"]/div/div[1]/a[1]")
    public WebElement Saudi;

    @FindBy(css = "input[id=\"mobileNumber\"]")
    public WebElement MobileNumber;

   // @FindBy(css = "input[id=\"checkbox12-FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A\"][value=\"true\"]")
    @FindBy(xpath = "//*[@id=\"FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A\"]/form/div[3]/label/input[2]")
    public WebElement CheckBox_Terms;

    @FindBy(css = "input[id=\"otpDigit_1\"]")
    public WebElement otp1;

    @FindBy(css = "input[id=\"otpDigit_2\"]")
    public WebElement otp2;

    @FindBy(css = "input[id=\"otpDigit_3\"]")
    public WebElement otp3;

    @FindBy(css = "input[id=\"otpDigit_4\"]")
    public WebElement otp4;


    //@FindBy(css = "input[name=\"ConsentCheckBox\"]")
 //   @FindBy(xpath = "//label[@for='checkbox12-FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A']")
   // @FindBy(xpath = "//label[contains(@class,'checkmark')]")
   // @FindBy(xpath = "//*[@id='checkbox12-FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A']//parent::*")
    //@FindBy(xpath = ".//*[@class='checkmark']/parent::*")
    //@FindBy(xpath = "//*[@class=\"checkbox-content\"]/label")
   // @FindBy(xpath = "//*[@class='checkmark']//parent::*")
   // @FindBy(xpath = "//*[@class='checkmark']")

//    @FindAll(
//            {
//                    @FindBy(xpath = "//*[@class='checkmark']//parent::*"),
//                    @FindBy(xpath = "//*[@id='checkbox12-FB92CEC7-ECE7-4559-BFD7-C600F7EB0F5A']//parent::*"),
//                    @FindBy(xpath = "//*[@class=\"checkbox-content\"]/label")
//
//            }
//    )
    @FindBy(css = ".checkmark")
    public WebElement consentCheckBox;

    @FindBy(xpath = "//*[contains(text(),'Next')]")
    public WebElement NextButton;

    @FindBy(xpath = "//*[contains(text(),'START WITH QUICK LEARNING TOUR')]")
    public WebElement startwithQLT;

    @FindBy(xpath = "//*[contains(text(),'Quick Learning')]")
    public WebElement quicklearning;

    @FindBy(xpath = "//*[contains(text(),'Reach Out!')]")
    public WebElement reachout;

    @FindBy(xpath = "//*[contains(text(),'Quote & Policy Delivery')]")
    public WebElement quotepolicy;

    @FindBy(xpath = "//*[contains(text(),'Earn Money easily')]")
    public WebElement earnMoney;

    @FindBy(xpath = "//*[contains(text(),'ADD CONTACT')]")
    public WebElement addContactButton;

//    @FindAll(
//
//            {
//                    @FindBy(id = "validateOTP"),
//                    @FindBy(xpath = "//*[@id=\"validateOTP\"]")
//            }
//    )
   // @FindBy(xpath = "//*[@id=\"validateOTP\"]/text()")
   // @FindBy(xpath = "//*[contains(text(),'Verfiy')]")
    //@FindBy(id = "validateOTP")
    public WebElement validateOTP;



    @FindBy(id = "Resend")
    public WebElement ResendButton;

    //@FindBy(css = "input[id=\"fullName\"]")
    @FindBy(id = "fullName")
    public WebElement FullName;

    @FindBy(id="gender")
    public WebElement gender;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//*[@id=\"23BD780B-E525-420D-B8CE-6A3B686CBE50\"]/form/div[2]/a")
    public WebElement letsGetStarted;

    @FindBy(xpath = "//*[contains(text(),'One Last Feet!')]")
    public WebElement onelastfeetText;

    @FindBy(xpath = "//*[contains(text(),\"START WITH QUICK LEARNING TOUR\")]")
    public WebElement quickLearning;

    @FindBy(xpath = "//*[contains(text(),\"Next\")]")
    public WebElement nextbutton;

    @FindBy(xpath = "//*[contains(text(),\"TAKE THE QUIZ\")]")
    public WebElement takequiz;

    @FindBy(xpath = "//*[contains(text(),\"True\")]")
    public WebElement truebutton;

    @FindBy(xpath = "//*[@id=\"quizContainer\"]/form/div[5]/div[1]/img")
    public WebElement rightanswer;

    @FindBy(xpath = "//*[@id=\"quizContainer\"]/form/div[5]/div[2]/img")
    public WebElement wronganswer;

    @FindBy(xpath = "//*[@id=\"quizContainer\"]/form/div[5]/div[2]/p/text()")
    public WebElement wronganswerText;

    @FindBy(xpath = "//*[@class=\"buttons\"]/a[2]")
    public WebElement nextQuestion;

    @FindBy(xpath = "//*[contains(text(),\"Other Party\")]")
    public WebElement secondquestionanswer;

    @FindBy(xpath = "//*[contains(text(),\"Third Party Liability Car Insurance\")]")
    public WebElement thirdquestionasnwer;

    @FindBy(xpath = "//*[@class=\"buttons\"]/a[3]")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class=\"reward-point\"]/h2")
    public WebElement congrulationtext;

    @FindBy(xpath = "//*[contains(text(),\"REACH OUT CONTACTS\")]")
    public WebElement reachoutcontacts;

    @FindBy(xpath = "//*[@id=\"97BFCD5A-E336-4417-9BDB-CD1CE64E7019\"]/div[2]/div/h3/text()")
    public WebElement otptext;

    @FindBy(xpath = "//*[contains(text(),\"Step 1:\tQuick Learning\")]")
    public WebElement quicklearning_step1;

    @FindBy(xpath = "//*[@class=\"buttons text-center\"]/a[4]")
    public WebElement reachoutContactButton;

    @FindBy(xpath = "//*[@class=\"buttons text-center\"]/a[1]")
    public WebElement quicklearning_previousButton;

    @FindBy(xpath = "//*[@class=\"buttons text-center\"]/a[2]")
    public WebElement quicklearning_nextButton;


    @FindBy(xpath = "//*[@id=\"form-list\"]/div/div[1]")
    public WebElement deleteNonSaudi;

}
