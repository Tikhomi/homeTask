package steps;

import static com.codeborne.selenide.Selenide.sleep;
import static pageElements.boardPage.*;
import static pageElements.selenidePage.*;

public class taskBoard {
    public static void projects (){
        upPanel.click();
        searchTask.click();
    }

    public static void tasksBoard(){
        panelTask.click();
    }
}
