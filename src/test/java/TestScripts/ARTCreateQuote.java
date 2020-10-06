package TestScripts;

import listeners.JyperionListener;
import maindriver.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Constant;
import utility.ReadExcel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utility.ReadExcel.getRowCount;

@Listeners(JyperionListener.class)
public class ARTCreateQuote extends DriverScript
{

    HomePageObject homePageObject;
    ContactPageObject contactPageObject;
    ProspectPageObjects prospectPageObjects;
       PartnerProfilePageObjects partnerProfilePageObjects;
    RegisterPage registerPage ;
    QuotePageObjects quotePageObjects;
    SaudiCheckPageObjects saudiCheckPageObjects;
    ActivityPageObjects activityPageObjects;
    IssuePolicyPageObjects issuePolicyPageObjects;



    public void initialisePageObjects() {

        registerPage = new RegisterPage(driver);
        homePageObject = new HomePageObject(driver);
        contactPageObject = new ContactPageObject(driver);
        prospectPageObjects = new ProspectPageObjects(driver);
        partnerProfilePageObjects = new PartnerProfilePageObjects(driver);
        quotePageObjects = new QuotePageObjects(driver);
        saudiCheckPageObjects = new SaudiCheckPageObjects(driver);
        activityPageObjects = new ActivityPageObjects(driver);
        issuePolicyPageObjects = new IssuePolicyPageObjects(driver);

        try {
            createrReport("ARTDesktop",DriverScript.browserName,DriverScript.browserVersion,DriverScript.browserPlatform);
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


    @Test(priority = 3)
    public void testOnBoardingNewuser() throws InterruptedException {
        startTest("OnBoarding", "Checking the Home page","OnBoarding");
        scrollpage(driver);
        waitForScreenToLoad(driver, registerPage.Saudi, 30);
        try {
            elementDisplayed(driver, registerPage.Saudi);
            System.out.println("the button text is " + registerPage.Saudi.getText());
            clickButton(driver,registerPage.Saudi);

            int partnerMobileNumber = new Double(ReadExcel.getCellData(Constant.saudiOnboardingSheetName, 1, 0)).intValue();
            System.out.println("the partner mobile number  " + partnerMobileNumber);

            enterText(driver, registerPage.MobileNumber, String.valueOf(partnerMobileNumber));
            scrolltoElement(driver,registerPage.NextButton);
           // clickButton(driver, registerPage.NextButton);
            //clickButton(driver, registerPage.consentCheckBox);
            clickButton(driver, registerPage.NextButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 4)
    public void testEnterValidOTP() throws InterruptedException
    {
        startTest("Entering Valid OTP ", " Entering the OTP values", "Entering Valid OTP");
        enterText(driver,registerPage.otp1, "9");
        enterText(driver,registerPage.otp2, "9");
        enterText(driver,registerPage.otp3, "9");
        enterText(driver,registerPage.otp4, "9");
        Thread.sleep(3000);
        scrolltoElement(driver,registerPage.validateOTP);
        clickButton(driver,registerPage.validateOTP);
    }

    @Test(priority = 5)
    public void testOnBoarding()
    {
        startTest("OnBoarding", "Test to do a new on boarding", "OnBoarding");
        waitForScreenToLoad(driver, homePageObject.partnerFullname, 60);
        enterText(driver, homePageObject.partnerFullname , ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,1));
        enterText(driver,homePageObject.partnerEmail, ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,3));
        clickButton(driver,homePageObject.letsgetStartedButton);
        waitForScreenToLoad(driver,homePageObject.quickLearnigText,60);
        driver.findElement((By.xpath("//*[contains(text(),\" CONTINUE WITH HOME PAGE\")]"))).click();
        String welcomemessage = driver.findElement(By.xpath("//div[@class='reward-point registration']/h2")).getText();
        System.out.println("The message is " + welcomemessage);
    }

    @Test(priority = 6)
    public void testWelcomePage() throws Exception {
        startTest("Home Page", "Test to check loading home page", "Homepage");
        elementDisplayed(driver,registerPage.quicklearning);
        elementDisplayed(driver,registerPage.reachout);
        elementDisplayed(driver,registerPage.quotepolicy);
        elementDisplayed(driver,homePageObject.home);
        elementDisplayed(driver,homePageObject.contacts);
        elementDisplayed(driver,homePageObject.prospects);
        elementDisplayed(driver,homePageObject.customers);
        elementDisplayed(driver,homePageObject.activities);
        //elementDisplayed(driver,homePageObject.target);
        elementDisplayed(driver,homePageObject.products);
        elementDisplayed(driver,homePageObject.learning);
        elementDisplayed(driver,homePageObject.settings);
    }

//    @Test(priority = 7)
//    public void testBrokenLinks()
//    {
//        try {
//            startTest("Broken Link", "Test to check Broken links", "Links");
//            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//            System.out.println("The total links are " + allLinks.size());
//            for (int i = 0; i < allLinks.size(); i++) {
//                WebElement elementLinks = allLinks.get(i);
//                String URLlist = elementLinks.getAttribute("href");
//                VerifyLinks(URLlist);
//            }
//        }catch (Exception e)
//        {}
//
//    }

    @Test(priority = 8)
    public void testSaudiCheck()
    {
        startTest("SaudiCheck", " test to perform a saudi check", "SaudiCheck");
        clickButton(driver, partnerProfilePageObjects.welcomepartner);
        waitForScreenToLoad(driver,saudiCheckPageObjects.saudichecktitle,60);
        System.out.println("the title is " + saudiCheckPageObjects.saudichecktitle.getText());

        int partnerNID = new Double(ReadExcel.getCellData(Constant.saudicheckSheetName, 1,0)).intValue();
        System.out.println("the partner ID " + partnerNID);
        clickButton(driver,saudiCheckPageObjects.partnernationalid);
        enterText(driver, saudiCheckPageObjects.partnernationalid,String.valueOf(partnerNID));

        String ownerDOB = null;
        try {
            ownerDOB = ReadExcel.getOwnerDOB(Constant.saudicheckSheetName,1,1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        enterText(driver,saudiCheckPageObjects.partnerDOB,ownerDOB);
        clickButton(driver,saudiCheckPageObjects.partnergetDetails);
    }


    @Test(priority = 9)
    public void testEnterSaudiCheckOTP() throws InterruptedException {
        startTest("Saudi Check OTP", "Test to enter OTP for saudi Check", "SaudiCheck");
        waitForScreenToLoad(driver,saudiCheckPageObjects.saudiCheckVerifyOTPTitle,60);
        Thread.sleep(3000);
        enterText(driver,saudiCheckPageObjects.FirstOTP,"9");
        enterText(driver,saudiCheckPageObjects.SecondOTP,"9");
        enterText(driver,saudiCheckPageObjects.ThirdOTP,"9");
        enterText(driver,saudiCheckPageObjects.FourthOTP,"9");
        scrolltoElement(driver,saudiCheckPageObjects.validaOTPButton);
        clickButton(driver,saudiCheckPageObjects.validaOTPButton);


    }


    @Test(priority = 10)
    public void testProfilepage() throws InterruptedException {
        startTest("Partner Profile", "Test to check the partner profile page", "ProfilePage");
        Thread.sleep(3000);
        try {
            elementDisplayed(driver, partnerProfilePageObjects.updateprofile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickButton(driver, partnerProfilePageObjects.basicprofile);
        clickButton(driver, partnerProfilePageObjects.bankaccount);

        clickButton(driver, partnerProfilePageObjects.bankIban);
        enterText(driver, partnerProfilePageObjects.bankIban,"SA1234567890123456789012");
        enterText(driver, partnerProfilePageObjects.enterIban,"SA1234567890123456789012");
        enterText(driver, partnerProfilePageObjects.accountHolderName,"Harish");
        clickButton(driver, partnerProfilePageObjects.otherdocuments);
        clickButton(driver, partnerProfilePageObjects.bankaccount);
        clickButton(driver, partnerProfilePageObjects.ibanSaveButton);
        //waitForScreenToLoad(driver,partnerProfilePageObjects.iBanOTP,60);
        enterText(driver,saudiCheckPageObjects.FirstOTP,"9");
        enterText(driver,saudiCheckPageObjects.SecondOTP,"9");
        enterText(driver,saudiCheckPageObjects.ThirdOTP,"9");
        enterText(driver,saudiCheckPageObjects.FourthOTP,"9");
        scrolltoElement(driver,saudiCheckPageObjects.validaOTPButton);
        clickButton(driver,saudiCheckPageObjects.validaOTPButton);
        Thread.sleep(4000);
        clickButton(driver, partnerProfilePageObjects.otherdocuments);
        clickButton(driver, partnerProfilePageObjects.accountpref);
        clickButton(driver, partnerProfilePageObjects.preferedGender);
        assertOptions(partnerProfilePageObjects.preferedGender,Constant.preferedGender);
        clickButton(driver, partnerProfilePageObjects.mediumOfEngagement);
        assertOptions(partnerProfilePageObjects.mediumOfEngagement,Constant.mediumOfEngagement);
        clickButton(driver, partnerProfilePageObjects.privacysettings);
        try {
            //elementDisplayed(driver,partnerProfilePageObjects.showbasicprofile);
            elementDisplayed(driver, partnerProfilePageObjects.showProfilePicture);
            elementDisplayed(driver, partnerProfilePageObjects.showSocialMedia);
            elementDisplayed(driver, partnerProfilePageObjects.showWorkAndEdu);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test(priority = 11)
    public void testBasicProfileDetails()
    {
        startTest("BasicProfile", "test to check the values in Basic Profile Details", "Basic Profile");
        clickButton(driver, partnerProfilePageObjects.basicprofile);
        try {
            Assert.assertEquals(Constant.basicDetails_name, partnerProfilePageObjects.Prospectfullname);
            Assert.assertEquals(Constant.basicdetail_phone, partnerProfilePageObjects.mobilepopup);
            Assert.assertEquals(Constant.basicdetails_nationalID, partnerProfilePageObjects.nationalID);
            Assert.assertEquals(Constant.basicdetails_email, partnerProfilePageObjects.email);
            Assert.assertEquals(Constant.basicDetails_DOB, partnerProfilePageObjects.profileDOB);
        }catch (AssertionError e)
        {}
        clickButton(driver, partnerProfilePageObjects.nationaladdress);
        try {
            Assert.assertEquals(Constant.basicDetails_Street, partnerProfilePageObjects.addressStreet);
            Assert.assertEquals(Constant.basicDetails_District, partnerProfilePageObjects.district);
            Assert.assertEquals(Constant.basicDetails_PostalCode, partnerProfilePageObjects.postcalcode);
            Assert.assertEquals(Constant.basicDetails_flatnumber, partnerProfilePageObjects.buildingNumber);
        }catch (AssertionError e)
        {}

    }

    @Test(priority = 12)
    public void testProfileDocuments() {
        startTest("Profile Documents", "test to check the profile documents", "Profile Documents");
        clickButton(driver, partnerProfilePageObjects.otherdocuments);
        try {
            elementDisplayed(driver, partnerProfilePageObjects.documents);
            elementDisplayed(driver, partnerProfilePageObjects.workExperience);
            elementDisplayed(driver, partnerProfilePageObjects.socialMedia);
        } catch (Exception e) {
            e.printStackTrace();
        }

        clickButton(driver, partnerProfilePageObjects.workExperience);
        enterText(driver, partnerProfilePageObjects.jobtitle, "Manager");
        assertOptions(partnerProfilePageObjects.education, Constant.basicProfile_Education);
        clickButton(driver, partnerProfilePageObjects.socialMedia);
        try {
            elementDisplayed(driver, partnerProfilePageObjects.twitterIcon);
            elementDisplayed(driver, partnerProfilePageObjects.instagramIcon);
            elementDisplayed(driver, partnerProfilePageObjects.instagramIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickButton(driver, partnerProfilePageObjects.saveButon);
        waitForScreenToLoad(driver, partnerProfilePageObjects.bankaccount,60);
    }


    @Test(priority = 13)
    public void testUploadDocuments() throws Exception {
        startTest("Others & Documents", "test to upload documents for Basic profile","Basic profile");
        Thread.sleep(3000);
        clickButton(driver, partnerProfilePageObjects.basicprofile);
        Thread.sleep(2000);
        clickButton(driver, partnerProfilePageObjects.otherdocuments);
        Thread.sleep(2000);
        clickButton(driver, partnerProfilePageObjects.documentsSection);
        Thread.sleep(2000);
        enterText(driver, partnerProfilePageObjects.IdCopy,System.getProperty("user.dir")+"\\documents\\nationalID.pdf");
        Thread.sleep(2000);
        enterText(driver, partnerProfilePageObjects.seCopy,System.getProperty("user.dir")+"\\documents\\educationCert.pdf");
        Thread.sleep(2000);
        enterText(driver, partnerProfilePageObjects.ifceCopy, System.getProperty("user.dir")+"\\documents\\ifceCert.pdf");
        Thread.sleep(18000);
        clickButton(driver, partnerProfilePageObjects.bankaccount);
        clickButton(driver, partnerProfilePageObjects.otherdocuments);
        elementDisplayed(driver, partnerProfilePageObjects.nationalIDDoc);
        elementDisplayed(driver, partnerProfilePageObjects.ifcecertDoc);
        elementDisplayed(driver, partnerProfilePageObjects.educationDoc);

        System.out.println("the document title " + partnerProfilePageObjects.nationalIDDoc.getText());
        System.out.println("the document title " + partnerProfilePageObjects.ifcecertDoc.getText());
        System.out.println("the document title " + partnerProfilePageObjects.educationDoc.getText());

    }

    @Test(priority = 14)
    public void testAddYourFirstContact()
    {
        startTest("Add your First Contact", "Test to add your first contact", "Contact");
        clickButton(driver,homePageObject.contacts);
        enterText(driver, contactPageObject.fullname, ReadExcel.getCellData(Constant.ContactPage, 1, 0));
        enterText(driver, contactPageObject.mobilenumber, ReadExcel.getCellData(Constant.ContactPage, 1, 1).replaceAll("[-+.,%EBDAF]", ""));
        enterText(driver, contactPageObject.emailaddress, ReadExcel.getCellData(Constant.ContactPage, 2, 2));
        clickButton(driver,contactPageObject.AddContactButton);
//        assertOptions(contactPageObject.maritalStatusfilter, Constant.maritalstatus);
        scrolltoElement(driver,contactPageObject.saveButton);
        clickButton(driver,contactPageObject.saveButton);
        waitForScreenToLoad(driver,contactPageObject.addmorebutton,60);

    }

    @Test(priority = 15)
    public void testContactPage() throws Exception {
        startTest("Adding a Contact", "Test Adding a contacts", "contacts");
        for( int i=2;i<getRowCount(Constant.ContactPage);i++)
        {
            buttonCliclable(driver,contactPageObject.addmoreContacts);
          //  waitForScreenToLoad(driver, contactPageObject.addmoreContacts, 20);
            clickButton(driver,contactPageObject.addmorebutton);
            enterText(driver, contactPageObject.fullname, ReadExcel.getCellData(Constant.ContactPage, i, 0));
            enterText(driver, contactPageObject.mobilenumber, ReadExcel.getCellData(Constant.ContactPage, i, 1).replaceAll("[-+.,%EBDAF]", ""));
            enterText(driver, contactPageObject.emailaddress, ReadExcel.getCellData(Constant.ContactPage, i, 2));
            //clickButton(driver, contactPageObject.travelproduct);
            clickButton(driver, contactPageObject.addmoreDetails);
            waitForScreenToLoad(driver, contactPageObject.organisation, 30);
            enterText(driver, contactPageObject.organisation, "Mindtree");
            selectBytext(contactPageObject.martialstatus, "Single");
            scrollpage(driver);
            clickButton(driver, contactPageObject.saveButton);
        }
    }

    @Test(priority = 16)
    public void testEditContact() throws Exception
    {
        startTest("Editing a contact ", "test to edit the contact details", "Edit Contact");
        enterText(driver, contactPageObject.contactSearch, ReadExcel.getCellData(Constant.ContactPage, 4, 0));
        contactPageObject.contactSearch.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        mouseHover(driver,contactPageObject.contactEdit,contactPageObject.editContact);
        clickButton(driver,contactPageObject.medicalproduct);
        clickButton(driver,contactPageObject.addmoreDetails);
        enterText(driver,contactPageObject.organisation,ReadExcel.getCellData(Constant.ContactPage, 4, 3));
        enterText(driver,contactPageObject.jobtitle,ReadExcel.getCellData(Constant.ContactPage, 4, 4));
        enterText(driver,contactPageObject.twitter,ReadExcel.getCellData(Constant.ContactPage, 4, 5));
        enterText(driver,contactPageObject.linkedin,ReadExcel.getCellData(Constant.ContactPage, 4, 6));
        clickButton(driver,contactPageObject.saveButton);

    }
//
//    @Test(priority = 15)
//    public void testEditContactNID() throws  Exception
//    {
//        startTest("Contact with NID", "test to add NID to a contact", "Edit Contact");
//        pageElementCompleteLoaded(driver,homePageObject.contacts);
//        clickButton(driver,homePageObject.contacts);
//        enterText(driver, contactPageObject.contactSearch, ReadExcel.getCellData(Constant.ContactPage, 3, 0));
//        contactPageObject.contactSearch.sendKeys(Keys.ENTER);
//        Thread.sleep(5000);
//        mouseHover(driver,contactPageObject.contactEdit,contactPageObject.editContact);
//        clickButton(driver,contactPageObject.addmoreDetails);
//        enterText(driver,contactPageObject.nationalID,"2325072136");
//        enterText(driver,contactPageObject.twitter,ReadExcel.getCellData(Constant.ContactPage, 4, 5));
//        clickButton(driver,contactPageObject.linkedin);
//        enterText(driver,contactPageObject.linkedin,ReadExcel.getCellData(Constant.ContactPage, 4, 6));
//        clickButton(driver,contactPageObject.saveButton);
//        Thread.sleep(3000);
//    }


    @Test(priority = 17)
    public void testDeleteContact() throws Exception
    {
        startTest("Editing a contact ", "test to edit the contact details", "Edit Contact");
        enterText(driver, contactPageObject.contactSearch, ReadExcel.getCellData(Constant.ContactPage, 4, 0));
        contactPageObject.contactSearch.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        mouseHover(driver,contactPageObject.contactEdit,contactPageObject.deletecontact);
        waitForScreenToLoad(driver,contactPageObject.confirmdeletemessage,60);
        elementDisplayed(driver,contactPageObject.confirmdeletemessage);
        clickButton(driver,contactPageObject.confirmdelete);
       // waitForScreenToLoad(driver,contactPageObject.addmorebutton,60);
        Thread.sleep(6000);
        waitForScreenToLoad(driver,homePageObject.activities,60);

    }


    @Test(priority = 18)
    public void testAddFirstActivity() throws InterruptedException
    {
        startTest("Activity", "Test to add an call activity", "Activity");
        clickButton(driver, homePageObject.activities);
        assertOptions(activityPageObjects.activityTypes, Constant.activityTypes);
        for( int i=1;i<getRowCount(Constant.activitySheetName);i++) {
            waitForScreenToLoad(driver, activityPageObjects.contactsearch, 30);
            enterText(driver, activityPageObjects.contactsearch, ReadExcel.getCellData(Constant.activitySheetName, i, 0));
            clickButton(driver, activityPageObjects.contactselect);
            selectBytext(activityPageObjects.activitytypeselect, ReadExcel.getCellData(Constant.activitySheetName, i, 1));
            String activitydate = getDate();
            enterText(driver, activityPageObjects.activitydate, activitydate);
            scrollpage(driver);
            clickButton(driver, activityPageObjects.activitytime);
            activityPageObjects.hourinput.clear();
            enterText(driver, activityPageObjects.hourinput, "9");
            activityPageObjects.minutesinput.clear();
            enterText(driver, activityPageObjects.minutesinput, "45");
            clickButton(driver, activityPageObjects.formatinput);
            clickButton(driver, activityPageObjects.activitytitle);
            enterText(driver, activityPageObjects.activitytitle, ReadExcel.getCellData(Constant.activitySheetName, i, 2));
            selectBytext(activityPageObjects.activituduration, ReadExcel.getCellData(Constant.activitySheetName, i, 4));
            clickButton(driver, activityPageObjects.activitysavebutton);
            waitForScreenToLoad(driver,activityPageObjects.activityaddactivityButton,60);
            clickButton(driver,activityPageObjects.activityaddactivityButton);
        }
    }

    @Test(priority = 19)
    public void testAssertActivityTabs()
    {
        startTest("Activity Tabs", "Test to check the activity tabs", "Activity");
        clickButton(driver,homePageObject.contacts);
        clickButton(driver,homePageObject.activities);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"view_activitylist_id\"]/div[1]/div/button[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"view_activitylist_id\"]/div[1]/div/button[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"view_activitylist_id\"]/div[1]/div/button[3]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"view_activitylist_id\"]/div[1]/div/button[4]")).isDisplayed());
    }



    @Test(priority = 20)
    public void DeleteActivity()
    {
        startTest("Delete Activity", "test to delete an activity", "Activity");
        try {
            waitForScreenToLoad(driver,activityPageObjects.FirstActivity,60);
            mouseHover(driver,activityPageObjects.FirstActivity,activityPageObjects.deleteActivity);
            waitForScreenToLoad(driver,activityPageObjects.activityDeletemessage,60);
            clickButton(driver,activityPageObjects.confirmdeleteActivity);
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 21)
    public void DoneActivity()
    {
        startTest("Done Activity", "test to Done an activity", "Activity");
        clickButton(driver,homePageObject.contacts);
        clickButton(driver,homePageObject.activities);
        try {
            waitForScreenToLoad(driver,activityPageObjects.FirstActivity,60);
            mouseHover(driver,activityPageObjects.FirstActivity,activityPageObjects.doneActivity);
            waitForScreenToLoad(driver,activityPageObjects.activityCompletemessage,60);
            clickButton(driver,activityPageObjects.confirmDoneActivity);
          Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 22)
    public void testAddContactAsProspect() throws InterruptedException {
        startTest("Addig Contact as Prospect", "Test to convert contact as Prospect","Prospect");
        clickButton(driver,homePageObject.contacts);
        for( int i=1;i<=2;i++)
        {
            //enterText(driver, contactPageObject.contactSearch, ReadExcel.getCellData(Constant.ContactPage, i, 0)+"\n");
            enterText(driver, contactPageObject.contactSearch, ReadExcel.getCellData(Constant.ContactPage, i, 0));
            contactPageObject.contactSearch.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            clickButton(driver, contactPageObject.addProspectButton);
            waitForScreenToLoad(driver,prospectPageObjects.prospectTitle,60);
            clickButton(driver,homePageObject.contacts);

        }

    }

//    @Test(priority = 5)
//    public void testCheckProspectPage()
//    {
//        startTest("Individual Prospect Page", "Checking the Individual prospect page", "Individual ProspectPage");
//        clickButton(driver,homePageObject.prospects);
//        try {
//            elementDisplayed(driver,prospectPageObjects.prospecttitle);
//            elementDisplayed(driver,prospectPageObjects.individualText);
//            elementDisplayed(driver,prospectPageObjects.orgnizationText);
//            elementDisplayed(driver,prospectPageObjects.prospectsort);
//            elementDisplayed(driver,prospectPageObjects.searchprospect);
//            elementDisplayed(driver,prospectPageObjects.searchIcon);
//            elementDisplayed(driver,prospectPageObjects.prospectstatus);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Assert.assertEquals("(0)",prospectPageObjects.orgnizationCount.getText());
//
//    }


    @Test(priority = 23)
    public void testCreateQuoteSaudi() throws InterruptedException
    {
        startTest("Basic TPL Individaul Sequqnce", "Test to check get details using sequence", "Sequence");
        clickButton(driver,homePageObject.activities);
        clickButton(driver, homePageObject.prospects);
       // enterText(driver, prospectPageObjects.searchprospect, ReadExcel.getCellData(Constant.ContactPage, 1, 0) + "\n");

        enterText(driver, prospectPageObjects.searchprospect, ReadExcel.getCellData(Constant.ContactPage, 1, 0));
        Thread.sleep(3000);
        // prospectPageObjects.searchprospect.sendKeys(Keys.ENTER);
        clickButton(driver,prospectPageObjects.searchIcon);

        waitForScreenToLoad(driver,prospectPageObjects.createNewQuote,60);
        clickButton(driver, prospectPageObjects.createNewQuote);

        int NIDvalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 1, 1)).intValue();
        enterText(driver, quotePageObjects.ownernationalID, String.valueOf(NIDvalue));

//        clickButton(driver,quotePageObjects.ownerdob);
//        clickButton(driver,quotePageObjects.individualyear);
//        selectBytext(quotePageObjects.individualyear,"1971");
//        clickButton(driver,quotePageObjects.individualmonth);
//        Thread.sleep(3000);
//        selectBytext(quotePageObjects.individualmonth,"August");
//        Thread.sleep(3000);
//        clickButton(driver,quotePageObjects.individaulDate);
//        Thread.sleep(5000);


        String ownerDOB = null;
        try {
            ownerDOB = ReadExcel.getOwnerDOB(Constant.createQuoteSheet,1,2);
                   // ReadExcel.getOnwerDate(1,2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        quotePageObjects.ownerdob.clear();
        enterText(driver, quotePageObjects.ownerdob, ownerDOB);

//        String hijridate=null;
//        try {
//            String HownerDOB = ReadExcel.getOwnerDOB(Constant.createQuoteSheet,1,3);
//            // ReadExcel.getOnwerDate(1,2);
//
//            System.out.println("the English DOB is "+ HownerDOB);
//            hijridate = hijriDate(String.valueOf(HownerDOB));
//            System.out.println("the Hijri DOB is "+ String.valueOf(hijridate));
//            Thread.sleep(5000);
//            quotePageObjects.hijriownerDOB.clear();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        enterText(driver,quotePageObjects.hijriownerDOB, String.valueOf(hijridate));



        int Sequencevalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 1, 3)).intValue();
        enterText(driver, quotePageObjects.sequenceNumber,  String.valueOf(Sequencevalue));

        clickButton(driver, quotePageObjects.getDetailsButton);
        scrollUp(driver);
        waitForScreenToLoad(driver, quotePageObjects.quoteprocessing, 60);
        System.out.println("the quote status " + quotePageObjects.quoteprocessing.getText());
        waitForScreenToLoad(driver, quotePageObjects.policyCustomization, 60);
       // System.out.println("the quote sttaus " + quotePageObjects.quoteProcessed.getText());
        //waitForScreenToLoad(driver,quotePageObjects.clickquote,120);
        //System.out.println("the quote sttaus " + quotePageObjects.clickquote.getText());
        //clickButton(driver,quotePageObjects.clickquote);

        //calculating premium
        clickButton(driver, quotePageObjects.drivingexperience);
        selectBytext(quotePageObjects.drivingexperience, ReadExcel.getCellData(Constant.createQuoteSheet, 1, 5).replaceAll("[.0]", ""));
        clickButton(driver, quotePageObjects.driverusage);
        selectBytext(quotePageObjects.driverusage, ReadExcel.getCellData(Constant.createQuoteSheet, 1, 6));
        clickButton(driver, quotePageObjects.occuption);
        selectBytext(quotePageObjects.occuption, ReadExcel.getCellData(Constant.createQuoteSheet, 1, 8));
        clickButton(driver, quotePageObjects.education);
        selectBytext(quotePageObjects.education, ReadExcel.getCellData(Constant.createQuoteSheet, 1, 9));
        clickButton(driver, quotePageObjects.submitQuote);
//        scrollUp(driver);
        waitForScreenToLoad(driver,quotePageObjects.calcuatingmessage,60);
        waitForScreenToLoad(driver,quotePageObjects.sarValue,120);
        System.out.println("The Premium amount is " + getText(quotePageObjects.totalPremium));

        //sharing the quote
        //waitForScreenToLoad(driver, quotePageObjects.sharebutton, 60);
        scrolltoElement(driver, quotePageObjects.sharequotebutton);
        buttonCliclable(driver,quotePageObjects.sharequotebutton);
        clickButton(driver, quotePageObjects.sharequotebutton);
        scrollUp(driver);
        System.out.println("The Premium amount is " + getText(quotePageObjects.totalPremium));
        waitForScreenToLoad(driver, quotePageObjects.quoteshared, 120);
        Thread.sleep(10000);
    }

/*
    @Test(priority = 24)
    public void testCreateQuoteforSME() throws InterruptedException
    {
        startTest("SME Individaul", "Test to check get details using sequence", "SME");
        clickButton(driver, homePageObject.prospects);
        // enterText(driver, prospectPageObjects.searchprospect, ReadExcel.getCellData(Constant.ContactPage, 1, 0) + "\n");

        enterText(driver, prospectPageObjects.searchprospect, ReadExcel.getCellData(Constant.ContactPage, 2, 0));
        Thread.sleep(3000);
        clickButton(driver,prospectPageObjects.searchIcon);

        waitForScreenToLoad(driver,prospectPageObjects.createNewQuote,60);
        clickButton(driver, prospectPageObjects.createNewQuote);
        clickButton(driver,quotePageObjects.smeCheckbox);
        Thread.sleep(5000);

        int NIDvalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 4, 1)).intValue();
        enterText(driver, quotePageObjects.ownernationalID, ReadExcel.getCellData(Constant.createQuoteSheet, 4, 1).replaceAll("[-+.,%EBDAF]", ""));
        Thread.sleep(5000);

        enterText(driver,quotePageObjects.smeCRNumber,ReadExcel.getCellData(Constant.createQuoteSheet, 4, 1).replaceAll("[-+.,%EBDAF]", ""));
        Thread.sleep(5000);

        int Sequencevalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 4, 3)).intValue();
        enterText(driver, quotePageObjects.sequenceNumber,  ReadExcel.getCellData(Constant.createQuoteSheet, 4, 3).replaceAll("[-+.,%EBDAF]", ""));

        clickButton(driver, quotePageObjects.getDetailsButton);
        scrollUp(driver);
        waitForScreenToLoad(driver, quotePageObjects.quoteprocessing, 60);
        System.out.println("the quote status " + quotePageObjects.quoteprocessing.getText());
        waitForScreenToLoad(driver, quotePageObjects.submitQuote, 60);
        selectBytext(quotePageObjects.ownerCity,"Al Qunfudhah");
        enterText(driver,quotePageObjects.ownerCompany,"SME Company");
        enterText(driver,quotePageObjects.ownerPostalCode,"57020");

        clickButton(driver, quotePageObjects.submitQuote);
//        scrollUp(driver);
        waitForScreenToLoad(driver,quotePageObjects.calcuatingmessage,60);
        waitForScreenToLoad(driver,quotePageObjects.sarValue,120);
        System.out.println("The Premium amount is " + getText(quotePageObjects.totalPremium));


        waitForScreenToLoad(driver,quotePageObjects.calcuatingmessage,60);
        waitForScreenToLoad(driver,quotePageObjects.sarValue,120);
        System.out.println("The Premium amount is " + getText(quotePageObjects.totalPremium));

        //sharing the quote
        buttonCliclable(driver,quotePageObjects.sharequotebutton);
        scrolltoElement(driver, quotePageObjects.sharequotebutton);
        clickButton(driver, quotePageObjects.sharequotebutton);
        scrollUp(driver);
        System.out.println("The Premium amount is " + getText(quotePageObjects.totalPremium));
        waitForScreenToLoad(driver, quotePageObjects.quoteshared, 120);

    }
*/

    @Test(priority = 25)
    public void testCreateQuoteNonSaudi() throws InterruptedException
    {
        startTest("Non Saudi", "Test to check get details using sequence", "Non Saudi");
        clickButton(driver,homePageObject.activities);
        clickButton(driver, homePageObject.prospects);
        // enterText(driver, prospectPageObjects.searchprospect, ReadExcel.getCellData(Constant.ContactPage, 1, 0) + "\n");

        enterText(driver, prospectPageObjects.searchprospect, ReadExcel.getCellData(Constant.ContactPage, 2, 0));
        Thread.sleep(3000);
        // prospectPageObjects.searchprospect.sendKeys(Keys.ENTER);
        clickButton(driver,prospectPageObjects.searchIcon);

        waitForScreenToLoad(driver,prospectPageObjects.createNewQuote,60);
        clickButton(driver, prospectPageObjects.createNewQuote);

       // int NIDvalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 2, 1)).intValue();
        String  NIDvalue = ReadExcel.getCellData(Constant.createQuoteSheet, 2, 1).replaceAll("[-+.,%EBDAF]", "");
        enterText(driver, quotePageObjects.ownernationalID, ReadExcel.getCellData(Constant.createQuoteSheet, 2, 1).replaceAll("[-+.,%EBDAF]", ""));
        System.out.println("The Non Saudi " + NIDvalue);

        String ownerDOB = null;
        try {
            ownerDOB = ReadExcel.getOwnerDOB(Constant.createQuoteSheet,2,2);
            // ReadExcel.getOnwerDate(1,2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the Non Saudi DOB " + ownerDOB);
        quotePageObjects.ownerdob.clear();
        enterText(driver, quotePageObjects.ownerdob, ownerDOB);

        int Sequencevalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 2, 3)).intValue();
        enterText(driver, quotePageObjects.sequenceNumber,  String.valueOf(Sequencevalue));
        System.out.println("The Non Saudi Sequence " + Sequencevalue);

        clickButton(driver, quotePageObjects.getDetailsButton);
        scrollUp(driver);
        waitForScreenToLoad(driver, quotePageObjects.quoteprocessing, 60);
        System.out.println("the quote status " + quotePageObjects.quoteprocessing.getText());
        waitForScreenToLoad(driver, quotePageObjects.policyCustomization, 120);


        //calculating premium
        scrolltoElement(driver,quotePageObjects.submitQuote);
        buttonCliclable(driver,quotePageObjects.submitQuote);
        Thread.sleep(5000);
        clickButton(driver, quotePageObjects.submitQuote);
//        scrollUp(driver);
        waitForScreenToLoad(driver,quotePageObjects.calcuatingmessage,60);
        waitForScreenToLoad(driver,quotePageObjects.sarValue,120);
        System.out.println("The Premium amount is " + getText(quotePageObjects.totalPremium));

        //sharing the quote
        //waitForScreenToLoad(driver, quotePageObjects.sharebutton, 60);
        scrolltoElement(driver, quotePageObjects.sharequotebutton);
        buttonCliclable(driver,quotePageObjects.sharequotebutton);
        Thread.sleep(5000);
        clickButton(driver, quotePageObjects.sharequotebutton);
        scrollUp(driver);
        System.out.println("The Premium amount is " + getText(quotePageObjects.totalPremium));
        waitForScreenToLoad(driver, quotePageObjects.quoteshared, 120);
        Thread.sleep(10000);    }



    @Test(priority = 26)
    public void testQuoteShared() throws InterruptedException {
        startTest("Quote Shared", "test to check quote shared and status as Send reminder", "Quote Shared");
        clickButton(driver,homePageObject.activities);
        clickButton(driver, homePageObject.prospects);
        for( int i=1;i<=2;i++) {
            //enterText(driver, contactPageObject.contactSearch, ReadExcel.getCellData(Constant.ContactPage, i, 0)+"\n");
            enterText(driver, prospectPageObjects.searchprospect, ReadExcel.getCellData(Constant.ContactPage, i, 0));
            Thread.sleep(3000);
            clickButton(driver,prospectPageObjects.searchIcon);
            waitForScreenToLoad(driver, partnerProfilePageObjects.sendreminderButton,60);
            try {
                elementDisplayed(driver, partnerProfilePageObjects.sendreminderButton);
                elementDisplayed(driver, partnerProfilePageObjects.quotestatustext);
                elementDisplayed(driver, partnerProfilePageObjects.quoteAmount);
                elementDisplayed(driver, partnerProfilePageObjects.quoreSharedDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
            prospectPageObjects.searchprospect.clear();
        }


    }


    @Test(priority = 27)
    public void TestAcceptQuote() throws InterruptedException {
        startTest("Accept Quote", "test to accept the quote", "Quote");
        WebDriverWait wait = new WebDriverWait(driver, 60);


        startTest("Accept Quote", "test to accept the quote", "Quote");


        //  ((JavascriptExecutor)seconddriver).executeScript("window.open('https://login.yahoo.com/?.src=ym&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fmail.yahoo.com%2Fd');");
        ((JavascriptExecutor)driver).executeScript("window.open('','_blank');");

        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);



        // change focus to new tab
        driver.switchTo().window(newTab.get(1));
        Thread.sleep(4000);
        driver.get("https://login.yahoo.com/?.src=ym&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");

        Thread.sleep(4000);
        driver.findElement(By.id("login-username")).sendKeys("artdesktopauto");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
        Thread.sleep(12000);
        driver.findElement(By.xpath("//*[@id=\"login-passwd\"]")).sendKeys("artdesktop");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
        Thread.sleep(1000);

        //      String oldTabs = driver.getWindowHandle();
        //     ArrayList<String> newTabs = new ArrayList<String>(driver.getWindowHandles());
        //     System.out.println("the windows size are " + newTabs.size());
        //    newTab.remove(oldTabs);

        //  driver.switchTo().window(newTabs.get(2));
        //  driver.close();

        // driver.switchTo().window(newTabs.get(1));

        // driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
        List<WebElement> unreademail = driver.findElements(By.xpath("//*[@class=\"u_Z13VSE6\"]"));
        System.out.println("Total No. of Unread Mails: " + unreademail.size());
        Thread.sleep(4000);
        for(int i=0;i<unreademail.size();i++)
        {

            System.out.println(unreademail.get(i).getText());

        }
        unreademail.get(0).click();
        Thread.sleep(6000);
       // driver.findElement(By.xpath("//*[contains(text(),'رابط الإقتباس')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),\"رابط عرض السعر\")]")).click();
        Thread.sleep(6000);

        ArrayList<String> newTab_1 = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(newTab_1.get(1));
        // change focus to new tab
        driver.switchTo().window(newTab_1.get(3));

        waitForPageLoad(driver);

      //  WebElement acceptQuote = driver.findElement(By.id("btnQuoteAccept"));
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("btnQuoteAccept")));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("btnQuoteAccept")));

        System.out.println("the url is " + driver.getCurrentUrl());
        Thread.sleep(30000);
        driver.findElement(By.id("btnQuoteAccept")).click();

        Thread.sleep(20000);
        WebElement validateOTP = driver.findElement(By.id("validateOTP"));
        //wait.until(ExpectedConditions.visibilityOf(validateOTP));
        wait.until(ExpectedConditions.elementToBeClickable(validateOTP));

        WebElement otp1 = driver.findElement(By.id("otpDigit_1"));
        WebElement otp2 = driver.findElement(By.id("otpDigit_2"));
        WebElement otp3 = driver.findElement(By.id("otpDigit_3"));
        WebElement otp4 = driver.findElement(By.id("otpDigit_4"));

        otp1.sendKeys("9");
        otp2.sendKeys("9");
        otp3.sendKeys("9");
        otp4.sendKeys("9");

        validateOTP.click();
        System.out.println("the opened tabs are " + newTab_1.size());
        Thread.sleep(20000);

        ArrayList<String> originalTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(newTab_1.get(3));
        System.out.println("the Final open tabs are" + originalTab.size());
        Thread.sleep(4000);
        driver.switchTo().window(originalTab.get(0));
    }


    @Test(priority = 28)
    public void TestIssuePolicy() throws Exception {
        startTest("Issue Policy", " test to issue an Motor TPL Policy", "IssuePolicy");
        clickButton(driver,homePageObject.contacts);
        clickButton(driver,homePageObject.prospects);
        clickButton(driver,issuePolicyPageObjects.issuePolicyButton);
        waitForScreenToLoad(driver,issuePolicyPageObjects.issuePolicyTotalPremium,60);
        scrolltoElement(driver,issuePolicyPageObjects.proceedPayment);
        elementDisplayed(driver,issuePolicyPageObjects.proceedPayment);
        clickButton(driver,issuePolicyPageObjects.proceedPayment);
        elementDisplayed(driver,issuePolicyPageObjects.payhereButton);
        clickButton(driver,issuePolicyPageObjects.payhereButton);
        waitForScreenToLoad(driver,issuePolicyPageObjects.creditCard,60);
        clickButton(driver,issuePolicyPageObjects.creditCard);
        waitForScreenToLoad(driver,issuePolicyPageObjects.creditcardNumber,60);
        enterText(driver,issuePolicyPageObjects.creditcardNumber,"4111111111111111");
        enterText(driver,issuePolicyPageObjects.creditCardExpiry,"0521");
        enterText(driver,issuePolicyPageObjects.creditcardHolder,"Harish");
        enterText(driver,issuePolicyPageObjects.creditcardCVVr,"123");
        Thread.sleep(3000);
        clickButton(driver,issuePolicyPageObjects.payNowButton);
        selectBytext(issuePolicyPageObjects.returnCode,"Successful");
        clickButton(driver,issuePolicyPageObjects.Submit);
        waitForScreenToLoad(driver,issuePolicyPageObjects.congratsmessage,60);
        elementDisplayed(driver,issuePolicyPageObjects.congratsmessage);
        elementDisplayed(driver,issuePolicyPageObjects.rewardsPoint);
        elementDisplayed(driver,issuePolicyPageObjects.addBankAccount);
        elementDisplayed(driver,issuePolicyPageObjects.dolaterButton);

    }

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
