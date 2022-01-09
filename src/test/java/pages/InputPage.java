package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputPage extends BasePage {
    private By Page_Opened_Identifier = By.className("row");
    private By inputField_Selector = By.cssSelector("[type='number']");

    public boolean isPageOpened(){return super.isPageOpened (Page_Opened_Identifier);}

    public InputPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getInput(){return driver.findElement(inputField_Selector);}

    public void input (){
        getInput().sendKeys(ReadProperties.getInput());
    }


}
