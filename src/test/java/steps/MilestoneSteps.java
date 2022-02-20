package steps;

import core.ReadProperties;
import models.Milestone;
import models.Project;
import org.openqa.selenium.By;
import pages.DashboardPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MilestoneSteps {
    public void addMilestone(Project project, Milestone milestone) {
        open(ReadProperties.getUrlDashboardPage());
        $(By.xpath("//a[contains(text(),'replace')]".replace("replace", project.getName()))).click();
        $(By.id("navigation-milestones")).click();
        $(By.className("sidebar-button")).click();
        $(By.id("name")).setValue(milestone.getName());
        $(By.id("description_display")).setValue(milestone.getDescription());
        $(By.id("accept")).click();
    }

    public void UpdateMilestone(Milestone milestone, Milestone update_milestone) {
        $(By.xpath("//*[text()='replace']".replace("replace", milestone.getName()))).click();
        $(By.xpath("//*[text()='Edit']")).click();
        $(By.id("name")).setValue(update_milestone.getName());
        $(By.id("description_display")).setValue(update_milestone.getDescription());
        $(By.id("accept")).click();
    }

    public void DeleteMilestone(Project project, Milestone update_milestone) {
        open(ReadProperties.getUrlDashboardPage());
        $(By.xpath("//a[contains(text(),'replace')]".replace("replace", project.getName()))).click();
        $(By.id("navigation-milestones")).click();
        $(By.xpath("//*[contains(text(), 'replace')]".replace("replace", update_milestone.getName()))).click();

    }
}

