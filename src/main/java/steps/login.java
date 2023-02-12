package steps;

import com.codeborne.selenide.Selenide;

import static pageElements.mainPage.*;

public class login {

    public static void url(String url){
        Selenide.open(url);
    }

    public static void input (String log, String pass){
       inputLogin.setValue(log);
        inputPassword.setValue(pass);
        entry.click();
    }
}
