package APIsteps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class API {
    public static String charId;
    public static int lastEpisode;
    public static int episode;
    public static int lastCharacter;
    public static int idLastCharacter;
    public static String speciesLast;
    public static String speciesMorty;
    public static String nameLocationMorty;
    public static String nameLocation;
    public static String Body1;
    public static String nameCheck1;
    public static String jobCheck1;
    public static String nameCheck2;
    public static String jobCheck2;
    public static JSONObject body;
    public static JSONObject json;
    public static String jsonStr;
    public static JSONObject session;
    public static String nameSession;
    public static String valueSession;

    @Дано("Нахождение информации персонажа с id: {int}")
    public static void нахождение_персонажа_по_айди(Integer id){
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + id)
                .then()
                .extract()
                .response();
        charId = new JSONObject(gettingChar.getBody().asString()).get("id").toString();
        speciesMorty = new JSONObject(gettingChar.getBody().asString()).get("species").toString();
        JSONObject locationMorty = new JSONObject(gettingChar.getBody().asString()).getJSONObject("location");
        nameLocationMorty = locationMorty.get("name").toString();

        System.out.println("location Morty: " + nameLocationMorty);
        System.out.println("id Морти Смит: " + charId);
        System.out.println("Раса Морти Смит: " + speciesMorty);
    }

    @Затем("Нахождение последнего эпизода Морти Смит")
    public static void последний_эпизод_с_морти(){
        Response gettingLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + charId)
                .then()
                .extract()
                .response();
        episode = (new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode").length()-1);
        lastEpisode = Integer.parseInt(new JSONObject(gettingLastEpisode.getBody().asString()).getJSONArray("episode")
                .get(episode).toString().replaceAll("[^0-9]",""));

        System.out.println("Последний эпизод в котором учавствовал Морти Смит: " + lastEpisode);
    }

    @Затем("Нахождение id последнего персонажа эпизода")
    public static void нахождение_id_последнего_персонажа_эпизода(){
        Response gettingIdLastPerson = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/episode/" + lastEpisode )
                .then()
                .extract()
                .response();
        lastCharacter = (new JSONObject(gettingIdLastPerson.getBody().asString()).getJSONArray("characters").length()-1);
        idLastCharacter = Integer.parseInt(new JSONObject(gettingIdLastPerson.getBody().asString()).getJSONArray("characters")
                .get(lastCharacter).toString().replaceAll("[^0-9]",""));

        System.out.println("id последнего персонажа, последнего эпизода: " + idLastCharacter);
    }

    @Затем("Нахождение информации по последнему персонажу")
    public static void нахождение_информации_по_последнему_персонажу(){
        Response gettingLocationPerson = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + idLastCharacter )
                .then()
                .extract()
                .response();
        JSONObject location = (new JSONObject(gettingLocationPerson.getBody().asString()).getJSONObject("location"));
        nameLocation = location.get("name").toString();
        speciesLast = new JSONObject(gettingLocationPerson.getBody().asString()).get("species").toString();

        System.out.println("Место нахождение последнего персонажа: " + nameLocation);
        System.out.println("Раса персонажа: " + speciesLast);
        Assert.assertEquals("Расы не совпадают!", speciesMorty, speciesLast);
        try {
            Assert.assertEquals(nameLocation,nameLocationMorty);
        } catch (Throwable t) {
            System.out.println("Локации не совпадают!");
        }
    }

    /* --------------------create-------------------------------------*/
    @Тогда("Добавление полей в json")
    public static void добавление_полей_в_json() throws IOException {
        body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/create.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat market");
        Body1 = body.toString();
    }
    @Затем("Проверка данных и статуса")
    public static void проверка_данных_и_статуса() {
        Response sendingRequest = given()
                .header("Content-type", "application/json")
                .baseUri("https://reqres.in/api")
                .body(Body1)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
        nameCheck1 = (new JSONObject(sendingRequest.getBody().asString()).get("name").toString());
        jobCheck1 = (new JSONObject(sendingRequest.getBody().asString()).get("job").toString());
        String idCreate =(new JSONObject(sendingRequest.getBody().asString()).get("id").toString());
        String createdAt = (new JSONObject(sendingRequest.getBody().asString()).get("createdAt").toString());

        nameCheck2 = (body.get("name").toString());
        jobCheck2 = (body.get("job").toString());

        System.out.println("id: " + idCreate);
        System.out.println("createAt: " + createdAt);

        Assert.assertEquals("Значение ключа name не совпадают!", nameCheck1, nameCheck2);
        Assert.assertEquals("Значение ключа job не совпадают!", jobCheck1, jobCheck2);

    }
    /*----------------------sign-in-jira------------------*/
    @Затем("Авторизация на jira")
    public static void авторизация_на_jira() throws IOException {
        json = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/signIn.json"))));
        jsonStr = json.toString();

        Response logIn = given()
                .header("Content-type", "application/json")
                .body(jsonStr)
                .when()
                .post("https://edujira.ifellow.ru/rest/auth/1/session")
                .then()
                .statusCode(200)
                .extract()
                .response();
        session = (new JSONObject(logIn.getBody().asString()).getJSONObject("session"));
        nameSession = session.get("name").toString();
        valueSession = session.get("value").toString();

        System.out.println("name: " + nameSession + "\n" + "value: " + valueSession);
    }

}
