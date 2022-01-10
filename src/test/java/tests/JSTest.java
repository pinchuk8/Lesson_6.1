package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSTest extends BaseTest {
    @Test
    public void jsTest () throws InterruptedException {
        driver.get("");
        WebElement webElement = driver.findElement(By.id(""));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", webElement);
        Thread.sleep(1000);
    }
}
