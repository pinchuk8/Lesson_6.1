package baseEntities;


import com.tms.core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
        protected WebDriver driver;

        @BeforeMethod
        public void setUp(){
            switch (ReadProperties.getBrowserType().toLowerCase()){
                case "chrome":
                    WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--silent");
                    chromeOptions.setHeadless(ReadProperties.getHeadless());
                    //перенабрать
                    driver=new ChromeDriver(chromeOptions);
                    driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
                    driver.get(ReadProperties.getUrl());

                    break;
                case "firefox":
                    WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("данный браузер не поддерживается");
                    break;
            }
            driver.manage().window().maximize();
            driver.get(ReadProperties.getUrl());

        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }
