package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SmokeTest2 {
    static String URL = "http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf";

    @Test
    public void test1() {
        String creatinineValue = "80";
        String ageValue = "38";
        String weightValue = "55";
        String heightValue = "163";



        String expectedMDRD = "MDRD: 74 (мл/мин/1,73кв.м)";
        String expectedMDRD1 = "ХБП: 2 стадия (при наличии почечного повреждения)";
        String expectedCG = "Cockroft-Gault: 70 (мл/мин)";
        String expectedBSA = "Поверхность тела:1.58 (кв.м)";

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1.Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);

        //2. Выбрать пол
        WebElement sexElement = driver.findElement(By.id("oSex"));
        Select sexDropDown = new Select(sexElement);

        //sexDropDown.selectByIndex(1);
        sexDropDown.selectByValue("1");
        //sexDropDown.selectByVisibleText("женский");

        //3. Ввести креатинин
        WebElement creatinine  = driver.findElement(By.id("oCr"));
        creatinine.sendKeys(creatinineValue);

        WebElement age = driver.findElement (By.id("oAge"));
        age.sendKeys(ageValue);

        WebElement weight = driver.findElement (By.id("oWeight"));
        weight.sendKeys(weightValue);

        WebElement height = driver.findElement (By.id("oHeight"));
        height.sendKeys(heightValue);

        //Нажать рассчитать
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();


        String actualMDRD = driver.findElement(By.id("txtMDRD")).getText();
        String actualMDRD1 = driver.findElement(By.id("txtMDRD1")).getText();
        String actualCG = driver.findElement(By.id("txtCG")).getText();
        String actualBSA = driver.findElement(By.id("txtBSA")).getText();

        Assert.assertEquals(actualMDRD,expectedMDRD, "МDRD");
        Assert.assertEquals(actualMDRD1,expectedMDRD1, "МDRD1");
        Assert.assertEquals(actualCG,expectedCG, "CG");
        Assert.assertEquals(actualBSA,expectedBSA, "BSA");

        driver.quit();
    }
}
