package APIsteps;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Create {
    public static String Body1;
    public static String nameCheck1;
    public static String jobCheck1;
    public static String nameCheck2;
    public static String jobCheck2;
    public static JSONObject body;


    public static void fillingBody() throws IOException {
        body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/create.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat market");
        Body1 = body.toString();
    }

    public static void sendRequest() {
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

    }

}