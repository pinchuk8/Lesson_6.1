package steps;

import models.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectSteps {
    public void AddProject(Project project) {
        $(By.id("sidebar-projects-add")).click();
        $(By.id("name")).setValue(project.getName());
        $(By.id("accept")).click();
    }
}
