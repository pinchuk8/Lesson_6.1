package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.TableView;
import java.util.ArrayList;

public class Table {
    private UIElement uiElement;
    private WebDriver driver;

    public Table(WebDriver driver, By by){
        this.uiElement=new UIElement(driver,by);
    }
    public Table(WebDriver driver, WebElement webElement){
        this.driver=driver;
        this.uiElement=new UIElement(driver,webElement);
    }
    public TableRow getRow(int i){
        ArrayList <UIElement> list = uiElement.findUIElements(By.tagName("tr"));
        return new TableRow (driver,list.get(i));
    }
    public void getRow(String text){
    }
    //выдаст колонку по номеру
    public void getColumn(int i){
    }
    //выдаст колонку по названию
    public void getColumn(String header){
    }
    public UIElement getCell(int columnNumber, int rowNumber){//передаём номер строки и стролбца
       TableRow row= getRow(rowNumber); //получаем объект (строку) согласно номера
       ArrayList<UIElement>list =row.findUIElements(By.tagName("td"));//ищем в строке элементы (ячейки)
       return list.get(columnNumber);//возвращаем из массвива ячеек ту, которая соответствует номеру колонки
    }
    public UIElement getUiElementFromCell(UIElement cellElement, By by){
        return  cellElement.findElement(by);
    }
}
