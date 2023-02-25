package APIsteps;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class signInJira {
    public static JSONObject json;
    public static String jsonStr;
    public static JSONObject session;
    public static String nameSession;
    public static String valueSession;
    public static void homePage() throws IOException {
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
