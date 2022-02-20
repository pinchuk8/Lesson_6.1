package baseEntities;

import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeClass
    public void openPage() {
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl = ReadProperties.getUrl();
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
        loginPage.getPasswordField().setValue(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
    }
}