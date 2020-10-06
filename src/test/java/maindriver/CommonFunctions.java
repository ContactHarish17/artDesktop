package maindriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import java.util.Properties;

import javax.activation.DataHandler;

import javax.activation.DataSource;

import javax.activation.FileDataSource;

import javax.mail.BodyPart;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.Multipart;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.AddressException;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class CommonFunctions {


    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static String workingDirectory = System.getProperty("user.dir");
    private static Date curDate = new Date();
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static String reportsFilePath = "..\\Reports";
    public static String screenpath = "..\\Screenshots";


    public static void createrReport(String reportname, String browserName, String browserversion, String browserOS) throws Exception {
        System.out.println("Inside the report method");
        try {
            Date curDate = new Date();
            System.out.println("date " + curDate.toString());

            // String dateName = new SimpleDateFormat("hh:mm").format(new Date());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strdate = formatter.format(curDate);
            System.out.println("the format date is " + strdate);


            String SubDirectory = "Reports";
            String ResultsPaths;

            ResultsPaths = createFolder(SubDirectory);
            File file = new File(ResultsPaths);
            System.out.println("the report path Folder is :- " + file.getAbsolutePath());


           // htmlReporter = new ExtentHtmlReporter(file.getAbsolutePath() + File.separator + reportname + ".html");
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\"+reportname+".html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            htmlReporter.setAppendExisting(false);
            extent.setSystemInfo("browser name ", browserName);
            extent.setSystemInfo("browser version", browserversion);
            extent.setSystemInfo("browser OS ", browserOS.toString());
            extent.setSystemInfo("Run Started on", curDate.toString());


            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setDocumentTitle("ART WebApp Report ");
            htmlReporter.config().setReportName("ART Web Automation Test Report");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void startTest(String testName, String testDecsription, String category) {
        try {
            test = extent.createTest(testName, testDecsription);
            test.assignCategory(category);
        } catch (Exception e) {

        }


    }

    public static void publishReport() {
        extent.flush();

    }


    public static void getTestResult(WebDriver driver, ITestResult result) throws IOException {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {

                test.fail(MarkupHelper.createLabel(result.getName() + " Test Case is FAILED", ExtentColor.RED));
                test.fail(result.getThrowable());
                try {
                    String screenshotPath = getScreenshot(driver, result.getName());
                    test.log(Status.FAIL, "Failed" + test.addScreenCaptureFromPath(screenshotPath));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass(MarkupHelper.createLabel(result.getName() + " Test Case is PASSED", ExtentColor.GREEN));

            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip(MarkupHelper.createLabel(result.getName() + " Test Case is SKIPPED", ExtentColor.YELLOW));
                test.skip(result.getThrowable());

            }
        } catch (NullPointerException e) {

        }

    }

    /**
     * Function to enter the text into a textfeld
     *
     * @param, driverType, element and string that's need to be entered
     */

    public static void enterText(WebDriver webDriver, WebElement element, String textkey) {
        try {
            element.sendKeys(textkey);
        } catch (Exception e) {
        }
    }

    /**
     * @param element
     * @return element title
     */

    public static String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Function to wait until the screen is fully loaded
     *
     * @param, drivertype , element and seconds to wait for page to load
     */

    public static void waitForScreenToLoad(WebDriver driver, WebElement element, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Function to click on link/button on web pages
     *
     * @param webDriver
     * @param element
     */
    public static void clickButton(WebDriver webDriver, WebElement element) {
        try {
            //waitForScreenToLoad(webDriver, element, 10);
            element.click();
            Thread.sleep(2000);
        } catch (ElementNotVisibleException e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws InterruptedException
     * @throws AWTException
     */

    public void zoomWindow() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        System.out.println("About to zoom in");
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    /**
     * @param, drivertype, screenshot path, screenshot name
     * attaches the screenshot to the test report
     */
    private static String getScreenshot(WebDriver webdriver, String screenshotName) throws IOException {

        String SubDirectory = "Screenshots";
        String ScreenshotPaths;

        try {
            String dateName = new SimpleDateFormat("dd-M-yyyy hh:mm").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) webdriver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            ScreenshotPaths = createFolder(SubDirectory);
            File file = new File(ScreenshotPaths);
            System.out.println("the ScreenShot  Folder is :- " + file.getAbsolutePath());

            String dest = file.getAbsolutePath() + File.separator + screenshotName + ".png";
            System.out.println("Screenshot path name:------" + dest);
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            System.out.println("ScreenShot Taken");
            return dest;
        } catch (Exception e) {
            System.out.println("Exception While Taking screenshot" + e.getMessage());
            return e.getMessage();
        }

    }

    public static void comparevalues(LinkedList<String> databasevalues, List excelvalues) {
        for (int i = 0, j = 1; i < databasevalues.size() && j < excelvalues.size(); i++, j++) {
            if (databasevalues.get(i).equals(excelvalues.get(j))) {
                test.log(Status.FAIL, "Values didn't matched with Database");

            } else {
                test.log(Status.PASS, " Vakues matched with database");

            }
        }
    }


    /**
     * Function to create a folder with the project path
     *
     * @param, Directory path
     */
    public static String createFolder(String path) {
        String strManyDirectories = null;
        try {
            //  String strDirectoy = path;
            strManyDirectories = path;

            // Create one directory
            boolean
                    // Create multiple directories
                    success = (new File(strManyDirectories)).mkdirs();
            if (success) {
                System.out.println("Directories: "
                        + strManyDirectories + " created");
            }

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return strManyDirectories;
    }

    /**
     * Function to check whether an element is displayed , return true if present else fail
     * If true, then the element text will be attached the report name. If element text not present, it uses the
     * element attribute
     *
     * @param, drivertype, element name
     */

    public static void elementDisplayed(WebDriver webDriver, WebElement element) throws Exception {

        try {
            waitForScreenToLoad(webDriver, element, 6);
            Assert.assertTrue(element.isDisplayed());
            if (element.isDisplayed()) {
                // if (element.getText().length() <= 0)
                if (element.getText() == null) {
                    // test.log(Status.PASS, element.getAttribute("contentDescription") + "  Displayed");
                } else {
                    test.log(Status.PASS, element.getText() + "  Displayed");
                }

            } else {
                test.log(Status.FAIL, element.getText() + "  isn't Displayed");
            }


        } catch (AssertionError e) {
            e.printStackTrace();
            org.testng.Assert.fail();
        }
    }


    public void scrollpage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void jsclickElement(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
    }

    /**
     * Function to get current system date
     */
    public static String getDate() {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    /**
     * function to scroll to a particular element on the page
     *
     * @param driver
     * @param element
     */
    public void scrolltoElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Function to get the options from a drop down
     *
     * @param driver
     * @param element
     */

    public void getValues(WebDriver driver, WebElement element) {
        Select selectoptions = new Select(element);
        List<WebElement> optionvalues = selectoptions.getOptions();
        for (WebElement values : optionvalues) {
            System.out.println("the values are :" + values.getText());
        }

    }

    public void scrollUp(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1600)", "");

    }

    public List<WebElement> getOptions(WebElement element) {
        Select options = new Select(element);
        List<WebElement> flightoptions = options.getOptions();
        return flightoptions;
    }

    public void assertOptions(WebElement elements, String expected[]) {
        Select options = new Select(elements);
        List<WebElement> elementcount = options.getOptions();
        System.out.println(elementcount.size());
        for (int i = 0; i < elementcount.size(); i++) {
            String value = elementcount.get(i).getText();
            System.out.println("the options are :- " + value);
            Assert.assertEquals(value, expected[i], "text Matched");

        }

    }


    public void selectBytext(WebElement webElement, String text) throws InterruptedException {
        Select selectitem = new Select(webElement);
        Thread.sleep(2000);
        selectitem.selectByVisibleText(text);
    }

    public void selectByid(WebElement element, int itemindex) {
        Select selectid = new Select(element);
        selectid.selectByIndex(itemindex);
    }


    /**
     * Function to mouse over a menu
     *
     * @param driver
     * @param menuselement
     * @param tosubmenuelement
     * @throws InterruptedException
     */

    public void mouseHover(WebDriver driver, WebElement menuselement, WebElement tosubmenuelement) throws InterruptedException {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(fromelement).moveToElement(toelement).click().build().perform();
//        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuselement).perform();
        Thread.sleep(3000);
        actions.moveToElement(tosubmenuelement);
        actions.click().build().perform();
        Thread.sleep(3000);
    }

    /**
     * Function to resize the browser window
     *
     * @param driver
     */
    public void resizebrowsrWindow(WebDriver driver) {
        Dimension d = new Dimension(900, 900);
        driver.manage().window().setSize(d);
    }

    /**
     * Function to empty the  folder
     */
    public static void emptyFolder(String filepath) {

        File file = new File(filepath);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public List<String> arrayProperties(String propertyfilepath) {
        List<String> propertiesvalues = new ArrayList<String>();
        try {
            File file = new File(propertyfilepath);
            FileInputStream fileInput = null;
            fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                propertiesvalues.add(value);
                //String value = properties.getProperty(key);
                //System.out.println(key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesvalues;
    }


    public static List<String> getExcelValues(String filepath, String filenmae, String Sheetname) throws IOException {
        File file = new File(filepath + "//" + filenmae);
        List<String> propertiesvalues = new ArrayList<String>();
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook excelworkbook = new XSSFWorkbook(inputStream);
        String fileExtensionName = filenmae.substring(filenmae.indexOf("."));
//        if (fileExtensionName.equals("xlsx"))
//        {
//            excelworkbook = new XSSFWorkbook(inputStream);
//        } else if (fileExtensionName.equals("xls")) {
//            excelworkbook = new HSSFWorkbook(inputStream);
//        }
        System.out.println(Sheetname);
        XSSFSheet excelsheetname = excelworkbook.getSheet(Sheetname);
        int rowcount = excelsheetname.getLastRowNum() - excelsheetname.getFirstRowNum();
        for (int i = 0; i < rowcount; i++) {
            Row row = excelsheetname.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j).getStringCellValue() + "|| ");
                propertiesvalues.add(row.getCell(j).getStringCellValue());
            }
        }
        return propertiesvalues;
    }


    /**
     * function to wait, till page is completely loaded
     *
     * @param driver
     */
    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    /**
     * function to click on URL's with href
     *
     * @param driver
     * @param href
     */
    public void clickLinkByHref(WebDriver driver, String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while (i.hasNext()) {
            WebElement anchor = i.next();
            if (anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }


    public static String hijriDate(String gregorianDate) {
        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();
        String data = "21-08-1971";
        LocalDate todayIso = new LocalDate(gregorianDate, iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(),
                hijri);
        System.out.println(todayHijri); // 1434-05-19
        return String.valueOf(todayHijri);
    }

    /**
     * Function to verify any broken  link in webpage
     * @param urlLink
     */
    public static void VerifyLinks(String urlLink)
    {
        try
        {
            URL link = new URL(urlLink);
            HttpURLConnection httpURLConnection = (HttpURLConnection)link.openConnection();
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()==200) {
                test.log(Status.PASS,  httpURLConnection.getResponseMessage());
            }else if(httpURLConnection.getResponseCode()==400)
            {
                test.log(Status.FAIL, httpURLConnection.getResponseMessage());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Function which waits until last element is clickable
     * @param driver
     * @param element
     */
    public static void pageElementCompleteLoaded(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



        public static void waitForLoad(WebDriver driver) {
            ExpectedCondition<Boolean> pageLoadCondition = new
                    ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                        }
                    };
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(pageLoadCondition);
        }


//    public void waitForPageCompleteLoaded(WebDriver driver) {
//        ExpectedCondition<Boolean> expectation = new
//                ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver) {
//                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
//                    }
//                };
//        try {
//            Thread.sleep(1000);
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(expectation);
//        } catch (Throwable error) {
//            Assert.fail("Timeout waiting for Page Load Request to complete.");
//        }
//    }


    public static void buttonCliclable(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    /**

     * Send email using java

     * @param from

     * @param pass

     * @param to

     * @param subject

     * @param body

     */

    public static void SendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

        Properties props = System.getProperties();

        String host = "smtp.gmail.com";

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", host);

        props.put("mail.smtp.user", from);

        props.put("mail.smtp.password", pass);

        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        MimeMessage message = new MimeMessage(session);

        try {

            //Set from address

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//Set subject

            message.setSubject(subject);

            message.setText(body);

            BodyPart objMessageBodyPart = new MimeBodyPart();

            objMessageBodyPart.setText("Hi , Please find the attached PDF report for ARt Desktop. This is an Automated mail!");

            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(objMessageBodyPart);

            objMessageBodyPart = new MimeBodyPart();

//Set path to the pdf report file

            String filename = System.getProperty("user.dir")+"\\ARTDesktopAutomation_Test_Report.pdf";

//Create data source to attach the file in mail

            DataSource source = new FileDataSource(filename);

            objMessageBodyPart.setDataHandler(new DataHandler(source));

            objMessageBodyPart.setFileName(filename);

            multipart.addBodyPart(objMessageBodyPart);

            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");

            transport.connect(host, from, pass);

            transport.sendMessage(message, message.getAllRecipients());

            transport.close();

            System.out.println("The email sent ");

        }

        catch (AddressException ae) {

            ae.printStackTrace();

        }

        catch (MessagingException me) {

            me.printStackTrace();

        }

    }

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception

     */

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);



    }

    }

