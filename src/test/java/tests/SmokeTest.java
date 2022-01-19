package tests;

import baseEntities.BaseTest;
import core.ReadProperties;

import emum.ProjectType;
import models.Project;
import models.User;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.Randomization;
import utils.Retry;

public class SmokeTest extends BaseTest {
    Project addProject;
    Project updateProject;

    private void setupProjects() {
        addProject = new Project();
        addProject.setName(Randomization.getRandomString(8));
        addProject.setTypeOfProject(Randomization.getRandomType());

        updateProject = new Project();
        updateProject.setName(Randomization.getRandomString(8));
        updateProject.setTypeOfProject(Randomization.getRandomType());
    }

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
    public void loginTestWithBuilder() {
        UserBuilder user = new UserBuilder.Builder()
                .withEmail(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.login(user); т.к логинпэйдж реализует юзера а не юзербилдер в методе логин

        DashBoardPage dashboardPage = new DashBoardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    /*@Test
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
    }*/
    @Test
    public void UpdateProject() {
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.getEditButton();
        EditProjectPage editProjectPage = new EditProjectPage(driver);
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
