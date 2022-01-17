package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[contains(text(), 'Add Project')]");
    private static String ENDPOINT = "admin/projects/overview";
    protected By projectSelector = By.xpath("//*[contains(text(), 'training1')]");
    protected By editButtonSelector = By.xpath("//a [@href='index.php?/admin/projects/edit/75']/div");

    public ProjectsPage(WebDriver driver) {
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

    public WebElement getProjectSearch() {
        return driver.findElement(projectSelector);
    }

    public WebElement getEditButton() {
        return driver.findElement(editButtonSelector);
    }

    public void  EditButtonClick() {
        getEditButton().click();
    }
}
