package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import models.Pr;
//import models.Project;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class AddProjectPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/add/1";

    private static final By PAGE_OPENED_IDENTIFIER = By.id("accept");
    protected  By NameField_Selector = By.id("name");
    protected  By AnnouncementField_Selector = By.id("announcement");
    protected  By AddButton_Selector = By.id("accept");
    protected By type1 = By.id("suite_mode_single");
    protected By type2 = By.id("suite_mode_single_baseline");
    protected By type3 = By.id("suite_mode_multi");

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
    public WebElement getType1() {return driver.findElement(type1);}
    public WebElement getType2() {return driver.findElement(type2);}
    public WebElement getType3() {return driver.findElement(type3);}

   /* public void addProject (Project project){
        getNameField().sendKeys(project.getProject_name());
        getAnnouncementField().sendKeys(project.getAnnouncement());
        чус
        getAddButton().click();
    }*/

    public void addProject (Project project){
        getNameField().sendKeys(project.getProject_name());
        getAnnouncementField().sendKeys(project.getAnnouncement());
        Random random=new Random();
        int number = random.nextInt(2);
        switch (number) {
            case  0:
                getType1().click();
                break;
            case 1:
                getType2().click();
                break;
            case 2:
                getType3().click();
                break;

            default:
                System.out.println("Проект не создан");
                break;
        }
        getAddButton().click();
    }
    public void addPr (Pr pr){
        getNameField().sendKeys(pr.getProject_name());
        getAnnouncementField().sendKeys(pr.getAnnouncement());
        getAddButton().click();
    }
}
