package pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class mainPage {
    public static String baseURL = "https://edujira.ifellow.ru/secure/Dashboard.jspa";
    public static String login = "vtihomirova";
    public static String password = "Qwerty123";
    public static SelenideElement inputLogin = $x("//input[@name='os_username']");//поле логина
    public static SelenideElement inputPassword = $x("//input[@name='os_password']");//поле пароля
    public static SelenideElement entry = $x("//input[@id='login']");//кнопка входа
}
