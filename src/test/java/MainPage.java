import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

//Главная страница сайта https://appleinsider.ru
public class MainPage {
    private final SelenideElement textInput = $x("//input[@type='text']");

    public  MainPage (String url){

        Selenide.open(url);
    }

    public void search (String searchString){
        textInput.setValue(searchString);
        textInput.sendKeys(Keys.ENTER);
    }

}
