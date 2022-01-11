package pages;

import baseEntities.BasePage;
import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Waits;

public class DisappearingElementPage extends BasePage {
    private By Page_Opened_Identifier = By.className("example");
    private By DisappearingElement_selector = By.cssSelector("[href='/gallery/']");

    public boolean isPageOpened() {
        return super.isPageOpened(Page_Opened_Identifier);
    }

    public DisappearingElementPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDisappearingElement() {
        return driver.findElement(DisappearingElement_selector);
    }

    public void disappearingElement() throws InterruptedException {
        driver.navigate().refresh();
        Waits waits = new Waits(driver);

        int refreshCount = 5;
        for (int i = 0; i < refreshCount; i++) {
            int gallery = driver.findElements(DisappearingElement_selector).size();
            if (gallery > 0) {
                Assert.assertTrue(waits.waitForVisibility(DisappearingElement_selector).isDisplayed());
                System.out.println("Element was found");
            } else {
                System.out.println("Please, refresh page");
                driver.navigate().refresh();
            }
        }
    }
}
