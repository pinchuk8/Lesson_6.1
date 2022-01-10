package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.WeakHashMap;

public class ActionTest extends BaseTest {

    @Test
    public void actionTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement source=driver.findElement(By.id("column-a"));
        WebElement target=driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions
                //.dragAndDrop(source,target)
                .moveToElement(source)
                .clickAndHold()//нажать и удержать
                .moveToElement(target)
                .release()//отпустить
                .build()
                .perform();

        Thread.sleep(5000);

    }
    @Test
    public void actionTest2() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement target = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);//инициализыуия от драйвера
        actions
                //.moveToElement(target)
                .contextClick(target)
                .build()
                .perform();//действия можно разделить (;) actions но actions  будет выполняться потоком

        Thread.sleep(5000);
    }
}
