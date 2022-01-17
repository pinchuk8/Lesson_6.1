package pages;

import baseEntities.BasePage;
//import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends BasePage {
    private static String ENDPOINT = "/dashboard";

    private static final By PAGE_OPENED_IDENTIFIER = By.id("activityChart");

    protected  By addProjectButtonSelector = By.id("sidebar-projects-add");

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }
    public DashBoardPage(WebDriver driver,boolean openPageByUrl){
        super(driver,openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonSelector);
    }

}

