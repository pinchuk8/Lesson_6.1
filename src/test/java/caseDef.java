import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Case;
import models.Project;
import pages.CasePage;
import pages.LoginPage;
import steps.CaseSteps;
import steps.ProjectSteps;
import utils.Randomization;

import static com.codeborne.selenide.Selenide.open;

public class caseDef {
    Project project = Project.builder()
            .name("TMS" + Randomization.getRandomString(5))
            .build();

    Case base_case;
    Case update_case;

    @Given("Page is opened")
    public void pageIsOpened() {
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        open("/");
    }

    @And("User is logged in")
    public void userIsLoggedIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(ReadProperties.getUsername());
        loginPage.getPasswordField().setValue(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
    }

    @And("Project is added")
    public void projectIsAdded() {
        ProjectSteps projectSteps = new ProjectSteps();
        projectSteps.AddProject(project);
    }

    @When("case {string} with precondition {string} is created")
    public void caseWithPreconditionIsCreated(String case_name, String precondition) {
        Case case1 = Case.builder()
                .name(case_name)
                .precondition(precondition)
                .build();
        base_case=case1;
        CaseSteps caseSteps=new CaseSteps();
        caseSteps.AddCase(project,base_case);
    }

    @Then("message is {string}")
    public void messageIs(String visibleText) {
        CasePage casePage=new CasePage();
        casePage.getSuccessString().getText().contains(visibleText);
    }

    @When("update case {string} with precondition {string} is created")
    public void updateCaseWithPreconditionIsCreated(String update_case_name, String update_precondition) {
        Case case2= Case.builder()
                .name(update_case_name)
                .precondition(update_precondition)
                .build();
        update_case=case2;
        CaseSteps caseSteps=new CaseSteps();
        caseSteps.UpdateCase(project,base_case,update_case);
    }

    @Then("message about updating is {string}")
    public void messageAboutUpdatingIs(String update_visible_text) {
        CasePage casePage=new CasePage();
        casePage.getSuccessString().getText().contains(update_visible_text);
    }

    @Then("delete case")
    public void deleteCase() {
        CaseSteps caseSteps=new CaseSteps();
        caseSteps.DeleteCase(project,update_case);
    }

}
