package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public class FileUpLoadTest extends BaseTest {
    @Test
    public void fileUpLoadTest () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        chooseFile.sendKeys("C:\\Users\\Ольга Пинчук\\Desktop\\DGKsFOrTvVM (1).jpg");
        //chooseFile.click();
        uploadFile.click();


        Waits waits = new Waits(driver);

        WebElement header = waits.waitForVisibility(By.xpath("//h3[.='File Uploaded!']"));
        WebElement fileName = waits.waitForVisibility(By.id("uploaded-files"));

        Assert.assertTrue(header.isDisplayed());
        //Assert.assertTrue(header !=null);
        Assert.assertEquals(fileName.getText(),"DGKsFOrTvVM (1).jpg" );
    }
}
