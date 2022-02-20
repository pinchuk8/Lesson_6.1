package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private final By ad_project_button_selector = By.id("sidebar-projects-add");
    public SelenideElement getAddProjectButton() {
        return $(ad_project_button_selector);
    }
}
