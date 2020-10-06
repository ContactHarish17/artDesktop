package maindriver;

import org.omg.CORBA.Environment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utility.SendEmailReportSeleniumDemo;

import javax.mail.MessagingException;
import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static javax.mail.Message.RecipientType.TO;

public class DriverScript extends CommonFunctions{

    public  static WebDriver driver = null;
    File chromepath =  new File("..\\artDesktop\\chromedriver\\chromedriver.exe");
    File firefoxpath = new File("..\\artDesktop\\geckodriver\\geckodriver.exe");
    String artURL = "https://sit-partner.alrajhitakaful.com.cm/register";

    public static String reportsFilePath = "..\\artDesktop\\Reports";
    public static String screenpath = "..\\artDesktop\\Screenshots";


    public static String browserName ;
    public static String browserVersion;
    public static String browserPlatform;

    @BeforeTest
    @Parameters({"BrowserType"})
    public void setUP(String BrowserType) throws Exception
    {
        if(BrowserType.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", chromepath.getAbsolutePath());
            ChromeOptions options = new ChromeOptions();
          //  options.addArguments("--incognito","--headless","--ignore-certificate-errors");
          //  options.setHeadless(true);
           // options.addArguments("--window-size=1920,1080");
//            options.addArguments("--start-maximized");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--disable-extensions");
//            options.setExperimentalOption("useAutomationExtension", false);
//            options.addArguments("--proxy-server='direct://'");
//            options.addArguments("--proxy-bypass-list=*");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--allow-insecure-localhost");
            options.addExtensions(new File("D:\\artDesktop\\documents\\extension_4_14_0_0.crx"));
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,options);
            LoggingPreferences loggingPreferences = new LoggingPreferences();
            loggingPreferences.enable(LogType.BROWSER, Level.ALL);
            desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
            driver = new ChromeDriver(desiredCapabilities);

        }else if(BrowserType.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", firefoxpath.getAbsolutePath());
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
            LoggingPreferences loggingPreferences = new LoggingPreferences();
            loggingPreferences.enable(LogType.BROWSER, Level.ALL);
            desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
            driver = new FirefoxDriver(desiredCapabilities);

        }

        emptyFolder(screenpath);
        System.out.println("the report folder path is " + screenpath);
       // emptyFolder(reportsFilePath);
        System.out.println("the report folder path is " + reportsFilePath);



       // resizebrowsrWindow(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().to(artURL);
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        browserName = capabilities.getBrowserName();
        browserVersion = capabilities.getVersion();
        browserPlatform = capabilities.getPlatform().toString();

    }

    public void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }

    @AfterTest
    public void tearDown()
    {

        //SendPDFReportByGMail("artdesktopauto@gmail.com","artdesktop","harish.ramakrishna@mindtree.com","PDF report","");
        driver.quit();
        publishReport();

    }
}
