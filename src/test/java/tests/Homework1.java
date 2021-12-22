package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework1 {
    static String URL1 = "https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx";
    static String URL2 = "https://masterskayapola.ru/kalkulyator/laminata.html";
    static String URL3 = "https://calc.by/building-calculators/laminate.html";

    @Test
    public void test1() {
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

        String actual_floor_cable_power = driver.findElement(By.id("floor_cable_power")).getAttribute("value");
        String actual_spec_floor_cable_power = driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value");

        Assert.assertEquals(actual_floor_cable_power, expected_floor_cable_power, "floor");
        Assert.assertEquals(actual_spec_floor_cable_power, expected_spec_floor_cable_power, "spec");

        driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {
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
        String expected_s_lam = "17.82 м2.";
        String expected_l_count = "285 шт.";
        String expected_l_packs = "24 шт.";
        String expected_l_price = "9360 руб.";
        String expected_l_over = "3 шт.";
        String expected_l_trash = "15 шт.";

        //Описание драйвера
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //1.Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(URL2); //переменныя URL1 задана в начале страницы

        //2. Ввести данные
        WebElement roomwidth = driver.findElement(By.name("calc_roomwidth"));
        roomwidth.sendKeys(Keys.CONTROL + "a");
        roomwidth.sendKeys(Keys.SHIFT + "c");
        roomwidth.sendKeys(calc_roomwidth);

        WebElement roomheight = driver.findElement(By.name("calc_roomheight"));
        roomheight.sendKeys(Keys.CONTROL + "a");
        roomheight.sendKeys(Keys.SHIFT + "c");
        roomheight.sendKeys(calc_roomheight);

        WebElement lamwidth = driver.findElement(By.name("calc_lamwidth"));
        lamwidth.sendKeys(Keys.CONTROL + "a");
        lamwidth.sendKeys(Keys.SHIFT + "c");
        lamwidth.sendKeys(calc_lamwidth);

        WebElement lamheight = driver.findElement(By.name("calc_lamheight"));
        lamheight.sendKeys(Keys.CONTROL + "a");
        lamheight.sendKeys(Keys.SHIFT + "c");
        lamheight.sendKeys(calc_lamheight);

        WebElement inpack = driver.findElement(By.name("calc_inpack"));
        inpack.sendKeys(Keys.CONTROL + "a");
        inpack.sendKeys(Keys.SHIFT + "c");
        inpack.sendKeys(calc_inpack);

        WebElement price = driver.findElement(By.name("calc_price"));
        price.sendKeys(Keys.CONTROL + "a");
        price.sendKeys(Keys.SHIFT + "c");
        price.sendKeys(calc_price);

        WebElement bias = driver.findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.CONTROL + "a");
        bias.sendKeys(Keys.SHIFT + "c");
        bias.sendKeys(calc_bias);

        WebElement walldist = driver.findElement(By.name("calc_lamheight"));
        walldist.sendKeys(Keys.CONTROL + "a");
        walldist.sendKeys(Keys.SHIFT + "c");
        walldist.sendKeys(calc_walldist);

        //4. Выбрать направление
        WebElement calc_direct = driver.findElement(By.name("calc_direct"));
        Select directDropDown = new Select(calc_direct);
        directDropDown.selectByValue("tow");

        //5. Нажать рассчитать
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        String actual_s_lam = driver.findElement(By.id("s_lam")).getAttribute("innerText");
        String actual_l_count = driver.findElement(By.id("l_count")).getAttribute("innerText");
        String actual_l_packs = driver.findElement(By.id("l_packs")).getAttribute("innerText");
        String actual_l_price = driver.findElement(By.id("l_price")).getAttribute("innerText");
        String actual_l_over = driver.findElement(By.id("l_over")).getAttribute("innerText");
        String actual_l_trash = driver.findElement(By.id("l_trash")).getAttribute("innerText");

        Assert.assertEquals(actual_s_lam, expected_s_lam, "s_lam");
        Assert.assertEquals(actual_l_count, expected_l_count, "l_count");
        Assert.assertEquals(actual_l_packs, expected_l_packs, "l_packs");
        Assert.assertEquals(actual_l_price, expected_l_price, "l_price");
        Assert.assertEquals(actual_l_over, expected_l_over, "l_over");
        Assert.assertEquals(actual_l_trash, expected_l_trash, "l_trash");

        driver.quit();
    }

    @Test
    public void test3() throws InterruptedException {

        //Описание драйвера
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //1.Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL3);
        Thread.sleep(5000);

        //входные данные для теста
        String ln_room = "500";
        String wd_room = "400";
        String ln_lam = "2000";
        String wd_lam = "200";

        //переменные с ожидаемыми значениями
        String e_boards = "53";
        String e_packeges = "7";

        //ввсти данные
        WebElement ln_room_id = driver.findElement(By.id("ln_room_id"));
        ln_room_id.clear();
        ln_room_id.sendKeys(ln_room);

        WebElement wd_room_id = driver.findElement(By.id("wd_room_id"));
        wd_room_id.clear();
        wd_room_id.sendKeys(wd_room);

        WebElement ln_lam_id = driver.findElement(By.id("ln_lam_id"));
        ln_lam_id.clear();
        ln_lam_id.sendKeys(ln_lam);

        WebElement wd_lam_id = driver.findElement(By.id("wd_lam_id"));
        wd_lam_id.clear();
        wd_lam_id.sendKeys(wd_lam);

        WebElement direction = driver.findElement(By.id("direction-laminate-id1"));
        direction.click();

        WebElement calc = driver.findElement(By.className("calc-btn-div"));
        calc.click();

        //получение ожидаемых значений
        String a_board = driver.findElement(By.cssSelector("[style*='22px']")).getAttribute("innerText");
        String a_packeges = driver.findElement(By.cssSelector("span[style*='C19']")).getAttribute("innerText");

        if (!a_board.equals("53")) {
            System.out.println("некорректное значение");
        }
        if (!a_packeges.equals("7")) {
            System.out.println("некорректное значение");
        }
        driver.quit();
    }

}
