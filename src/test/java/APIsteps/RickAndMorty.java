package APIsteps;

import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class RickAndMorty {
    public static String charId;
    public static int lastEpisode;
    public static int episode;
    public static int lastCharacter;
    public static int idLastCharacter;
    public static JSONObject location;
    public static String speciesLast;
    public static String speciesMorty;

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
        System.out.println("id Морти Смит: " + charId);
        System.out.println("Раса Морти Смит: " + speciesMorty);
    }
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
    public static void getIdPerson(String numEpisode){
        Response gettingIdLastPerson = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/episode/" + numEpisode )
                .then()
                .extract()
                .response();
        lastCharacter = (new JSONObject(gettingIdLastPerson.getBody().asString()).getJSONArray("characters").length()-1);
        idLastCharacter = Integer.parseInt(new JSONObject(gettingIdLastPerson.getBody().asString()).getJSONArray("characters")
                .get(lastCharacter).toString().replaceAll("[^0-9]",""));
        System.out.println("id последнего персонажа, последнего эпизода: " + idLastCharacter);
    }
    public static void getLocationPerson(){
        Response gettingLocationPerson = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + idLastCharacter )
                .then()
                .extract()
                .response();
        location = (new JSONObject(gettingLocationPerson.getBody().asString()).getJSONObject("location"));
        String nameLocation = location.get("name").toString();
        speciesLast = new JSONObject(gettingLocationPerson.getBody().asString()).get("species").toString();
        System.out.println("Место нахождение последнего персонажа: " + nameLocation);
        System.out.println("Раса персонажа: " + speciesLast);
    }


}
