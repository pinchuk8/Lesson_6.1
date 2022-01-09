package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.InputPage;
import pages.StartPage;


public class SmokeTest extends BaseTest {
    @Test
    public void inputTest (){
        StartPage startPage = new StartPage(driver);
        startPage.getInputButton().click();
        InputPage inputPage=new InputPage(driver);
        inputPage.input();
    }
    @Test
    public void dropDownTest () {
        StartPage startPage = new StartPage(driver);
        startPage.getDropDownButton().click();
        DropDownPage dropDownPage=new DropDownPage(driver);
        dropDownPage.dropDown();
    }
}
