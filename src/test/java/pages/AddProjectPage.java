package pages;
import baseEntities.BasePage;
import emum.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/add/1";
    private static final By PAGE_OPENED_IDENTIFIER = By.id("accept");
    protected By NameField_Selector = By.id("name");
    protected By AnnouncementField_Selector = By.id("announcement");
    protected By AddButton_Selector = By.id("accept");
    private static String typeRadioButtonSelector ="//*[@name = 'suite_mode' and @value='replace']";


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }
    public void setType(ProjectType type) {
        driver.findElement(By.xpath(typeRadioButtonSelector.replace("replace", String.valueOf(type))));
    }
   /* public void addProject (Project project){
        getNameField().sendKeys(project.getProject_name());
        getAnnouncementField().sendKeys(project.getAnnouncement());
        чус
        getAddButton().click();
    }*/

}
