package pages;

import baseEntities.BasePage;
import models.Project;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/add/1";

    private static final By PAGE_OPENED_IDENTIFIER = By.className("content-header-title page_title display-inline-block");
    protected  By NameField_Selector = By.id("name");
    protected  By AnnouncementField_Selector = By.id("announcement");
    protected  By AddButton_Selector = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }
    public AddProjectPage(WebDriver driver,boolean openPageByUrl){
        super(driver,openPageByUrl);
    }

    @Override
    protected void openPage() {driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }
    public WebElement getAddButton() {
        return driver.findElement(AddButton_Selector);
    }
    public WebElement getNameField() {return driver.findElement(NameField_Selector);}
    public WebElement getAnnouncementField() {return driver.findElement(AnnouncementField_Selector);}

    public void addProject (Project project){
        getNameField().sendKeys(project.getProject_name());
        getAnnouncementField().sendKeys(project.getAnnouncement());
        getAddButton().click();
    }
}
