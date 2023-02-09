import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import java.util.concurrent.TimeUnit;
public class CreateBug {
    private final SelenideElement create = $x("//a[@id ='create_link']");
    private final SelenideElement topic = $x("//input[@id='summary']");
    private final SelenideElement description = $x("//body[@id='tinymce' and @data-id='mce_0']/child::p");
    private final SelenideElement environment = $x("//body[@id='tinymce' and @data-id='mce_6']/child::p");
    private final SelenideElement createPJ = $x("//input[@id='create-issue-submit']");
    private final SelenideElement business = $x("//a[@id='opsbar-transitions_more']/child::span");
    private final SelenideElement complete = $x("//span[@class = 'trigger-label' and text()='Выполнено']");
    private final SelenideElement inputText2 = $x("//input[@id='quickSearchInput']");

    public void clickButton(String topicText, String descriptionText, String environmentText) {
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
    public void businessProgress(){
        business.click();
        complete.click();
        inputText2.click();

    }
}
