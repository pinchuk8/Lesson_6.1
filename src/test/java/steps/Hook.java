package steps;

import baseEntity.BaseCucumberTest;
import core.BrowsersService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }
    @Before
    public void initializeTest (Scenario scenario){
        System.out.println("HOOK: start browser");
        baseCucumberTest.driver=new BrowsersService().getDriver();
        //инициализируем драйвер и присваиваем её для базовой переменной в cucumberTest
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("Make a screenshot");
        }
        if (baseCucumberTest.driver !=null){
            baseCucumberTest.driver.quit();
        }
    }
}
