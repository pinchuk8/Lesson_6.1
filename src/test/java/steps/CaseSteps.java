package steps;

import core.ReadProperties;
import models.Case;
import models.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CaseSteps {
    public void AddCase(Project project, Case base_case) {
        open(ReadProperties.getUrlDashboardPage());
        $(By.xpath("//a[contains(text(),'replace')]".replace("replace", project.getName()))).click();
        $(By.id("navigation-suites")).click();
        $(By.id("sidebar-cases-add")).click();
        $(By.id("title")).setValue(base_case.getName());
        $(By.id("accept")).click();
    }

    public void UpdateCase(Project project, Case base_case, Case update_case) {
        open(ReadProperties.getUrlDashboardPage());
        $(By.xpath("//a[contains(text(),'replace')]".replace("replace", project.getName()))).click();
        $(By.id("navigation-suites")).click();
        $(By.xpath("//a[@class='editLink']")).hover().click();
        $(By.id("title")).setValue(update_case.getName());
        $(By.id("accept")).click();
    }

    public void DeleteCase(Project project, Case update_case) {
        open(ReadProperties.getUrlDashboardPage());
        $(By.xpath("//a[contains(text(),'replace')]".replace("replace", project.getName()))).click();
        $(By.id("navigation-suites")).click();
        $(By.xpath("//a[@class='deleteLink']")).hover().click();
        $(By.xpath("(//*[contains(text(), 'Mark as Deleted')])[5]")).click();
    }
}
