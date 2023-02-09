import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestProject {
    private final SelenideElement project = $x("//a[@id ='browse_link']");

    public void projects (){
        project.click();
    }
    private final SelenideElement projectTest = $x("//a[@id ='admin_main_proj_link_lnk']"); //id project TEST

    public void searchTest(){
        projectTest.click();
    }
}
