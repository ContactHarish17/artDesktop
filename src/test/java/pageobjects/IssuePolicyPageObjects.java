package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.IdentityHashMap;

public class IssuePolicyPageObjects extends MainPageObject {

    public IssuePolicyPageObjects(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Issue Policy')]")
    public WebElement issuePolicyButton;

    @FindBy(id = "totalPremium")
    public WebElement issuePolicyTotalPremium;

    @FindBy(id = "proceedTopayment")
    public WebElement proceedPayment;

    @FindBy(id = "sendPaymentLink")
    public  WebElement sendPaymentLink;

    @FindBy(xpath = "//*[contains(text(),'PAY HERE')]")
    public WebElement payhereButton;

    @FindBy(xpath = "//div[1]/div[2]/div/div[3]/div/div[3]/div/div[1]/label")
    public WebElement creditCard;

    @FindBy(xpath = "//*[contains(text(),'PAY Later')]")
    public WebElement payLaterButton;

    @FindBy(css = "input[name='card.number']")
    public WebElement creditcardNumber;

    @FindBy(xpath = "//*[@class=\"wpwl-control wpwl-control-expiry\"]")
    public  WebElement creditCardExpiry;

    @FindBy(css = "input[name='card.holder']")
    public WebElement creditcardHolder;

    @FindBy(css = "input[name='card.cvv']")
    public WebElement creditcardCVVr;

    @FindBy(xpath = "//*[contains(text(),'Pay now')]")
    public WebElement payNowButton;

    @FindBy(id = "returnCode")
    public WebElement returnCode;
//Successful

    @FindBy(css = "input[type=\"submit\"]")
    public  WebElement Submit;

    @FindBy(xpath = "//*[@id=\"policy-issuance-payment-completion-popup\"]/div/h2")
    public WebElement congratsmessage;

    @FindBy(xpath = "//*[@id=\"policy-issuance-payment-completion-popup\"]/div/p/b")
    public WebElement rewardsPoint;

    @FindBy(xpath = "//*[@id=\"policy-issuance-payment-completion-popup\"]/div/a")
    public WebElement addBankAccount;

    @FindBy(xpath = "//*[@id=\"policy-issuance-payment-completion-popup\"]/div/div[4]/a")
    public WebElement dolaterButton;








}
