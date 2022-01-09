package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {
    private By Page_Opened_Identifier = By.className("heading");
    private By InputButton_selector = By.cssSelector("[href='/inputs']");
    private By DropDownButton_selector = By.cssSelector("[href='/dropdown']");


    public boolean isPageOpened(){return super.isPageOpened (Page_Opened_Identifier);}

    public StartPage(WebDriver driver) {
        super(driver);
    }
    public  WebElement getInputButton (){
        return driver.findElement(InputButton_selector);
    }
    public  WebElement getDropDownButton (){
        return driver.findElement(DropDownButton_selector);
    }

}
