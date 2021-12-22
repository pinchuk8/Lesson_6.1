package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboadPage extends BasePage {

    private By PAGE_OPENED_IDENTIFIER = By.id("navigation-dashboard");
    private By Add_Selector = By.id("sidebar-projects-add");

    public DashboadPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    public WebElement getAdd() {
        return driver.findElement(Add_Selector);
    }

}
