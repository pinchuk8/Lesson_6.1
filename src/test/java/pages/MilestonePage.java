package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MilestonePage {
    private final By success_string_selector = By.xpath("//div[contains(text(),'Successfully')]");

    public SelenideElement getSuccessString() {
        return $(success_string_selector);
    }
}
