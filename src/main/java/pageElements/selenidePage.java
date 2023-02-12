package pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class selenidePage {

    public static SelenideElement status = $x("//span[@class='status-view']//preceding-sibling::span");
    public static SelenideElement versions = $x("//span[@id='fixVersions-field']");

}
