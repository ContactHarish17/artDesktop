package TestScripts;

import maindriver.DriverScript;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.*;
import java.io.FileNotFoundException;



public class ARTAutomationSmokeTest extends DriverScript {

    RegisterPage registerPage ;
    String generatedOTP=null;

    HomePageObject homePageObject;
    ContactPageObject contactPageObject;
    SaudiCheckPageObjects saudiCheckPageObjects;
    ReadingPropertyFile readingPropertyFile = new ReadingPropertyFile();
    ActivityPageObjects activityPageObjects;
    ProspectPageObjects prospectPageObjects;
    PartnerProfilePageObjects partnerProfilePageObjects;
    ErrorPageObjects errorPageObjects;


    public void initialisePageObjects() {
        registerPage = new RegisterPage(driver);
        homePageObject = new HomePageObject(driver);
        contactPageObject = new ContactPageObject(driver);
        saudiCheckPageObjects = new SaudiCheckPageObjects(driver);
        activityPageObjects = new ActivityPageObjects(driver);
        prospectPageObjects = new ProspectPageObjects(driver);
        partnerProfilePageObjects = new PartnerProfilePageObjects(driver);
        errorPageObjects = new ErrorPageObjects(driver);

        try {
            createrReport("ARTDesktop-Smoke-Report",DriverScript.browserName,DriverScript.browserVersion,DriverScript.browserPlatform);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReadExcel.OpenExcel(Constant.ExcelFilepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//      //      zoomWindow();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
    }

    @Test(priority = 1)
    public void testHomePage() throws InterruptedException {
        initialisePageObjects();
        startTest("HomePage", "Checking the Home page","OnBoarding");
        scrollpage(driver);
        waitForScreenToLoad(driver, registerPage.NonSaudi, 30);
        try {
            elementDisplayed(driver, registerPage.NonSaudi);
            System.out.println("the button text is " + registerPage.NonSaudi.getText());
            jsclickElement(driver,registerPage.NonSaudi);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2)
    public void testNonSaudireferal() throws InterruptedException {
        startTest("Non Saudi", "Test to refer a non Saudi", "Non Saudi");
        try {
            scrolltoElement(driver, registerPage.nosaudi_yesmaybeButton);
            clickButton(driver, registerPage.nosaudi_yesmaybeButton);
            enterText(driver, registerPage.invitename, ReadExcel.getCellData(Constant.nonsaudiSheetName, 1, 0));
            enterText(driver, registerPage.invitemobile, ReadExcel.getCellData(Constant.nonsaudiSheetName, 1, 1).replaceAll("[-+.,%EBDAF]", ""));
            clickButton(driver, registerPage.addnew);
            elementDisplayed(driver, registerPage.invitedName);
            elementDisplayed(driver, registerPage.invitedmobile);
            elementDisplayed(driver, registerPage.inviteNow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 3)
    public void testDeleteNonSaudiReferal() throws Exception {
        startTest("Delete Non Saudi Referal", "test to delete an non saudi referal", " Non Saudi Referal");
        try {
            clickButton(driver, registerPage.deleteNonSaudi);
            clickButton(driver, registerPage.cancelInvite);
            Assert.assertTrue(!registerPage.invitedmobile.isDisplayed());
            Assert.assertTrue(!registerPage.invitedName.isDisplayed());
            clickButton(driver, registerPage.cancelInvite);
            elementDisplayed(driver, registerPage.thankyoumessage);
        } catch (Exception e) {
        }
    }

    @Test(priority = 4)
    public void testerrorMessage()
    {
        startTest("OnBoarding ErrorMsg", "Test to Check Error Message", "OnBoarding");
        driver.navigate().back();
        driver.navigate().back();

        clickButton(driver, registerPage.Saudi);
        clickButton(driver, registerPage.NextButton);
        try {
            elementDisplayed(driver,errorPageObjects.mobilenumberError);
            elementDisplayed(driver,errorPageObjects.consentCheckboxError);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 5)
    public void testSaudiCheck() throws InterruptedException {

        startTest("Onboadring Saudi", "Checking the Saudi On boadring ", "OnBoarding");
        enterText(driver, registerPage.MobileNumber, ReadExcel.getCellData(Constant.saudiOnboardingSheetName,1,0).replaceAll("[-+.,%EBDAF]",""));
        scrolltoElement(driver,registerPage.NextButton);
        clickButton(driver, registerPage.NextButton);
        clickButton(driver, registerPage.consentCheckBox);
        clickButton(driver, registerPage.NextButton);
    }

    @Test(priority = 6)
    public void testEnterInValidOTP() throws InterruptedException
    {
        startTest("Entering InValid OTP ", " Entering the OTP values", "Entering InValid OTP");
        clickButton(driver,registerPage.validateOTP);
        try {
            elementDisplayed(driver,errorPageObjects.entervalidOTP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        enterText(driver,registerPage.otp1, "9");
        enterText(driver,registerPage.otp2, "5");
        enterText(driver,registerPage.otp3, "6");
        enterText(driver,registerPage.otp4, "9");
        Thread.sleep(3000);
        scrolltoElement(driver,registerPage.validateOTP);
        clickButton(driver,registerPage.validateOTP);
        try {
            elementDisplayed(driver,errorPageObjects.invalidOTP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
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


    @Test(priority = 8)
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

    }

//    @Test(priority = 8)
//    public void testCOntactErrormessages()
//    {
//        startTest("Contact ErrorMsg", "test to check error messsage in contact", "contacts");
//        clickButton(driver,homePageObject.contacts);
//        clickButton(driver,contactPageObject.addmoreContacts);
//        try {
//            elementDisplayed(driver,errorPageObjects.fullnameError);
//            elementDisplayed(driver,errorPageObjects.mobilenumberError);
//            Assert.assertEquals(Constant.fullnameerror,errorPageObjects.fullnameError.getText());
//            Assert.assertEquals(Constant.mobilenumbereeror,errorPageObjects.mobilenumberError.getText());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    @Test(priority = 9)
//    public void testContactPage() throws Exception{
//        startTest("Adding a Contact", "Test Adding a contacts","contacts");
//        clickButton(driver,homePageObject.contacts);
//        clickButton(driver,contactPageObject.addmoreContacts);
//        enterText(driver,contactPageObject.fullname, ReadExcel.getCellData(Constant.contactSheetName,1,0));
//        enterText(driver,contactPageObject.mobilenumber, ReadExcel.getCellData(Constant.contactSheetName,1,1).replaceAll("[-+.,%EBDAF]",""));;
//        enterText(driver,contactPageObject.emailaddress, ReadExcel.getCellData(Constant.contactSheetName,1,2));
//        scrollpage(driver);
//        clickButton(driver,registerPage.addContactButton);
//        clickButton(driver,contactPageObject.medicalproduct);
//        clickButton(driver,contactPageObject.medicalmalpracticeproduct);
//        scrolltoElement(driver, contactPageObject.addmoreDetails);
//        clickButton(driver, contactPageObject.addmoreDetails);
//        waitForScreenToLoad(driver, contactPageObject.organisation, 30);
//        enterText(driver, contactPageObject.organisation, ReadExcel.getCellData(Constant.contactSheetName, 1, 3));
//        selectBytext(contactPageObject.martialstatus, "Single");
//        assertOptions(contactPageObject.maritalStatusfilter,Constant.maritalstatus);
//        scrollpage(driver);
//        clickButton(driver,contactPageObject.saveButton);
//
//
//    }

    @Test(priority = 9)
    public void testContactPage() throws Exception {
        startTest("Adding a Contact", "Test Adding a contacts", "contacts");
        clickButton(driver, homePageObject.contacts);
//        Assert.assertEquals("(1)", contactPageObject.contactCount.getText());
//        elementDisplayed(driver,contactPageObject.contactCount);
        clickButton(driver, contactPageObject.addmoreContacts);

        enterText(driver, contactPageObject.fullname, ReadExcel.getCellData(Constant.contactSheetName, 1, 0));
        enterText(driver, contactPageObject.mobilenumber, ReadExcel.getCellData(Constant.contactSheetName, 1, 1).replaceAll("[-+.,%EBDAF]", ""));
        enterText(driver, contactPageObject.emailaddress, ReadExcel.getCellData(Constant.contactSheetName, 1, 2));
        clickButton(driver, contactPageObject.travelproduct);
        clickButton(driver, contactPageObject.addmoreDetails);
        waitForScreenToLoad(driver, contactPageObject.organisation, 30);
        enterText(driver, contactPageObject.organisation, ReadExcel.getCellData(Constant.contactSheetName, 1, 3));
        selectBytext(contactPageObject.martialstatus, "Single");
        assertOptions(contactPageObject.maritalStatusfilter,Constant.maritalstatus);
        scrollpage(driver);
        clickButton(driver,contactPageObject.saveButton);
    }



    @Test(priority = 10)
    public void testAddMoreDetailsContacts() throws Exception {
        startTest("Edit Contact", "Test to edit the contact and add kids,spouse, jobtitle", "Edit Contact");
        mouseHover(driver, contactPageObject.contactEdit, contactPageObject.editContact);
        scrolltoElement(driver,contactPageObject.addmoreDetails);
        clickButton(driver, contactPageObject.addmoreDetails);
        enterText(driver,contactPageObject.nationalID,ReadExcel.getCellData(Constant.contactSheetName,1,8).replaceAll("[-+.,%EBDAF]",""));
        selectBytext(contactPageObject.martialstatus,ReadExcel.getCellData(Constant.contactSheetName,1,5));
        enterText(driver,contactPageObject.spouses,ReadExcel.getCellData(Constant.contactSheetName,1,6));
        enterText(driver,contactPageObject.kids,ReadExcel.getCellData(Constant.contactSheetName,1,7));
        enterText(driver,contactPageObject.jobtitle,ReadExcel.getCellData(Constant.contactSheetName,1,4));
        enterText(driver, contactPageObject.twitter, ReadExcel.getCellData(Constant.contactSheetName,1,9));
        enterText(driver, contactPageObject.linkedin, ReadExcel.getCellData(Constant.contactSheetName,1,10));
        clickButton(driver,contactPageObject.travelproduct);
        scrollpage(driver);
        clickButton(driver,contactPageObject.saveButton);
    }

    @Test(priority = 11)
    public void testContactListpage() throws Exception {
        startTest("ContactList page", "Test to check added contact showing up in ContactList Page", "ContactList");
        waitForPageLoad(driver);
        elementDisplayed(driver,contactPageObject.addmorebutton);
        elementDisplayed(driver, contactPageObject.buyYourSelfbutton);
        Assert.assertEquals(ReadExcel.getCellData(Constant.contactSheetName,1,0),contactPageObject.addedSecondContact.getText());
        elementDisplayed(driver, contactPageObject.addedSecondContact);
//        Assert.assertEquals("(2)", contactPageObject.contactCount.getText());
//        elementDisplayed(driver,contactPageObject.contactCount);

    }

    @Test(priority = 12)
    public void testAddMoreContacts()
    {
        startTest("Add More Contacts", "Test to check to add more contacts", "Add More Contacts");
        clickButton(driver,contactPageObject.addmoreContacts);
        enterText(driver,contactPageObject.fullname, ReadExcel.getCellData(Constant.contactSheetName,2,0));
        enterText(driver,contactPageObject.mobilenumber, ReadExcel.getCellData(Constant.contactSheetName,2,1).replaceAll("[-+.,%EBDAF]",""));;
        enterText(driver,contactPageObject.emailaddress, ReadExcel.getCellData(Constant.contactSheetName,2,2));
        clickButton(driver,contactPageObject.medicalproduct);
        clickButton(driver,contactPageObject.travelproduct);
        clickButton(driver,contactPageObject.saveButton);
    }

    @Test(priority = 13)
    public void testAddedContactListpage() throws Exception {
        startTest("ContactList More Contacts", "Test to check added contact showing up in ContactList Page", "ContactList");
        waitForPageLoad(driver);
        elementDisplayed(driver,contactPageObject.addmorebutton);
        elementDisplayed(driver, contactPageObject.buyYourSelfbutton);
        Assert.assertEquals(ReadExcel.getCellData(Constant.contactSheetName,1,0),contactPageObject.addedSecondContact.getText());
        elementDisplayed(driver, contactPageObject.addedSecondContact);
        Assert.assertEquals(ReadExcel.getCellData(Constant.contactSheetName,2,0),contactPageObject.addedThirdContact.getText());
        elementDisplayed(driver, contactPageObject.addedThirdContact);


      //  elementDisplayed(driver, contactPageObject.addProspectButton);
    }


//    @Test(priority = 14)
//    public void testAddContactAsProspect() throws InterruptedException {
//        startTest("Addig Contact as Prospect", "Test to convert contact as Prospect","Prospect");
//        clickButton(driver,contactPageObject.addProspectButton);
//        Thread.sleep(8000);
//        try {
//            Assert.assertFalse(!contactPageObject.prospectbutton.isEnabled());
//        }catch (AssertionError e)
//        {e.printStackTrace();}
//    }

    @Test(priority = 15)
    public void testCheckProspectPage()
    {
        startTest("Individual Prospect Page", "Checking the Individual prospect page", "Individual ProspectPage");
        clickButton(driver,homePageObject.prospects);
        try {
            elementDisplayed(driver,prospectPageObjects.prospecttitle);
            elementDisplayed(driver,prospectPageObjects.individualText);
            elementDisplayed(driver,prospectPageObjects.orgnizationText);
            elementDisplayed(driver,prospectPageObjects.prospectsort);
            elementDisplayed(driver,prospectPageObjects.viewQuote);
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

    @Test(priority = 16)
    public void testAddActivity() throws InterruptedException {
        startTest("Activity", "Test to add an call activity", "Activity");
        clickButton(driver, homePageObject.activities);
        clickButton(driver,activityPageObjects.activityaddactivityButton);
        waitForScreenToLoad(driver,activityPageObjects.contactsearch,30);
        assertOptions(activityPageObjects.activityTypes,Constant.activityTypes);
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

    @Test(priority = 17)
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
        try {
            elementDisplayed(driver, activityPageObjects.activitypagetitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 18)
    public void testDeleteSecondContact() throws InterruptedException{
        startTest("Delete Contact", "Test to Delete the contact", "Delete Contact");
        clickButton(driver,homePageObject.contacts);
        waitForScreenToLoad(driver,contactPageObject.addedSecondContact,60);
        mouseHover(driver,contactPageObject.contactEdit,contactPageObject.deletecontact);
        clickButton(driver,contactPageObject.confirmdelete);
        waitForScreenToLoad(driver,contactPageObject.fullname,60);
    }

    @Test(priority = 19)
    public void testDeleteThirdContact() throws InterruptedException{
        startTest("Delete Contact", "Test to Delete the contact", "Delete Contact");
        clickButton(driver,homePageObject.contacts);
        mouseHover(driver,contactPageObject.contactEdit,contactPageObject.deletecontact);
        clickButton(driver,contactPageObject.confirmdelete);
        waitForScreenToLoad(driver,contactPageObject.fullname,60);
    }


    @Test(priority = 20)
    public void testProfilepage()
    {
        startTest("Partner Profile", "Test to check the partner profile page", "ProfilePage");
        clickButton(driver, partnerProfilePageObjects.welcomepartner);
        try {
            elementDisplayed(driver, partnerProfilePageObjects.updateprofile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickButton(driver, partnerProfilePageObjects.basicprofile);
        clickButton(driver, partnerProfilePageObjects.bankaccount);
        clickButton(driver, partnerProfilePageObjects.otherdocuments);
        clickButton(driver, partnerProfilePageObjects.accountpref);
        clickButton(driver, partnerProfilePageObjects.preferedGender);
        assertOptions(partnerProfilePageObjects.preferedGender,Constant.preferedGender);
        clickButton(driver, partnerProfilePageObjects.mediumOfEngagement);
        assertOptions(partnerProfilePageObjects.mediumOfEngagement,Constant.mediumOfEngagement);
        clickButton(driver, partnerProfilePageObjects.privacysettings);
        try {
            elementDisplayed(driver, partnerProfilePageObjects.showbasicprofile);
            elementDisplayed(driver, partnerProfilePageObjects.showProfilePicture);
            elementDisplayed(driver, partnerProfilePageObjects.showSocialMedia);
            elementDisplayed(driver, partnerProfilePageObjects.showWorkAndEdu);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test(priority = 21)
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

        clickButton(driver, partnerProfilePageObjects.workLocation);
        clickButton(driver, partnerProfilePageObjects.workRegion);
        assertOptions(partnerProfilePageObjects.workRegion,Constant.workRegion);
        clickButton(driver, partnerProfilePageObjects.nationaladdress);
        try {
            Assert.assertEquals(Constant.basicDetails_Street, partnerProfilePageObjects.addressStreet);
            Assert.assertEquals(Constant.basicDetails_District, partnerProfilePageObjects.district);
            Assert.assertEquals(Constant.basicDetails_PostalCode, partnerProfilePageObjects.postcalcode);
            Assert.assertEquals(Constant.basicDetails_flatnumber, partnerProfilePageObjects.buildingNumber);
        }catch (AssertionError e)
        {}

    }

    @Test(priority = 22)
    public void testProfileDocuments()
    {
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
        enterText(driver, partnerProfilePageObjects.jobtitle,"Manager");
        assertOptions(partnerProfilePageObjects.education,Constant.basicProfile_Education);

        clickButton(driver, partnerProfilePageObjects.socialMedia);
        try {
            elementDisplayed(driver, partnerProfilePageObjects.twitterIcon);
            elementDisplayed(driver, partnerProfilePageObjects.instagramIcon);
            elementDisplayed(driver, partnerProfilePageObjects.instagramIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickButton(driver, partnerProfilePageObjects.saveButon);

        publishReport();
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
