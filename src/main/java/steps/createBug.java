package steps;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static pageElements.createPage.*;

public class createBug {

    public static void clickButton(String topicText, String descriptionText, String environmentText) {
        create.click();
        topic.click();
        topic.setValue(topicText);
        switchTo().frame($("[id='mce_0_ifr']"));
        description.click();
        description.setValue(descriptionText);
        switchTo().defaultContent();
        switchTo().frame($("[id='mce_6_ifr']"));
        environment.click();
        environment.setValue(environmentText);
        switchTo().defaultContent();
        createPJ.click();
    }

    public static void businessProgress(){
        business.click();
        complete.shouldBe(Condition.visible, Duration.ofSeconds(4)).click();
        sleep(2000);
    }
}
