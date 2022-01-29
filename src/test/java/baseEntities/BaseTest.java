package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import utils.Listener;
import utils.Waits;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;

    protected ProjectSteps projectSteps;
    protected MilestoneSteps milestoneSteps;

    @BeforeClass
    public void setUp() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        waits = new Waits(driver);
        projectSteps = new ProjectSteps(driver);
        milestoneSteps = new MilestoneSteps(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }
}
