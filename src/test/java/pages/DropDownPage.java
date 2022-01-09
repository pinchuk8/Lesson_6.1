package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {
    private By Page_Opened_Identifier = By.className("example");
    private By DropDown_Selector = By.id("dropdown");

    public boolean isPageOpened(){return super.isPageOpened (Page_Opened_Identifier);}

    public DropDownPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getDropDown(){return driver.findElement(DropDown_Selector);}

    public void dropDown (){
        WebElement drop_field = driver.findElement(By.id("dropdown"));
        drop_field.click();
        Select variant_dropdown = new Select(drop_field);
        variant_dropdown.selectByValue("1");
    }
}
