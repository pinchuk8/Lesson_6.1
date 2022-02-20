package steps;

import models.Project;
import org.openqa.selenium.By;
import pages.AddProjectPage;
import pages.DashboardPage;

import static com.codeborne.selenide.Selenide.$;

public class ProjectSteps {
    public void AddProject(Project project) {
        DashboardPage dashboardpage=new DashboardPage();
        dashboardpage.getAddProjectButton().click();
        AddProjectPage addProjectPage=new AddProjectPage();
        addProjectPage.getNameField().setValue(project.getName());
        addProjectPage.getAcceptButton().click();
    }
}
