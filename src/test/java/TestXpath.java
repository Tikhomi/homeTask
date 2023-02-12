import org.junit.Assert;
import org.junit.Test;
import steps.createBug;
import steps.taskBoard;
import steps.projectStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pageElements.mainPage.*;
import static pageElements.selenidePage.*;
import static pageElements.createPage.*;
import static pageElements.boardPage.*;

public class TestXpath{

    @Test
    public void kolichestvo() {//добавить в assert с чем сравнить! получение кол-ва задач
        steps.login.url(baseURL);
        steps.login.input(login, password);
        taskBoard.projects();
        String howMany = quantity.getText();
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(howMany);
        matcher.find();
        taskBoard.tasksBoard();
        String HWTask = allTasks.getText();
        Pattern patterns = Pattern.compile("\\d+$");
        Matcher matchers = patterns.matcher(HWTask);
        matchers.find();
        String a1 = matchers.group();
        String a2 = matcher.group();
        Assert.assertEquals(a1,a2);
    }

    @Test
    public void statusAndVersion (){//получение статуса и версии
        steps.login.url(baseURL);
        steps.login.input(login, password);
        projectStatus.seleniumSearch(text);
        String inProgress = status.getText().toLowerCase();
        String vers = versions.getText();
        Assert.assertEquals(vers,"Version 2.0");
        Assert.assertEquals(inProgress,"в работе");
    }

    @Test
    public void creareBugAndStatus(){
        steps.login.url(baseURL);
        steps.login.input(login, password);
        createBug.clickButton(textTema,textOpisanie,textEnvironment);
        projectStatus.createDoneTest(textTema);
        createBug.businessProgress();
    }
}
