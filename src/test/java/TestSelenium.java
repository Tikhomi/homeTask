import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class TestSelenium {
    private final SelenideElement inputText = $x("//input[@id='quickSearchInput']");

    public void seleniumSearch(String input){
        inputText.click();
        inputText.setValue(input);
        inputText.sendKeys(Keys.ENTER);
    }
    public void createDoneTest(String inputCreateTest){
        inputText.click();
        inputText.setValue(inputCreateTest);

        inputText.sendKeys(Keys.ENTER);
    }
}
