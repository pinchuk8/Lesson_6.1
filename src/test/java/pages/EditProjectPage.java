package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProjectPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER =By.xpath("//*[contains(text(), 'Dashboard')]") ;
    private static String ENDPOINT= "/admin/projects/edit/75";
    protected By announcementField = By.id("announcement");
    protected By editButton=By.id("accept");
    public EditProjectPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }
    public WebElement getAnnouncementField() {
        return driver.findElement(announcementField);
    }
    public WebElement getEditButton() {
        return driver.findElement(editButton);
    }

    public void Edit(){
        getAnnouncementField().sendKeys(getAnnouncementField().getText()+"8");
        getEditButton().click();
    }
}
