import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection article = $$x("//h2/a");

    public String hrefSearch (){
       return article.first().getAttribute("href");
    }
}

