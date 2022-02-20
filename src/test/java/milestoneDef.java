import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.Milestone;
import models.Project;
import pages.LoginPage;
import pages.MilestonePage;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import utils.Randomization;

import static com.codeborne.selenide.Selenide.open;

public class milestoneDef {
    Project project = Project.builder()
            .name("TMS" + Randomization.getRandomString(5))
            .build();
    Milestone milestone;
    Milestone update_milestone;


    @Given("page is opened")
    public void openPage() {
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        open("/");
    }

    @And("user is logged in")
    public void logIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(ReadProperties.getUsername());
        loginPage.getPasswordField().setValue(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
    }


    @And("project is added")
    public void addProject() {
        ProjectSteps projectSteps = new ProjectSteps();
        projectSteps.AddProject(project);
    }

    @And("update milestone")
    public void updateMilestone() {
        MilestoneSteps milestoneSteps = new MilestoneSteps();
        milestoneSteps.UpdateMilestone(milestone, update_milestone);
    }

    @And("delete milestone")
    public void deleteMilestone() {
        MilestoneSteps milestoneSteps = new MilestoneSteps();
        milestoneSteps.DeleteMilestone(project, update_milestone);
    }

    @Given("milestone {string} with description {string}")
    public void milestoneWithDescription(String name, String description) {
        Milestone milestone1 = Milestone.builder()
                .name(name)
                .description(description)
                .build();
        milestone = milestone1;
        MilestoneSteps milestoneSteps = new MilestoneSteps();
        milestoneSteps.addMilestone(project, milestone1);
    }

    @Given("update milestone {string} with description {string}")
    public void updateMilestoneWithDescription(String name, String description) {
        Milestone milestone2 = Milestone.builder()
                .name(name)
                .description(description)
                .build();
        update_milestone = milestone2;
        MilestoneSteps milestoneSteps = new MilestoneSteps();
        milestoneSteps.UpdateMilestone(milestone, milestone2);

    }

    @Then("milestone is added")
    public void milestoneIsAdded() {
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.getSuccessString().isDisplayed();
    }

    @Then("milestone is update")
    public void milestoneIsUpdate() {
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.getSuccessString().isDisplayed();
    }
}
