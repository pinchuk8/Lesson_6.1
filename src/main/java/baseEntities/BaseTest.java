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

    public class BaseTest {
        protected WebDriver driver;

        @BeforeMethod
        public void setUp(){
            switch (ReadProperties.getBrowserType().toLowerCase()){

                case "chrome":
                    WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.addArguments("--disable-gpu");//отключение графического процесса (дизайн)
                    chromeOptions.addArguments("--silent");//работает без информирования
                    chromeOptions.setHeadless(ReadProperties.getHeadless());
                    driver=new ChromeDriver(chromeOptions);
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
