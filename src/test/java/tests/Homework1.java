package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework1 {
    static String URL1 = "https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx";
    static String URL2 = "https://masterskayapola.ru/kalkulyator/laminata.html";

    @Test
    public void test1 () {
        //входные данные для теста
        String widthValue = "3";
        String lenghtValue = "5";

        //ожидаемые значения
        String expected_floor_cable_power = "1800";
        String expected_spec_floor_cable_power = "120";

        //Описание драйвера
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1.Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL1); //переменныя URL1 задана в начале страницы

        //2. Ввести ширину
        WebElement width = driver.findElement(By.id("el_f_width"));
        width.sendKeys(widthValue);

        //3.Ввести длину
        WebElement lenght = driver.findElement(By.id("el_f_lenght"));
        lenght.sendKeys(lenghtValue);

        //4. Выбрать помещение
        WebElement room_type = driver.findElement(By.id("room_type"));
        Select roomDropDown = new Select(room_type);
        roomDropDown.selectByValue("2");

        //5. Выбрать тип обогрева
        WebElement heating_type = driver.findElement(By.id("heating_type"));
        Select heatingDropDown = new Select(heating_type);
        heatingDropDown.selectByValue("2");

        //6. Нажать рассчитать
       WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
       calculate.click();


        String actual_floor_cable_power= driver.findElement(By.id("floor_cable_power")).getAttribute("value");
        String actual_spec_floor_cable_power = driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value");

        Assert.assertEquals(actual_floor_cable_power,expected_floor_cable_power,"floor");
        Assert.assertEquals(actual_spec_floor_cable_power,expected_spec_floor_cable_power,"spec");

        driver.quit();

    }
    @Test
    public void test2 () {
        //входные данные для теста
        String calc_roomwidth = "6";
        String calc_roomheight = "3";
        String calc_lamwidth = "1300";
        String calc_lamheight = "192";
        String calc_inpack = "12";
        String calc_price = "500";
        String calc_bias = "300";
        String calc_walldist = "10";

        //ожидаемые значения
        String expected_s_lam = "17.82";
        String expected_l_count = "76";
        String expected_l_packs = "7";
        String expected_l_price = "10483";
        String expected_l_over = "8";
        String expected_l_trash = "4";


        //Описание драйвера
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1.Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(URL2); //переменныя URL1 задана в начале страницы

        //2. Ввести данные
        WebElement roomwidth = driver.findElement(By.name("calc_roomwidth"));
        //выделить и очистить
        roomwidth.clear();
        roomwidth.sendKeys(calc_roomwidth);

        WebElement roomheight = driver.findElement(By.name("calc_roomheight"));
        roomheight.clear();
        roomheight.sendKeys(calc_roomheight);

        WebElement lamwidth = driver.findElement(By.name("calc_lamwidth"));
        lamwidth.clear();
        lamwidth.sendKeys(calc_lamwidth);

        WebElement lamheight = driver.findElement(By.name("calc_lamheight"));
        lamheight.clear();
        lamheight.sendKeys(calc_lamheight);

        WebElement inpack = driver.findElement(By.name("calc_inpack"));
        inpack.clear();
        inpack.sendKeys(calc_inpack);

        WebElement price = driver.findElement(By.name("calc_price"));
        price.clear();
        price.sendKeys(calc_price);

        WebElement bias = driver.findElement(By.name("calc_bias"));
        bias.clear();
        lamheight.sendKeys(calc_bias);

        WebElement walldist = driver.findElement(By.name("calc_lamheight"));
        walldist.clear();
        walldist.sendKeys(calc_walldist);

        //4. Выбрать направление
        WebElement calc_direct = driver.findElement(By.name("calc_direct"));
        Select directDropDown = new Select(calc_direct);
        directDropDown.selectByValue("tow");


        //5. Нажать рассчитать
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();


        /*String actual_floor_cable_power= driver.findElement(By.id("floor_cable_power")).getAttribute("value");
        String actual_spec_floor_cable_power = driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value");

        Assert.assertEquals(actual_floor_cable_power,expected_floor_cable_power,"floor");
        Assert.assertEquals(actual_spec_floor_cable_power,expected_spec_floor_cable_power,"spec");*/

        driver.quit();
    }

}
