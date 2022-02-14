import baseEntity.BaseCucumberTest;
import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class FirstStepdefs extends BaseCucumberTest {

    LoginPage loginPage;
    @Given("открыт браузер")
    public void browserIsStarted() {
        driver=new BrowsersService().getDriver();

    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @When("страница логина открыта")
    public void LoginPageIsOpened() {
        loginPage=new LoginPage(driver,true);
    }

    @Then("Username field is displayed")
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getEmailField().isDisplayed());
    }
    @Given("User logged in")
    public void userLoggedIn() {
        User user= User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();
        loginPage.login(user);
    }

}
