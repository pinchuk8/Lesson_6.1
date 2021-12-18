package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboadPage;
import pages.LoginPage;


public class SmokeTest extends BaseTest {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

    }

    @Test
    public void addProjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());
        DashboadPage dashboadPage = new DashboadPage(driver);
        dashboadPage.add();
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.add_project(ReadProperties.getName(), ReadProperties.getAnnouncement());

        WebElement checkAddProject = driver.findElement(By.xpath("//*[contains(text(), 'Successfully added the new project.')]"));
        String checkAddProjectStr = checkAddProject.getText();
        if (!checkAddProjectStr.equals("Successfully added the new project.")) {
            System.out.println("Проект не добавлен");
        }


    }
}
