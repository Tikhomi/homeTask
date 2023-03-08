package Test;

import WebHooks.WebHooks;
import io.qameta.allure.Epic;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static apiSteps.Create.*;
import static apiSteps.RickAndMorty.*;
import static apiSteps.signInJira.*;

@Epic("API Тесты.")
public class TestAPI extends WebHooks {

    @DisplayName("Тесты Рик и морти")
    @Test
    public void task1 () {
        getCharacter("2");
        getEpisode();
        getIdPerson();
        getLocationPerson();
        Assert.assertEquals("Расы не совпадают!", speciesMorty, speciesLast);
        try {
            Assert.assertEquals(nameLocation,nameLocationMorty);
        } catch (Throwable t) {
            System.out.println("Локации не совпадают!");
        }
    }
    @DisplayName("Создание пользователя")
    @Test
    public void task2 () throws IOException{
        fillingBody();
        sendRequest();
        Assert.assertEquals("Значение ключа name не совпадают!", nameCheck1, nameCheck2);
        Assert.assertEquals("Значение ключа job не совпадают!", jobCheck1, jobCheck2);
    }
    @DisplayName("Авторизация на jira")
    @Test
    public void task3 () throws IOException{
        homePage();
    }
}
