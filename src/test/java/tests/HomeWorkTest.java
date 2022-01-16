package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class HomeWorkTest extends BaseTest {
    @Test
    public void loginTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement nameField_Selector=driver.findElement(By.xpath("//input[@id='username']"));
        WebElement passwordField_Selector=driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton_Selector=driver.findElement(By.className("radius"));
        Actions actions = new Actions(driver);
        actions
                .contextClick(nameField_Selector)
                .sendKeys("tomsmith")
                .contextClick(passwordField_Selector)
                .sendKeys("SuperSecretPassword!")
                .click(loginButton_Selector)
                .build()
                .perform();
        WebElement checkElement_Selector=driver.findElement(By.className("subheader"));
        String checkString= checkElement_Selector.getText();
        Assert.assertTrue(checkString.equals("Welcome to the Secure Area. When you are done click logout below."));
    }
    @Test
    public void dynamicLoadingTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        Waits waits= new Waits(driver);
        WebElement figure = driver.findElement(By.xpath("//button"));
        figure.click();
        Assert.assertTrue(waits.waitForVisibility(By.xpath("//img[@src='/img/ajax-loader.gif']")).isDisplayed());
        Assert.assertTrue(waits.waitForVisibility(By.id("finish")).isDisplayed());
        WebElement checkElement_Selector=driver.findElement(By.id("finish"));
        String checkString= checkElement_Selector.getText();
        Assert.assertTrue(checkString.equals("Hello World!"));
    }
    @Test
    public void jsTestHW() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/floating_menu#home");
        WebElement webElement = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
        Assert.assertTrue(webElement.isDisplayed());
    }
}
