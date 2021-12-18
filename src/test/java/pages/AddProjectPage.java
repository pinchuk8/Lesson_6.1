package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
        //private By PAGE_OPENED_IDENTIFIER = By.id("name");
        private By PAGE_OPENED_IDENTIFIER = By.xpath("//*[@id='name']");
        //private By Name_Selector = By.id("name");
        private By Name_Selector = By.xpath("//*[@id='name']");
        //private By Announcement_Selector = By.id("announcement");
        private By Announcement_Selector = By.xpath("//*[@id='announcement']");
        //private By Suite_Mode_Single_Selector = By.id("suite_mode_single");
        private By Suite_Mode_Single_Selector = By.xpath("//*[@id='suite_mode_single']");
        private By Accept_Selector = By.xpath("//*[@id='accept']");

    public AddProjectPage (WebDriver driver){
        super(driver);
    }
    public boolean isPageOpened(){
        return !super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    public WebElement getName (){return driver.findElement(Name_Selector);}
    public WebElement getAnnouncement (){return driver.findElement(Announcement_Selector);}
    public WebElement getSuite_Mode_Single (){return driver.findElement(Suite_Mode_Single_Selector);}
    public WebElement getAccept (){return driver.findElement(Accept_Selector);}


    public void add_project(){
        getName().sendKeys(ReadProperties.getName());
        getAnnouncement().sendKeys(ReadProperties.getAnnouncement());
        getSuite_Mode_Single().click();
        getAccept().click();

    }
}

