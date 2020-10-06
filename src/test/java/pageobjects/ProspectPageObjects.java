package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProspectPageObjects extends MainPageObject {

    public ProspectPageObjects(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//*[@class=\"cell medium-6 large-6 small-12 \"]/h2")
    public WebElement prospecttitle;

    @FindBy(id="pro-search-tab-1-label")
    public WebElement individual;

    @FindBy(id="pro-search-tab-2-label")
    public WebElement orgnizations;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-2-label\"]/span[1]")
    public WebElement orgnizationText;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-1-label\"]/span[1]")
    public WebElement individualText;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-2-label\"]/span[2]")
    public WebElement orgnizationCount;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-1-label\"]/span[2]")
    public WebElement individualCount;

    @FindBy(xpath = "//*[@id=\"pro-search-tab-1\"]/div[1]/ul/li")
    public WebElement prospectsort;

    @FindBy(xpath = "//*[@id=\"sort-by\"]/li[1]/a")
    public WebElement mostrecentsort;

    @FindBy(xpath = "//*[@id=\"sort-by\"]/li[2]/a")
    public WebElement quotestatussort;

    //@FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[3]/a")
    @FindBy(xpath = "//*[contains(text(),'View Quote Now')]")
    public WebElement viewQuote;

    @FindBy(xpath = "//*[contains(text(),'Create New Quote')]")
    public WebElement createNewQuote;

    @FindBy(id="viewQuote")
    public WebElement prospectInitial;

   // @FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[2]/h4")
    @FindBy(xpath = "//*[contains(text(),\"Harish\")]")
    public WebElement prospectName;

   // @FindBy(xpath = "//*[@id=\"serachList\"]/div[1]/div[2]/div[1]/text()")
    @FindBy(xpath = "//*[contains(text(),\"Not quoted\")]")
    public WebElement prospectstatus;

    @FindBy(xpath = "//*[@id=\"serachList\"]/div[2]/a")
    public WebElement addmorebutton;

    //@FindBy(id = "search-input")
    @FindBy(xpath = "//*[@id=\"search-input\"]")
    public WebElement searchprospect;

    @FindBy(xpath = "//*[@class=\"search-btn\"]")
    public WebElement searchIcon;

    @FindBy(id="sort-by")
    public WebElement prospectsortmenu;

    @FindBy(xpath = "//*[@id=\"serachList\"]/p")
    public WebElement noprospecttext;

    @FindBy(xpath = "//*[@class=\"button addPropsectBtn\"]")
    public WebElement addProspect;

    @FindBy(xpath = "//*[@class='pro-search-vehicle']/text()")
    public WebElement quoteStatus;

    @FindBy(id = "search-input")
    public WebElement prospectSearch;


    @FindBy(xpath = "//*[@id=\"prospectPage\"]/div[1]/div[1]/h2")
    public WebElement prospectTitle;

}
