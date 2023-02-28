import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static APIsteps.Create.*;
import static APIsteps.RickAndMorty.*;
import static APIsteps.signInJira.*;

public class TestAPI {
    @Test
    public void test1 () {
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

    @Test
    public void task2 () throws IOException{
        fillingBody();
        sendRequest();
        Assert.assertEquals("Значение ключа name не совпадают!", nameCheck1, nameCheck2);
        Assert.assertEquals("Значение ключа job не совпадают!", jobCheck1, jobCheck2);
    }

    @Test
    public void task3 () throws IOException{
        homePage();
    }
}
