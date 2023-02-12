package pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class boardPage {
   public static SelenideElement searchTask = $x("//a[@id='issues_new_search_link_lnk']");//поиск задач
   public static SelenideElement panelTask = $x("//a[@class='filter-link' and text()='Все задачи']");//нопка на панели "Все задачи"
   public static SelenideElement upPanel = $x("//a[@id='find_link']");//задачи на верхней панели
   public static SelenideElement quantity = $x("//div[@class='showing']");//количество на поиске задачи

   public static SelenideElement project = $x("//a[@id ='browse_link']");//кнопка проекты
   public static SelenideElement allTasks = $x("//div[@class='showing']");
}
