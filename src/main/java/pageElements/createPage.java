package pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class createPage {
    public static String text = "TestSelenium";
    public static String textTema = "CreateBug";
    public static String textEnvironment= "Kakoe-to environment";
    public static String textOpisanie = "Kakoe-to opisanie";

    public static SelenideElement create = $x("//a[@id ='create_link']");// кнопка "Создать" задачу
    public static SelenideElement topic = $x("//input[@id='summary']");//тема создания задачи
    public static SelenideElement description = $x("//body[@id='tinymce' and @data-id='mce_0']/child::p");
    public static SelenideElement environment = $x("//body[@id='tinymce' and @data-id='mce_6']/child::p");
    public static SelenideElement createPJ = $x("//input[@id='create-issue-submit']");//кнопка создания бага
    public static SelenideElement business = $x("//span[contains(text(), 'Бизнес-процесс')and @class='dropdown-text']/..");//выпадающий список бизнес-процессы
    public static SelenideElement complete = $x("//span[contains(text(), 'Выполнено')and @class='trigger-label']/..");//кнопка из выпадающего списка
    public static SelenideElement inputText = $x("//input[@id='quickSearchInput']");//поисковая строка
}
