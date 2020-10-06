package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahoomailPageObjects extends  MainPageObject {


    public YahoomailPageObjects(WebDriver webDriver)
    {
        super(webDriver);
    }

    //@FindBy(id = "login-username")
    @FindBy(xpath = "//*[@id=\"login-username\"]")
    public  WebElement username;

    @FindBy(id = "login-passwd")
    public  WebElement password;

    //@FindBy(id="login-signin")
    @FindBy(xpath = "//*[@id=\"login-signin\"]")
    public WebElement signinButton;

    @FindBy(xpath = "//*[@class=\"u_Z13VSE6\"]")
    public WebElement unReadMails;

    //@FindBy(id = "btnQuoteAccept")
    @FindBy(xpath = "////*[@id=\"btnQuoteAccept\"]")
    public WebElement acceptQuote;

    @FindBy(xpath = "//*[@id=\"btnQuoteReject\"]")
    public WebElement rejectQuote;

    @FindBy(xpath = "//*[contains(text(),'رابط الإقتباس')]")
    public WebElement acceptQuiteURL;

    @FindBy(xpath = "//*[@class=\"cell small-12\"]/h2")
    public  WebElement acceptOTPTitle;







}
