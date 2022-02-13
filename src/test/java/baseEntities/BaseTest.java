package baseEntities;

import com.codeborne.selenide.Configuration;
import core.DataBaseService;
import core.ReadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected DataBaseService dataBaseService;
    @BeforeClass(dependsOnMethods = "setupConnection")
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
    @BeforeClass
    public void setupConnection() {
        org.apache.log4j.BasicConfigurator.configure();
        dataBaseService = new DataBaseService();
    }

    @AfterClass
    public void closeConnection() {
        dataBaseService.closeConnection();
    }

}