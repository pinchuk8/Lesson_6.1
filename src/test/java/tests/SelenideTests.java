package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;//импорт сразу всех команд

@Listeners({SoftAsserts.class})
public class SelenideTests {
    String url = "https://qa1505.testrail.io";
    String username = "atrostyanko+0401@gmail.com";
    String password = "QqtRK9elseEfAk6ilYcJ";

    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)//выполнит скрин при падении проверки
                .savePageSource(true)
        );
    }

    @Test
    public void userCanLogin() {
        //Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();
        //Настройка selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;//заполнение полей со стандартной скоростью
        Configuration.timeout = 8000;
        //Configuration.downloadsFolder = "";
        //Configuration.assertionMode = SOFT; выполнит все проверки вне зависимости упала ли хоть одна перед этим, обязательно добавить лисенер
        Configuration.headless = false;
        //Test
        open("/");//переход по базовому url

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");
        $$(By.className("hoverSensitive"))
                //.shouldHaveSize(388) проверка размерности
                .find(text("123456"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible);
        //.shouldHave(exactText("This is the description for the project1"));
    }

    @Test
    public void test1() {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$(".chart-legend-name")
                .filter(visible)
                .shouldHave(
                        texts(
                                "123456",
                                "aaaDencheck",
                                "aaaDencheck",
                                "aaaDencheck"
                        )
                );
    }

    @Test
    public void test2() throws FileNotFoundException {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.downloadsFolder = "";
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        $(By.id("name")).setValue(username);
        $("#password").val(password);
        $("#button_primary").click();

        $(byText("ahlhtdqk")).shouldBe(visible);
        $(withText("123")).shouldBe(visible);//по содержанию в тексте

        SelenideElement parent = $(byText("ahlhtdqk")).parent();
        System.out.println(parent.getTagName());

        $(byText("ahlhtdqk")).innerText();
        $(byText("ahlhtdqk")).innerHtml();
        $(byText("ahlhtdqk")).scrollTo();
        $(byText("ahlhtdqk")).closest("tr");//ближайший элемент с атрибутом
        $(byText("ahlhtdqk")).find(By.xpath(""));//не отначала страницы а внутри элемента
        $(byText("ahlhtdqk")).doubleClick();
        $(byText("ahlhtdqk")).contextClick();
        $(byText("ahlhtdqk")).hover();

        $(byText("ahlhtdqk")).uploadFile(new File(""));//загрузка файла по относительному пути
        $(byText("ahlhtdqk")).download();

        sleep(3000);
    }

    @Test
    public void userCanLogin1() {
        // Настройка slf4j
        org.apache.log4j.BasicConfigurator.configure();

        // Настройка Selenide
        Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        //Configuration.downloadsFolder = "";
        //Configuration.assertionMode = SOFT;
        //Configuration.headless = false;

        // Начинаем писать тест
        open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(username);

        $("#password").val(password);
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));


    }
}

