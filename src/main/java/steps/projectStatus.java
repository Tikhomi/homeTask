package steps;

import org.openqa.selenium.Keys;

import static pageElements.createPage.*;

public class projectStatus {
    public static void seleniumSearch(String input){
        inputText.click();
        inputText.setValue(input);
        inputText.sendKeys(Keys.ENTER);
    }
    public static void createDoneTest(String inputCreateTest){
        inputText.click();
        inputText.setValue(inputCreateTest);
        inputText.sendKeys(Keys.ENTER);
    }
}
