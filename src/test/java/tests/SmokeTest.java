package tests;

import baseEntities.BaseTest;
import core.BrowsersService;
import core.ReadProperties;
import models.Pr;
//import models.Project;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);

        DashBoardPage dashboardPage = new DashBoardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
    @Test
    public void addPr(){
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.getAddProjectButton().click();
        Pr pr=new Pr()
                .setProject_name(ReadProperties.getProject_name())
                .setAnnouncement(ReadProperties.getAnnouncement());
        AddProjectPage addProjectPage=new AddProjectPage(driver);
        addProjectPage.addPr(pr);
        ProjectsPage projectsPage=new ProjectsPage(driver);
        projectsPage.getProjectSearch();
        Assert.assertTrue(projectsPage.getProjectSearch().isDisplayed());
    }
    @Test
    public void addProject(){
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.getAddProjectButton().click();
        Project project=new Project()
                .setProject_name(ReadProperties.getProject_name())
                .setAnnouncement(ReadProperties.getAnnouncement());
        AddProjectPage addProjectPage=new AddProjectPage(driver);
        addProjectPage.addProject(project);
        ProjectsPage projectsPage=new ProjectsPage(driver);
        projectsPage.getProjectSearch();
        Assert.assertTrue(projectsPage.getProjectSearch().isDisplayed());
    }
    @Test
    public void UpdateProject(){
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        ProjectsPage projectsPage=new ProjectsPage(driver);
        projectsPage.getEditButton();
        EditProjectPage editProjectPage=new EditProjectPage(driver);
        editProjectPage.Edit();

    }

    @Test(retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashBoardPage dashboardPage = new DashBoardPage(driver);
        waits.waitForVisibility(dashboardPage.getAddProjectButton());

        Assert.assertTrue(dashboardPage.isPageOpened());
    }
}
