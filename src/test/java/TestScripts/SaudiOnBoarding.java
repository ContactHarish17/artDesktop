package TestScripts;

import listeners.JyperionListener;
import maindriver.DriverScript;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.*;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Listeners(JyperionListener.class)
public class SaudiOnBoarding extends DriverScript {

    RegisterPage registerPage ;
    String generatedOTP=null;
    HomePageObject homePageObject;
    ContactPageObject contactPageObject;
    SaudiCheckPageObjects saudiCheckPageObjects;
    ReadingPropertyFile readingPropertyFile = new ReadingPropertyFile();
    ActivityPageObjects activityPageObjects;
    ProspectPageObjects prospectPageObjects;
    QuotePageObjects quotePageObjects;
    YahoomailPageObjects yahoomailPageObjects;


    public void initialisePageObjects() {
        registerPage = new RegisterPage(driver);
        homePageObject = new HomePageObject(driver);
        contactPageObject = new ContactPageObject(driver);
        saudiCheckPageObjects = new SaudiCheckPageObjects(driver);
        activityPageObjects = new ActivityPageObjects(driver);
        prospectPageObjects = new ProspectPageObjects(driver);
        quotePageObjects = new QuotePageObjects(driver);
        yahoomailPageObjects = new YahoomailPageObjects(driver);

            try {
                createrReport("OnBodaring",DriverScript.browserName,DriverScript.browserVersion,DriverScript.browserPlatform);
            } catch (Exception e) {
                e.printStackTrace();
            }
        try {
            ReadExcel.OpenExcel(Constant.ExcelFilepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void testHomePage() throws InterruptedException {

        String oldTab = driver.getWindowHandle();
        initialisePageObjects();
        startTest("HomePage", "Checking the Home page","OnBoarding");
        scrollpage(driver);
        waitForScreenToLoad(driver, registerPage.NonSaudi, 30);
        try {
            elementDisplayed(driver, registerPage.NonSaudi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2)
    public void testNonSaudireferal() throws InterruptedException {
        startTest("Non Saudi", "Test to refer a non Saudi","Non Saudi");
        try {
            //elementDisplayed(driver, registerPage.NonSaudi);
            clickButton(driver,registerPage.NonSaudi);
            scrollpage(driver);
            clickButton(driver,registerPage.nosaudi_yesmaybeButton);
            enterText(driver,registerPage.invitename,ReadExcel.getCellData(Constant.nonsaudiSheetName,1,0));
            enterText(driver,registerPage.invitemobile,ReadExcel.getCellData(Constant.nonsaudiSheetName,1,1).replaceAll("[-+.,%EBDAF]",""));
            clickButton(driver,registerPage.addnew);
            elementDisplayed(driver,registerPage.invitedName);
            elementDisplayed(driver,registerPage.invitedmobile);
            elementDisplayed(driver,registerPage.inviteNow);
            elementDisplayed(driver,registerPage.cancelInvite);
            scrollpage(driver);
            clickButton(driver,registerPage.cancelInvite);
            elementDisplayed(driver,registerPage.thankyoumessage);
             driver.navigate().back();
             driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    @Test(priority = 3)
//    public void TestAcceptQuote() throws InterruptedException
//    {
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//
//
//        startTest("Accept Quote", "test to accept the quote", "Quote");
//
//
//      //  ((JavascriptExecutor)seconddriver).executeScript("window.open('https://login.yahoo.com/?.src=ym&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fmail.yahoo.com%2Fd');");
//        ((JavascriptExecutor)driver).executeScript("window.open('','_blank');");
//
//        String oldTab = driver.getWindowHandle();
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(oldTab);
//
//
//
//        // change focus to new tab
//        driver.switchTo().window(newTab.get(1));
//        Thread.sleep(4000);
//        driver.get("https://login.yahoo.com/?.src=ym&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
//
//        Thread.sleep(4000);
//        driver.findElement(By.id("login-username")).sendKeys("artdesktopauto");
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
//        Thread.sleep(12000);
//        driver.findElement(By.xpath("//*[@id=\"login-passwd\"]")).sendKeys("artdesktop");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
//        Thread.sleep(1000);
//
//  //      String oldTabs = driver.getWindowHandle();
//   //     ArrayList<String> newTabs = new ArrayList<String>(driver.getWindowHandles());
//   //     System.out.println("the windows size are " + newTabs.size());
//    //    newTab.remove(oldTabs);
//
//      //  driver.switchTo().window(newTabs.get(2));
//      //  driver.close();
//
//       // driver.switchTo().window(newTabs.get(1));
//
//       // driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
//        List<WebElement> unreademail = driver.findElements(By.xpath("//*[@class=\"u_Z13VSE6\"]"));
//        System.out.println("Total No. of Unread Mails: " + unreademail.size());
//        Thread.sleep(4000);
//        for(int i=0;i<unreademail.size();i++)
//        {
//
//           System.out.println(unreademail.get(i).getText());
//
//        }
//        unreademail.get(0).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//tr[2]/td/table/tbody/tr[2]/td/p[2]/a")).click();
//        //driver.findElement(By.xpath("//*[contains(text(),'رابط عرض السعر')]")).click();
//        Thread.sleep(2000);
//
//        ArrayList<String> newTab_1 = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(newTab_1.get(1));
//        // change focus to new tab
//        driver.switchTo().window(newTab_1.get(3));
//
//        waitForPageLoad(driver);
//
//        WebElement acceptQuote = driver.findElement(By.id("btnQuoteAccept"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnQuoteAccept")));
//        //wait.until(ExpectedConditions.visibilityOf(acceptQuote));
//
//        System.out.println("the url is " + driver.getCurrentUrl());
//        Thread.sleep(3000);
//
//        /*
//        driver.findElement(By.id("btnQuoteAccept")).click();
//        Thread.sleep(2000);
//        WebElement validateOTP = driver.findElement(By.id("validateOTP"));
//        //wait.until(ExpectedConditions.visibilityOf(validateOTP));
//        wait.until(ExpectedConditions.elementToBeClickable(validateOTP));
//
//        WebElement otp1 = driver.findElement(By.id("otpDigit_1"));
//        WebElement otp2 = driver.findElement(By.id("otpDigit_2"));
//        WebElement otp3 = driver.findElement(By.id("otpDigit_3"));
//        WebElement otp4 = driver.findElement(By.id("otpDigit_4"));
//
//        otp1.sendKeys("9");
//        otp2.sendKeys("9");
//        otp3.sendKeys("9");
//        otp4.sendKeys("9");
//
//        validateOTP.click();
//
//         */
//        System.out.println("the opened tabs are " + newTab_1.size());
//        Thread.sleep(2000);
//
//        ArrayList<String> originalTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(newTab_1.get(3));
//
//        System.out.println("the Final open tabs are" + originalTab.size());
//        Thread.sleep(4000);
//        driver.switchTo().window(originalTab.get(0));
//    }


    @Test(priority = 3)
    public void testSaudiCheck() throws InterruptedException {

        startTest("Onboadring Saudi", "Checking the Saudi On boadring ", "SaudiCheck");
        scrollpage(driver);
        clickButton(driver, registerPage.Saudi);
        enterText(driver, registerPage.MobileNumber, ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,0).replaceAll("[-+.,%EBDAF]",""));
        scrolltoElement(driver,registerPage.NextButton);
//        clickButton(driver, registerPage.NextButton);
//        clickButton(driver, registerPage.consentCheckBox);
        clickButton(driver, registerPage.NextButton);

       // System.out.println("the attribute values " + registerPage.consentCheckBox.getAttribute(""));

    }

    @Test(priority = 4)
    public void testEnterOTP() throws InterruptedException
    {
        startTest("Entering OTP ", " Entering the OTP values", "Entering OTP");
        enterText(driver,registerPage.otp1, "9");
        enterText(driver,registerPage.otp2, "9");
        enterText(driver,registerPage.otp3, "9");
        enterText(driver,registerPage.otp4, "9");
        Thread.sleep(3000);
        scrolltoElement(driver,registerPage.validateOTP);
        clickButton(driver,registerPage.validateOTP);
    }

    /*

//    @Test(priority = 5)
//    public void testOnboardingSuadiCitizen()
//    {
//        startTest("OnBoarding Saudi ", "Test to check whether saudi citizen can be register","OnBoarding");
//        enterText(driver,homePageObject.partnerFullname,ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,1));
//        enterText(driver,homePageObject.partnerGender,ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,2));
//        enterText(driver,homePageObject.partnerEmail,ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,3));
//        scrolltoElement(driver,homePageObject.letsgetStartedButton);
//        clickButton(driver,homePageObject.letsgetStartedButton);
//    }

    @Test(priority = 6)
    public void testCheckPartnerDetails_DB() throws IOException, ClassNotFoundException {
        startTest("OnBoadring DB", "Checking on-boarded partner details in DB","Partners_DB_Test");
        try {
            ARTDataBase.connecttodb();
            ReadExcelDemo.OpenExcel(Constant.ExcelFilepath);
            LinkedList<String> partnervalue = ARTDataBase.executestatementPartners();
            ReadExcelDemo.getExcelvaluestoArray(Constant.saudiOnboardingSheetName);
            List excelpartnervalues = ReadExcelDemo.getvalues();
            for(int i=0, j=1;i<partnervalue.size() && j<excelpartnervalues.size();i++,j++)
            {
                System.out.println("the partner values from Datebase are  " + partnervalue.get(i));
                System.out.println("the partner values from Excel are " + excelpartnervalues.get(j));
                Assert.assertEquals(partnervalue.get(i),excelpartnervalues.get(j));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (AssertionError e)
        {}

    }

    @Test(priority = 7)
    public void testWelcomePage() throws Exception {
        startTest("Home Page", "Test to check loading home page", "Homepage");
        elementDisplayed(driver,registerPage.quicklearning);
        elementDisplayed(driver,registerPage.reachout);
        elementDisplayed(driver,registerPage.quotepolicy);
        elementDisplayed(driver,registerPage.earnMoney);
        elementDisplayed(driver,homePageObject.home);
        elementDisplayed(driver,homePageObject.contacts);
        elementDisplayed(driver,homePageObject.prospects);
        elementDisplayed(driver,homePageObject.customers);
        elementDisplayed(driver,homePageObject.activities);
        elementDisplayed(driver,homePageObject.target);
        elementDisplayed(driver,homePageObject.products);
        elementDisplayed(driver,homePageObject.learning);
        elementDisplayed(driver,homePageObject.settings);
        elementDisplayed(driver,registerPage.startwithQLT);
    }

    @Test(priority = 8)
    public void testContactPage() throws Exception{
        startTest("Adding a Contact", "Test Adding a contacts","contacts");
        clickButton(driver,homePageObject.contacts);
        enterText(driver,contactPageObject.fullname, ReadExcel.getCellData(Constant.contactSheetName,1,0));
        enterText(driver,contactPageObject.mobilenumber, ReadExcel.getCellData(Constant.contactSheetName,1,1).replaceAll("[-+.,%EBDAF]",""));;
        enterText(driver,contactPageObject.emailaddress, ReadExcel.getCellData(Constant.contactSheetName,1,2));
        scrollpage(driver);
        clickButton(driver,registerPage.addContactButton);
    }

    @Test(priority = 9)
    public void testSelectingProductoption() throws Exception{
        startTest("Selecting products", "Test to select product option for a contacts","contacts");
        clickButton(driver,contactPageObject.medicalproduct);
        clickButton(driver,contactPageObject.medicalmalpracticeproduct);
    }

    @Test(priority = 10)
    public void testEnterOtherDetails() throws Exception {
        startTest("Entering Other Details products", "Test to add more details about contact ", "contacts");
        scrolltoElement(driver, contactPageObject.addmoreDetails);
        clickButton(driver, contactPageObject.addmoreDetails);
        waitForScreenToLoad(driver, contactPageObject.organisation, 30);
        enterText(driver, contactPageObject.organisation, ReadExcel.getCellData(Constant.contactSheetName, 1, 3));
        selectBytext(contactPageObject.martialstatus, "Single");
        scrollpage(driver);
        Thread.sleep(3000);
        clickButton(driver, contactPageObject.saveButton);
    }

    @Test(priority = 11)
    public void testEditContacts() throws Exception {
        startTest("Edit Contact", "Test to edit the contact and add kids,spouse, jobtitle", "Edit Contact");
        mouseHover(driver, contactPageObject.modifyContact, contactPageObject.editContact);
        elementDisplayed(driver,contactPageObject.editContactText);
        scrollpage(driver);
        clickButton(driver, contactPageObject.addmoreDetails);
        enterText(driver,contactPageObject.nationalID,ReadExcel.getCellData(Constant.contactSheetName,1,8).replaceAll("[-+.,%EBDAF]",""));
        selectBytext(contactPageObject.martialstatus,ReadExcel.getCellData(Constant.contactSheetName,1,5));
        enterText(driver,contactPageObject.spouses,ReadExcel.getCellData(Constant.contactSheetName,1,6));
        enterText(driver,contactPageObject.kids,ReadExcel.getCellData(Constant.contactSheetName,1,7));
        enterText(driver,contactPageObject.jobtitle,ReadExcel.getCellData(Constant.contactSheetName,1,4));
        clickButton(driver,contactPageObject.travelproduct);
        scrollpage(driver);
        Thread.sleep(3000);
        clickButton(driver,contactPageObject.saveButton);
    }

    @Test(priority = 12)
    public void testContactListpage() throws Exception {
        startTest("ContactList page", "Test to check added contact showing up in ContactList Page", "ContactList");
        waitForScreenToLoad(driver,contactPageObject.addmorebutton,30);
        elementDisplayed(driver, contactPageObject.addmorebutton);
        elementDisplayed(driver, contactPageObject.buyYourSelfbutton);
     //   System.out.println("the contact name" + contactPageObject.addedContactName.getText());
     //   elementDisplayed(driver, contactPageObject.addedContactName);
        elementDisplayed(driver, contactPageObject.addProspectButton);
    }


    @Test(priority = 13)
    public void testEditContact() throws Exception {
        startTest("Edit Contact", "Test to edit the contact and add twitter and linkedin", "Edit Contact");
        mouseHover(driver, contactPageObject.modifyContact, contactPageObject.editContact);
        elementDisplayed(driver,contactPageObject.editContactText);
        scrollpage(driver);
        clickButton(driver, contactPageObject.addmoreDetails);
        enterText(driver, contactPageObject.twitter, ReadExcel.getCellData(Constant.contactSheetName,1,9));
        enterText(driver, contactPageObject.linkedin, ReadExcel.getCellData(Constant.contactSheetName,1,10));
        clickButton(driver,contactPageObject.travelproduct);
        scrolltoElement(driver,contactPageObject.saveButton);
        clickButton(driver, contactPageObject.saveButton);
        waitForScreenToLoad(driver, contactPageObject.addmorebutton, 30);
    }


  /*  @Test(priority = 14)
    public void testCheckContactDetails_DBBeforeProspect() throws IOException, ClassNotFoundException, SQLException {
        startTest("Contact_DB_Before_Prospect", "Checking added contacts details in DB before prospect converted","Contact_DB_Test_BeforeProspect");
        try {
            ARTDataBase.executestatementContact_Prospect();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (AssertionError e)
        {e.printStackTrace();}

    }*/

/*
    @Test(priority = 15)
    public void testAddContactAsProspect() throws InterruptedException {
        startTest("Addig Contact as Prospect", "Test to convert contact as Prospect","Prospect");
        clickButton(driver,contactPageObject.addProspectButton);
        Thread.sleep(8000);
        try {
            Assert.assertFalse(!contactPageObject.prospectbutton.isEnabled());
        }catch (AssertionError e)
        {e.printStackTrace();}
    }


    @Test(priority = 16)
    public void testAddMoreContacts() throws Exception {
        startTest("Add More Contacts", "Test to add more contacts","Add More Contacts");
        clickButton(driver,homePageObject.contacts);
        for(int i=2;i<=3;i++) {
            clickButton(driver, contactPageObject.addmorebutton);
            enterText(driver, contactPageObject.fullname, ReadExcel.getCellData(Constant.contactSheetName, i, 0));
            enterText(driver, contactPageObject.mobilenumber, ReadExcel.getCellData(Constant.contactSheetName, i, 1));
            clickButton(driver, contactPageObject.travelproduct);
            clickButton(driver, contactPageObject.addmoreDetails);
            scrolltoElement(driver, contactPageObject.cancelButton);
            selectBytext(contactPageObject.martialstatus, ReadExcel.getCellData(Constant.contactSheetName, i, 5));
            enterText(driver, contactPageObject.spouses, ReadExcel.getCellData(Constant.contactSheetName, i, 6));
            clickButton(driver, contactPageObject.saveButton);
        }
    }
/*
    @Test(priority = 16)
    public void testCheckContactDetails_DB() throws IOException, ClassNotFoundException, SQLException {
        startTest("Contact_DB_After_Prospect", "Checking added contacts details in DB After prospect converted","Contact_DB_Test_AfterProspect");
        ARTDataBase.connecttodb();
        try {
            ReadExcelDemo.OpenExcel(Constant.ExcelFilepath);
            LinkedList<String> contactsvalue = ARTDataBase.executeContactStatement();
            ReadExcelDemo.getExcelvaluestoArray(Constant.contactSheetName);
            List excelcontactvalues = ReadExcelDemo.getvalues();
            for(int i=0, j=0;i<contactsvalue.size() && j<excelcontactvalues.size();i++,j++)
            {
                System.out.println("the contacts values of database are  " + contactsvalue.get(i));
                System.out.println("the contacts values of excel are " + excelcontactvalues.get(j).toString());
                //Assert.assertEquals(contactsvalue.get(i),excelpartnervalues.get(j).toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (AssertionError e)
        {e.printStackTrace();}

    }
*/

/*
    @Test(priority = 17)
    public void testCheckProspectPage()
    {
        startTest("Individual Prospect Page", "Checking the Individual prospect page", "Individual ProspectPage");
        clickButton(driver,homePageObject.prospects);
        try {
            elementDisplayed(driver,prospectPageObjects.prospecttitle);
            elementDisplayed(driver,prospectPageObjects.individualText);
            elementDisplayed(driver,prospectPageObjects.orgnizationText);
            elementDisplayed(driver,prospectPageObjects.prospectsort);
            elementDisplayed(driver,prospectPageObjects.createNewQuote);
            elementDisplayed(driver,prospectPageObjects.searchprospect);
            elementDisplayed(driver,prospectPageObjects.searchIcon);
            elementDisplayed(driver,prospectPageObjects.prospectstatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("(1)",prospectPageObjects.individualCount.getText());
        Assert.assertEquals("(0)",prospectPageObjects.orgnizationCount.getText());
        clickButton(driver,prospectPageObjects.prospectsort);
    }

    @Test(priority = 18)
    public void testCheckOrganizationProspectPage()
    {
        startTest("Organization Prospect Page", "Checking the Organization prospect page", "Organization ProspectPage");
        clickButton(driver,prospectPageObjects.orgnizations);
        try {
            Assert.assertFalse(prospectPageObjects.addmorebutton.isDisplayed(),"Button not displayed");
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }

    }



    @Test(priority = 19)
    public void testAddActivity() throws InterruptedException {
        startTest("Activity", "Test to add an call activity", "Activity");
        clickButton(driver, homePageObject.activities);
//       try {
//           if (!activityPageObjects.addactivityButton.isDisplayed()) {
//               clickButton(driver, activityPageObjects.addactivityButton);
//           }
//       }catch (ElementNotVisibleException e)
//       {
//           System.out.println("the add activity button not displayed");
//        }
    }

    @Test(priority = 20)
    public void testMeetingAddActivityDetails() throws InterruptedException
    {
        startTest("Activity", "Test to add details for meeting activity", "Activity");
        waitForScreenToLoad(driver,activityPageObjects.contactsearch,30);
        enterText(driver,activityPageObjects.contactsearch,ReadExcel.getCellData(Constant.activitySheetName,1,0));
        clickButton(driver,activityPageObjects.contactselect);
        selectBytext(activityPageObjects.activitytypeselect,ReadExcel.getCellData(Constant.activitySheetName,1,1));
        String activitydate = getDate();
        enterText(driver,activityPageObjects.activitydate,activitydate);
        scrollpage(driver);
        clickButton(driver,activityPageObjects.activitytime);
        enterText(driver,activityPageObjects.hourinput,"9");
        enterText(driver,activityPageObjects.minutesinput,"45");
        clickButton(driver,activityPageObjects.formatinput);
        clickButton(driver,activityPageObjects.activitytitle);
        enterText(driver,activityPageObjects.activitytitle,ReadExcel.getCellData(Constant.activitySheetName,1,2));
        selectBytext(activityPageObjects.activituduration,ReadExcel.getCellData(Constant.activitySheetName,1,5));
        clickButton(driver,activityPageObjects.activitysavebutton);
    }

    @Test(priority = 21)
    public void DeleteMeetingActivity()
    {
        startTest("Delete Meeting Activity", "test to delete an activity", "Activity");
        clickButton(driver,homePageObject.activities);
        try {
            elementDisplayed(driver,activityPageObjects.todayactivitytitle);
            elementDisplayed(driver,activityPageObjects.todayactivitytime);
            elementDisplayed(driver,activityPageObjects.todayactivityname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            waitForScreenToLoad(driver,activityPageObjects.FirstActivity,60);
            mouseHover(driver,activityPageObjects.FirstActivity,activityPageObjects.deleteActivity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 22)
    public void testCallsAddActivityDetails() throws InterruptedException
    {
        startTest("Activity", "Test to add details for call activity", "Activity");
      //  clickButton(driver,homePageObject.activities);
        waitForScreenToLoad(driver,activityPageObjects.contactsearch,30);
        enterText(driver,activityPageObjects.contactsearch,ReadExcel.getCellData(Constant.activitySheetName,2,0));
        clickButton(driver,activityPageObjects.contactselect);
        selectBytext(activityPageObjects.activitytypeselect,ReadExcel.getCellData(Constant.activitySheetName,2,1));
        clickButton(driver,activityPageObjects.datepicker);
        selectBytext(activityPageObjects.activitymonth,"Jan");
        selectBytext(activityPageObjects.activityyear,"2020");
        clickButton(driver,activityPageObjects.activitydatepicker);
        scrollpage(driver);
        clickButton(driver,activityPageObjects.activitytime);
        enterText(driver,activityPageObjects.hourinput,"10");
        enterText(driver,activityPageObjects.minutesinput,"15");
        clickButton(driver,activityPageObjects.formatinput);
        clickButton(driver,activityPageObjects.activitytitle);
        enterText(driver,activityPageObjects.activitytitle,ReadExcel.getCellData(Constant.activitySheetName,2,2));
        selectBytext(activityPageObjects.activituduration,ReadExcel.getCellData(Constant.activitySheetName,2,5));
        clickButton(driver,activityPageObjects.activitysavebutton);
    }

    @Test(priority = 23)
    public void DeleteCallsActivity()
    {
        startTest("Delete Calls Activity", "test to delete an activity", "Activity");
        clickButton(driver,homePageObject.activities);
        waitForScreenToLoad(driver,activityPageObjects.thisweekActivitybutton,60);
        scrolltoElement(driver,activityPageObjects.thisweekActivitybutton);
        try {
            elementDisplayed(driver,activityPageObjects.thisweekactivityname);
            elementDisplayed(driver,activityPageObjects.thisweekactivitytime);
            elementDisplayed(driver,activityPageObjects.thisweekactivitytitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            waitForScreenToLoad(driver,activityPageObjects.thisweekactivitydelete,60);
            mouseHover(driver,activityPageObjects.thisweekactivitydelete,activityPageObjects.deleteActivity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 24)
    public void testTaskssAddActivityDetails() throws InterruptedException
    {
        startTest("Activity", "Test to add details for Tasks activity", "Activity");
        clickButton(driver,homePageObject.activities);
        waitForScreenToLoad(driver,activityPageObjects.contactsearch,30);
        enterText(driver,activityPageObjects.contactsearch,ReadExcel.getCellData(Constant.activitySheetName,3,0));
        clickButton(driver,activityPageObjects.contactselect);
        selectBytext(activityPageObjects.activitytypeselect,ReadExcel.getCellData(Constant.activitySheetName,3,1));
        clickButton(driver,activityPageObjects.datepicker);
        selectBytext(activityPageObjects.activitymonth,"Dec");
        selectBytext(activityPageObjects.activityyear,"2020");
        clickButton(driver,activityPageObjects.activitydatepicker);
        scrollpage(driver);
        clickButton(driver,activityPageObjects.activitytime);
        enterText(driver,activityPageObjects.hourinput,"9");
        enterText(driver,activityPageObjects.minutesinput,"45");
        clickButton(driver,activityPageObjects.formatinput);
        clickButton(driver,activityPageObjects.activitytitle);
        enterText(driver,activityPageObjects.activitytitle,ReadExcel.getCellData(Constant.activitySheetName,3,2));
        selectBytext(activityPageObjects.activituduration,ReadExcel.getCellData(Constant.activitySheetName,3,5));
        clickButton(driver,activityPageObjects.activitysavebutton);
    }


    @Test(priority = 25)
    public void DeleteTaskActivity()
    {
        startTest("Delete Task Activity", "test to delete an activity", "Activity");
        scrolltoElement(driver,activityPageObjects.laterActivitybutton);
        try {
            elementDisplayed(driver,activityPageObjects.lateractivitytitle);
            elementDisplayed(driver,activityPageObjects.lateractivitytime);
            elementDisplayed(driver,activityPageObjects.lateractivityname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            waitForScreenToLoad(driver,activityPageObjects.lateractivitydelete,60);
            mouseHover(driver,activityPageObjects.lateractivitydelete,activityPageObjects.deleteActivity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 26)
    public void testSelectActivity() throws InterruptedException {
        startTest("Selecting an Activity", "Test to click on later activity", "Activity");
        try {
            elementDisplayed(driver, activityPageObjects.activitypagetitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 27)
    public void testDeleteContact() throws InterruptedException{
        startTest("Delete Contact", "Test to Delete the contact", "Delete Contact");
        clickButton(driver,homePageObject.contacts);
        mouseHover(driver,contactPageObject.modifyContact,contactPageObject.deletecontact);
        clickButton(driver,contactPageObject.confirmdelete);
        waitForScreenToLoad(driver,contactPageObject.fullname,60);

    }

    @Test(priority = 28)
    public void testIsContactDeleted() throws ClassNotFoundException {
        startTest("Contact IsDeleted", "Test to check Contact deleted from DB", "Contacts_DB");
        try {

            Assert.assertEquals(1,Constant.contactDeleted);
        }
        catch (AssertionError e)
        {e.printStackTrace();}

    }

    @Test(priority = 29)
    public void testzoomWindow() throws InterruptedException, AWTException {
        zoomWindow();
        System.out.println(homePageObject.partnerProfile.getText());
        publishReport();

    }

//    @Test(priority = 30)
//    public void testPartnerProfile() throws Exception
//    {
//        startTest("Profile Page", "Test to check the profile page", "Profile");
//        clickButton(driver,homePageObject.partnerProfile);
//
//            elementDisplayed(driver,saudiCheckPageObjects.basicprofiletab);
//            elementDisplayed(driver,saudiCheckPageObjects.bankaccounttab);
//            elementDisplayed(driver,saudiCheckPageObjects.documentstab);
//            elementDisplayed(driver,homePageObject.updateprofileText);
//
//        String partnername = getText(saudiCheckPageObjects.partnerfullname);
//        System.out.println("the partner name is " + partnername);
//
//        String partnermobile = getText(saudiCheckPageObjects.partnermobilenumber);
//        System.out.println("the partner mobile is " + partnermobile);
//
//        String partnerdob = getText(saudiCheckPageObjects.partnerDOB);
//        System.out.println("the partner DOB is " + partnerdob);
//
//        String partnerNID= getText(saudiCheckPageObjects.partnernationalID);
//        System.out.println("the partner DOB is " + partnerNID);
//        publishReport();
//
//    }
*/


    @AfterMethod
    public void getResult(ITestResult result)
    {
        try
        {
            getTestResult(driver,result);
        }catch (Exception e)
        {}

    }

}
