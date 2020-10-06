package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class ActivityPageObjects extends MainPageObject {

    public ActivityPageObjects(WebDriver driver)
    {
        super(driver);
    }

   // @FindBy(xpath = "//*[@id=\"view_activitylist_id\"]/h2")
   // @FindBy(xpath = "//*[contains(text(),'Add An Activity')]")
    @FindBy(xpath = "//*[@id=\"add_anactivity_id\"]/h2")
    public WebElement activitypagetitle;

    @FindBy(xpath = "//*[@id=\"view_activitylist_id\"]/div[2]/div/a")
    public WebElement activityaddactivityButton;

    @FindBy(xpath = "//*[@id=\"view_activitylist_id\"]/div[1]/div/button[1]")
    public WebElement allactivityTab;

    @FindBy(xpath = "//*[@id=\"view_activitylist_id\"]/div[1]/div/button[2]")
    public WebElement callactivityTab;

    @FindBy(xpath = "//*[@id=\"view_activitylist_id\"]/div[1]/div/button[3]")
    public WebElement meetingsactivityTab;

    @FindBy(xpath = "//*[@id=\"view_activitylist_id\"]/div[1]/div/button[4]")
    public WebElement tasksactivityTab;

    @FindBy(xpath = "//*[@id=\"view_activitylist_id\"]/div[2]/h3")
    public WebElement todayactivity;

    @FindBy(xpath = "//*[@class=\"cell mt15\"]/a")
    public WebElement addactivityButton;

    @FindBy(xpath = "//*[@id=\"add_anactivity_id\"]/h2")
    public WebElement addactivitytitle;

    @FindBy(id = "activity_auto_id")
    public WebElement contactsearch;

   // @FindBy(xpath = "//*[@id=\"activity_auto_idautocomplete-list\"]/div/text()")
   // @FindBy(xpath = "//*[@id=\"activity_auto_idautocomplete-list\"]/div")
    @FindBy(id = "activity_auto_idautocomplete-list")
    public WebElement contactselect;

    @FindBy(id = "ddlType")
    public WebElement activitytypeselect;

    @FindBy(id="txtTitle")
    public WebElement activitytitle;

    @FindBy(xpath = "//*[@id=\"add_anactivity_id\"]/div[1]/div[4]/i")
    public WebElement datepicker;

    @FindBy(id="txtDate")
    public WebElement activitydate;

    @FindBy(id="txtTime")
    public WebElement activitytime;

    @FindBy(xpath = "//*[@id=\"add_anactivity_id\"]/div[1]/div[5]/div[1]/div/div[2]/div[2]/input")
    public WebElement hourinput;

    @FindBy(xpath = "//*[@id=\"add_anactivity_id\"]/div[1]/div[5]/div[1]/div/div[3]/div[2]/input")
    public WebElement minutesinput;

    @FindBy(xpath = "//*[@id=\"add_anactivity_id\"]/div[1]/div[5]/div[1]/div/div[4]/div[3]")
    public WebElement formatinput;

    @FindBy(id = "ddlDuration")
    public WebElement activituduration;

    @FindBy(xpath = "//*[@id=\"add_anactivity_id\"]/div[2]/button")
    public WebElement activitysavebutton;

    @FindBy(xpath = "//*[contains(text(),'LATER')]")
    public WebElement lateractivity;

    @FindBy(xpath = "//*[contains(text(),'THIS WEEK')]")
    public WebElement weekactivity;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
    public WebElement activitymonth;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
    public WebElement activityyear;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[7]/a")
    public WebElement activitydatepicker;

    @FindBy(xpath = "//*[contains(text(),'LATER')]")
    //@FindBy(xpath = "//*[@id=\"uhbp70-accordion-label\"]/text()")
    public WebElement laterActivitybutton;

    @FindBy(id = "ddlType")
    public WebElement activityTypes;


//    @FindAll(
//            {
//                    @FindBy(id = "06gyfc-accordion-label"),
//                    @FindBy(xpath = "//*[@id=\"avzq5q-accordion-label\"]/text()")
//            })
    @FindBy(xpath = "//*[contains(text(),'THIS WEEK')]")
   // @FindBy(xpath = "//*[@id=\"cm5xiw-accordion-label\"]/text()")
    public WebElement thisweekActivitybutton;

    @FindBy(xpath = "//*[@id=\"iyx5uc-accordion-label\"]/text()")
    public WebElement todayActivitybutton;

    @FindBy(xpath = "//*[@class=\"deldone-ico-cls\"]")
    public WebElement activityDeletebutton;

   // @FindBy(xpath = "//*[@id=\"example-dropdown-3\"]/ul/li[2]/a")
    @FindBy(xpath = "//*[contains(text(),\"DONE\")]")
    public WebElement doneActivity;

    @FindBy(xpath="//*[contains(text(),\"DELETE\")]")
    public  WebElement deleteActivity;

    @FindBy(xpath = "//*[@id=\"Modal-4C52A567-9AF3-4574-B293-40352CB22146\"]/div/p")
    public  WebElement activityDeletemessage;

    @FindBy(xpath = "//*[@id=\"Modal-74298602-A044-4504-8C45-C2B41C925615\"]/div/p")
    public WebElement activityCompletemessage;

    @FindBy(xpath = "//*[@id=\"Modal-4C52A567-9AF3-4574-B293-40352CB22146\"]/div/a[1]")
    public WebElement confirmdeleteActivity;

    @FindBy(xpath = "//*[@id=\"Modal-74298602-A044-4504-8C45-C2B41C925615\"]/div/a[1]")
    public WebElement confirmDoneActivity;

    @FindBy(xpath = "//*[@class=\"accordion-content this-tdy-cls\"]/div/div[1]/h4")
    public WebElement todayactivitytitle;

    @FindBy(xpath = "//*[@class=\"accordion-content this-tdy-cls\"]/div/div[2]/span")
    public WebElement todayactivitytime;

    @FindBy(xpath = "//*[@class=\"accordion-content this-tdy-cls\"]/div/div[3]/span")
    public WebElement todayactivityname;

    @FindBy(xpath = "//*[@class=\"accordion-content this-tdy-cls\"]/div[1]/div[1]/i[2]")
    public WebElement FirstActivity;

    @FindBy(xpath = "//*[@class=\"accordion-content this-tdy-cls\"]/div[2]/div[1]/i[2]")
    public WebElement SecondActivity;

    @FindBy(xpath = "//*[@class=\"accordion-content this-week-cls\"]/div[1]/div[1]/h4")
    public WebElement thisweekactivitytitle;

    @FindBy(xpath = "//*[@class=\"accordion-content this-week-cls\"]/div[1]/div[2]/span")
    public WebElement thisweekactivitytime;

    @FindBy(xpath = "//*[@class=\"accordion-content this-week-cls\"]/div[1]/div[3]/span")
    public WebElement thisweekactivityname;

    @FindBy(xpath = "//*[@class=\"accordion-content this-week-cls\"]/div[1]/div[1]/i[2]")
    public WebElement thisweekactivitydelete;

    @FindBy(xpath = "//*[@class=\"accordion-content this-later-cls\"]/div[1]/div[1]/h4")
    public WebElement lateractivitytitle;

    @FindBy(xpath = "//*[@class=\"accordion-content this-later-cls\"]/div[1]/div[2]/span")
    public WebElement lateractivitytime;

    @FindBy(xpath = "//*[@class=\"accordion-content this-later-cls\"]/div[1]/div[3]/span")
    public WebElement lateractivityname;

    @FindBy(xpath = "//*[@class=\"accordion-content this-later-cls\"]/div[1]/div[1]/i[2]")
    public WebElement lateractivitydelete;













}
