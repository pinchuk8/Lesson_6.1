package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class WaitsTest extends BaseTest {

    @Test
    public void explicitlyWait(){
        driver.get("http://the-internet.herokuapp.com/hovers");

        Waits waits= new Waits(driver);

        WebElement figure = driver.findElement(By.className("figure"));
        figure.click();
        //Для невидимых элементов
        /*WebElement caption = driver.findElement(By.xpath("//h5[. = 'name: user1']"));
        Assert.assertTrue(caption.isDisplayed());*/
        //Для видимых элементов
        Assert.assertTrue(waits.waitForVisibility(By.xpath("//h5[. = 'name: user1']")).isDisplayed());
    }
}
