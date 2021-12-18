package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboadPage;
import pages.LoginPage;


public class SmokeTest extends BaseTest {
    @Test
    public void loginTest (){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

    }
    @Test
    public void addProjectTest(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login();
        DashboadPage dashboadPage=new DashboadPage(driver);
        dashboadPage.getAdd();
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.add_project();



    }
}
