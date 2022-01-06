package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {

    }

    public boolean isPageOpen(By by){
        try{
        return driver.findElement(by).isDisplayed();
    }catch (NoSuchElementException nsex){
        return false;}
    }
}
