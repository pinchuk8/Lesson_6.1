package tests;

public class xPath {package tests;

    public class xPathSelectors {
        private static String absolutePath = "/html/body";

        //Все элементы на странице начиная с html- тэга
        private static String allElementsInHTMLPath = "//*";

        //Элемент по тэгу
        private static String bodyPath = "//body";

        //Дочерний элемент относительно родителя
        private static String childPath = "//form/p";

        //Поиск элемента с аттрибутом и его значением
        private static String tagWithAttrPath = "//form[@id='login_form']";

        //Поиск родителя у элемента с аттрибутом и его значением
        private static String parentPath1 = "//form[@id='login_form']/..";
        private static String parentPath2 = "//*[@id='login_form']/parent::div";

        //Поиск элемента по индексу
        private static String elementByIndexPath = "(//meta)[4]";

        //Поиск элемента по полному соответствию по тексту
        private static String searchByTextPath = "//*[text() = 'Имя пользователя']";
        private static String searchByTextPath1 = "//*[.='Имя пользователя']";

        //Поиск элемента по подстроке в тексте
        private static String searchBySubstringPath = "//*[contains(text(), 'Имя')]";

        //Поиск элемента по аттрибуту значение которого начинается с
        private static String searchByStartsWithPath = "//form[starts-with(@method, 'GE')]";

        //Использование логического оператора
        private static String searchByTwoAttrPath = "//*[@method='POST' and @class='entrance']";

        //Использование логического оператора
        private static String searchBySpecificAttrPath = "//link[@rel!='stylesheet']";

        //Axes - Оси
        //Использование ancestor - все предки текущего узла
        private static String path1 = "//*[@class='menu-container-m']/ancestor::div[1]";

        //Использование child - все предки текущего узла зависят от уровня
        private static String path2_1 = "//body/child::div";
        private static String path2_2 = "//body/div";           //аналог только проще

        //Использование descendant - все предки текущего узла не зависимо от уровня
        private static String path3_1 = "//footer/descendant::p[1]";
        private static String path3_2 = "//body//footer";           //аналог только проще

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        private static String path4_1 = "//div[@class='social']/following::p";
        private static String path4_2 = "(//label[@for=\"announcement\"]/following::div/*[@class='checkbox'])[1]";

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        private static String path5_1 = "//label[@for=\"announcement\"]/following-sibling::div";


        //Использование preceding - Выбирает все узлы, которые появляются перед текущим узлом в документе
        private static String path6_1 = "//label[@for=\"announcement\"]/preceding::div";

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        private static String path7_1 = "//label[@for=\"announcement\"]/preceding-sibling::div";


    }
}
