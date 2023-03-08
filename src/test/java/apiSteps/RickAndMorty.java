package apiSteps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class RickAndMorty {
    public static String charId;
    public static int lastEpisode;
    public static int episode;
    public static int lastCharacter;
    public static int idLastCharacter;
    public static String speciesLast;
    public static String speciesMorty;
    public static String nameLocationMorty;
    public static String nameLocation;

    @Step("Получаем персоонажа по номеру: {id}")
    public static void getCharacter(String id){
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
    @Step("Получение последнего эпизода")
    public static void getEpisode(){
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
    @Step("Получение id последнего персонажа {lastEpisode} эпизода")
    public static void getIdPerson(){
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
    @Step("Получение локации персонажа с id {idLastCharacter}")
    public static void getLocationPerson(){
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
    }
}