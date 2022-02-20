package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage {
    private final By name_field_selector = By.id("name");
    private final By accept_button_selector = By.id("accept");

    public SelenideElement getNameField() {
        return $(name_field_selector);
    }

    public SelenideElement getAcceptButton() {
        return $(accept_button_selector);
    }
}
