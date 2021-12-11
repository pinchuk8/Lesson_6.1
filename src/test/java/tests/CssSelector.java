package tests;

import org.openqa.selenium.By;

public class CssSelector {
    //URL = http://pharmacademy.by/

    private void cssSelectors (){
        By classSelector1 = By.cssSelector (".menu-container-m"); //(".radio"); //поиск по классу radio
        By classSelector2 = By.className ("menu-container-m"); //("radio"); //поиск по имени класса radio

        /*NOT FOUNDED!
        By idSelector1 = By.cssSelector("#suite_mode_single"); //поиск по id
        By idSelector2 = By.id("suite_mode_single"); //поиск по id*/


        By tagSelector1 = By.cssSelector ("body"); //("label"); //поиск по tag
        By tagSelector2 = By.tagName ("body");//("label"); //поиск по tag

        By tagAttributSelector = By.cssSelector ("meta[name='Keywords']");//("label[for='name']"); //поиск по tag & atribut со значением
        By tagAttributSelector1 = By.cssSelector("meta[charset]");//("label[for]"); //поиск по tag и присутствием атрибута

        /*NOT FOUNDED!
        By multipleClassSelector1 = By.cssSelector(".column.content.overflow-content"); //поиск по двум классам в элементе*/

        By simpleHierarchicalSelector1 = By.cssSelector (".content .search-mobile"); //(".table .content-inner"); //поиск простого дочернего элемента

        By fullHierarchicalSelector1 = By.cssSelector (".content .search-mobile .search-mobile__container"); //("body .table .content-inner"); //использование трёхуровненвой иерархии для поиска дочернего элемента

        By searchLikeContainsSelector1 = By.cssSelector ("div[class*='btn']"); //("form[action*='admin']"); //поиск с вхождением подстроки (ЧАСТЬ СЛОВА) со значением атрибута в любом месте строки

        By searchByWordSelector1 = By.cssSelector ("meta[content~='initial-scale=1']"); //("form[action~='admin']"); //поиск с вхождением CЛОВА (ЦЕЛОГО, ОТДЕЛЕНО ПРОБЕЛАМИ) в значении атрибута в любом месте

        By valueStartsFromSelector1 = By.cssSelector ("link[href^='http://']"); //("a[href^='https://']"); //поиск элемента с атрибутом значение которого начинается с...

        By valueEndsWithSelector1 = By.cssSelector ("link[href$='png']");//("a[href$='@gmail.com']"); //поиск элемента с атрибутом значение которого заканчивается на...

        By childAfterParentSelector1 = By.cssSelector ("head>title"); //("ul>li"); //поиск дочернего сразу за непосредственным родителем
        By elementRightAfterElementSelector2 = By.cssSelector ("div>form button");//("ul>li a"); //поиск дочернего сразу за непосредственным родителем с поиском содержания а

        By elementRightAfterElementSelector2= By.cssSelector ("footer+script");//("#form+script"); //поиск элемента sript который идёт сразу после элемента form (найдёт только первый скрипт-примыкающий, если их  несколько), (форм и скрипт одного порядка)

        By elementOnTheSameLevelElementSelector2 = By.cssSelector ("footer~script");//("#form~script"); //поиск всех элементов script который находятся в одном порядке с  элементом form

        By firstChildSelector2 = By.cssSelector ("input:first-child");//("li:first-child"); //поиск первого дочернего элемента
        By lastChildSelector2 = By.cssSelector ("button:last-child");//("li:last-child"); //поиск последнего дочернего элемента
        By nthChildFromBeginSelector2 = By.cssSelector ("footer:nth-child(2)");//("li:nth-child(2)"); //поиск н-ного дочернего элемента с начала
        By nthChildFromEndSelector2 = By.cssSelector ("link:nth-last-child(4)");//("li:nth-last-child(3)"); //поиск н-ного дочернего эелментоа с конца























    }
}
