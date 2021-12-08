package tests;

import org.openqa.selenium.By;

public class CssSelector {

    private void cssSelectors (){
        By classSelector1 = By.cssSelector(".radio"); //поиск по классу radio
        By classSelector2 = By.className("radio"); //поиск по классу radio

        By idSelector1 = By.cssSelector("#suite_mode_single"); //поиск по id
        By idSelector2 = By.id("suite_mode_single"); //поиск по id


        By tagSelector1 = By.cssSelector("label"); //поиск по tag
        By tagSelector2 = By.tagName("label"); //поиск по tag

        By tagAttributSelector = By.cssSelector("label[for='name']"); //поиск по tag & attribut со значением
        By tagAttributSelector1 = By.cssSelector("label[for]"); //поиск по tag и присутствием атрибута


        By multipleClassSelector1 = By.cssSelector(".column.content.overflow-content"); //поиск по двум классам в элементе

        By simpleHierarchicalSelector1 = By.cssSelector(".table .content-inner"); //поиск простого дочернего элемента

        By fullHierarchicalSelector1 = By.cssSelector("body .table .content-inner"); //использование трёхуровненвой иерархии для поиска дочернего элемента

        By searchLikeContainSelector1 = By.cssSelector("form[action*='admin']"); //поиск с вхождением подстроки со значением атрибута

        By searchByWordSelector1 = By.cssSelector("form[action~='admin']"); //поиск с вхождением слова в значении атрибута

        By valueStartsFromSelector1 = By.cssSelector("a[href^='https://']"); //поиск элемента с аттрибутом значение которого начинается с...

        By valueEndsWithSelector1 = By.cssSelector("a[href$='@gmail.com']"); //поиск элемента с аттрибутом значение который заканчивается на...










    }
}
