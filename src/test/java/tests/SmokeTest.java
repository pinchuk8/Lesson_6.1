package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest {

    @Test
    public void test1() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/994-raschet-indeksa-massy-tela");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //WebElement formElement = driver.findElement(By.id("form"));
        WebElement heightInput = driver.findElement(By.name("ht"));
        heightInput.sendKeys("183");

        WebElement weightInput = driver.findElement(By.name("mass"));
        weightInput.sendKeys("58");

        WebElement calcButton = driver.findElement(By.xpath("//input[@type='button']"));
        calcButton.click();

        WebElement resultValue = driver.findElement(By.name("result"));
        String resultStr = resultValue.getAttribute("value");
        if (!resultStr.equals("17.32")){
            System.out.println("некорректное значение");
        }

        WebElement resultText = driver.findElement(By.id("resline"));
        String resultStr2 = resultText.getText();
        if (!resultStr2.equals("Пониженный вес")){
            System.out.println("некорректное значение-2");
        }
        //Thread.sleep(5000);


        driver.quit();
    }
}
