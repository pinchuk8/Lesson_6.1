package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //Описание элементов страницы
    private  By PAGE_OPEN_IDENTIFIER = By.className("loginpage-installationname");
    private By emailSelector = By.id("name");
    private By passwordSelector = By.id("password");
    private By loginSelector = By.id("button_primary");

    public WebDriver driver;

    //Конструктор страницы
      public LoginPage (WebDriver driver){
          this. driver =driver;
    }
    public boolean isPageOpened(){
          return !super.isPageOpen(PAGE_OPEN_IDENTIFIER);
    }
    // Реализация гетерров элементов
    public WebElement getEmailField(){
        return driver.findElement(emailSelector);
    }
    public WebElement getPasswordField(){
        return driver.findElement(passwordSelector);
    }
    public WebElement getLoginField(){
        return driver.findElement(loginSelector);
    }
    //Реализация базовых элементов
    public void login (String username,String password){
          loginPage =
    }
}
