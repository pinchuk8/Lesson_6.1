package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    @Test
    public void frameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);//переключаемся в дочерний фрэйм
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"Your content goes here.");
        //driver.switchTo().parentFrame(); на уровень выше
        //driver.switchTo().defaultContent() на родительский уровень
    }
}
