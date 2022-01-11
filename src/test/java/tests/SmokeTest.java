package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DisappearingElementPage;
import pages.DropDownPage;
import pages.InputPage;
import pages.StartPage;
import utils.Waits;


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
    @Test
    public void disappearingElementTest () throws InterruptedException {
        StartPage startPage= new StartPage(driver);
        startPage.getDisappearingElementButton().click();
        DisappearingElementPage disappearingElementPage = new DisappearingElementPage(driver);
        disappearingElementPage.disappearingElement();

    }
}
