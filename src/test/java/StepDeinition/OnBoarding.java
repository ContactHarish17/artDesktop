package StepDeinition;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class OnBoarding
{
    public WebDriver webdriver;
    File chromepath =  new File("..\\artDesktop\\chromedriver\\chromedriver.exe");


    @Given("^ I open chrome and launch the ART application$")
    public void i_open_chrome_and_launch_the_art_application() throws Throwable {
        System.setProperty("wedbdriver.chrome.driver" , chromepath.getAbsolutePath());
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        webdriver.navigate().to("https://sit-partner.alrajhitakaful.com.cm/register");
    }

    @When("^I click on 'I'M a Saudi Citizen$")
    public void i_click_on_im_a_saudi_citizen() throws Throwable {
        webdriver.findElement(By.xpath("//*[contains(text(),\"Yes, Maybe\")]")).click();
    }
    @When("^I Enter a valid Saudi Phone Number$")
    public void i_enter_a_valid_saudi_phone_number() throws Throwable {
        webdriver.findElement(By.id("mobileNumber")).sendKeys("599885501");
    }

    @When("^I Click on next button$")
    public void i_click_on_next_button() throws Throwable {
        webdriver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
    }

    @Given("^I'M on OTP Page")
    public void im_on_otp_page() throws Throwable
    {
        webdriver.findElement(By.id("validateOTP")).isDisplayed();

    }

    @When("^I Enter OTP1(.+) and OTP2(.+) and OTP(.+) and OTP4(.+)")
    public void i_enter_otp1_and_otp2_and_otp_and_otp4(String otp1, String otp2, String otp3, String otp4) throws Throwable {
        webdriver.findElement(By.id("otpDigit_1")).sendKeys(otp1);
        webdriver.findElement(By.id("otpDigit_2")).sendKeys(otp2);
        webdriver.findElement(By.id("otpDigit_3")).sendKeys(otp3);
        webdriver.findElement(By.id("otpDigit_4")).sendKeys(otp4);

    }

    @When("^Click on 'Verify' button")
    public void click_on_verify_button() throws Throwable {
        webdriver.findElement(By.id("validateOTP")).click();
    }

    /*
    @Given("^I'm on the registrtation page")
    public void im_on_the_registrtation_page() throws Throwable {
        webdriver.findElement(By.id("fullName")).isDisplayed();

    }

    @When("^I enter the name(.+) and email(.+)")
    public void i_enter_the_name_and_email(String partername, String partneremail) throws Throwable {
        webdriver.findElement(By.id("fullName")).sendKeys("BDD");
        webdriver.findElement(By.id("email")).sendKeys("artmobiledemo@gmail.com");
    }

    @When("^I click on 'Lets get started button'")
    public void i_click_on_lets_get_started_button() throws Throwable {
        webdriver.findElement(By.xpath("//*[@class=\"button float-left register-submit-cls\"]")).click();
    }

    @Then("^home page should be displayed")
    public void home_page_should_be_displayed() throws Throwable {
       webdriver.findElement(By.xpath("//*[contains(text(),'Quick Learning')]")).isDisplayed();
    }

    @And("^Then I should also a  message saying 'thanks for registrtation and you earned 10 rewards points'$")
    public void then_i_should_also_a_message_saying_thanks_for_registrtation_and_you_earned_10_rewards_points() throws Throwable {
       webdriver.findElement(By.xpath("//div[@class='reward-point registration']/h2")).isDisplayed();
        String welcomemessage = webdriver.findElement(By.xpath("//div[@class='reward-point registration']/h2")).getText();
        System.out.println("The message is " + welcomemessage);
    }*/

}