package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeClass
    public void openPage() {
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl= ReadProperties.getUrl();
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        open("/");
    }
    @BeforeClass(dependsOnMethods = "openPage")
    public void Login() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(ReadProperties.getUsername());
        $("#password").val(ReadProperties.getPassword());
        $("#button_primary").click();
    }

}