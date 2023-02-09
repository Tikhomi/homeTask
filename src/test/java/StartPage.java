import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StartPage {
    private final SelenideElement inputLogin = $x("//input[@name='os_username']");
    private final SelenideElement inputPassword = $x("//input[@name='os_password']");
    private final SelenideElement entry = $x("//input[@id='login']");

    public  StartPage (String url){
        Selenide.open(url);
    }
    public void input (String log, String pass){
        inputLogin.setValue(log);
        inputPassword.setValue(pass);
        entry.click();
    }
}
