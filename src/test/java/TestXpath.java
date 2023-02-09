import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$x;


public class TestXpath{
    private final static String baseURL = "https://edujira.ifellow.ru/secure/Dashboard.jspa";
    private final static String login = "vtihomirova";
    private final static String password = "Qwerty123";
    String text = "TestSelenium";
    String textTema = "CreateBug";
    String textEnvironment= "Kakoe-to environment";
    String textOpisanie = "Kakoe-to opisanie";
    private final SelenideElement quantity = $x("//div[@class='showing']//span");
    private final SelenideElement status = $x("//span[@class='status-view']//preceding-sibling::span");
    private final SelenideElement versions = $x("//span[@id='fixVersions-field']");

    @Test
    public void homeWork3(){
        StartPage startPage = new StartPage(baseURL);
        startPage.input(login, password);
        TestProject testProject = new TestProject();
        testProject.projects();
        testProject.searchTest();
        String howMany = quantity.getText();
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(howMany);
        matcher.find();
        TestSelenium testSelenium = new TestSelenium();
        testSelenium.seleniumSearch(text);
        String inProgress = status.getText();
        inProgress.toLowerCase();
        String vers = versions.getText();
        CreateBug createBug = new CreateBug();
        createBug.clickButton(textTema,textOpisanie,textEnvironment);
        testSelenium.createDoneTest(textTema);
        createBug.businessProgress();
        Assert.assertEquals(vers,"Version 2.0");
        Assert.assertEquals(inProgress,"в работе");
        Assert.assertEquals(matcher.group(),"6487");
    }
}
