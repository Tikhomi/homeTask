import org.junit.Assert;
import org.junit.Test;

public class AppleTest extends TestRun{
    private final static String baseURL = "https://appleinsider.ru/";
    private final static String searchText = "С каким блоком питания iPhone 14 Pro Max заряжается быстрее всего";

    @Test
    public void checkHref(){
        MainPage mainPage = new MainPage(baseURL);
        mainPage.search(searchText);
        SearchPage searchPage = new SearchPage();
        String href = searchPage.hrefSearch();
        href.toLowerCase();
        boolean contains = href.contains("iphone");
        boolean cont = href.contains("mobile-phone");
        Assert.assertEquals("Этого слова нет в ссылке", true, contains);
        Assert.assertEquals("Этого слова нет в ссылке", true, cont);
    }

}
