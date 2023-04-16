import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Basic {
    public static void main(String[] args) throws IOException {

        // Create cookie session
        RestAssured.baseURI = "http://localhost:8080";
        String response = given().header("content-type", "application/json").
                body("{ \"username\": \"seyiadex1\", \"password\": \"jirapass22\" }").when().post("/rest/auth/1/session").
                then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String name = js.getString("session.name");
        String value = js.getString("session.value");
        String cookie = (name+"="+value);
        System.out.println(name);
        System.out.println(value);

        // Create issue
        String issue = given().header("content-type", "application/json").header("cookie",cookie).body(new String(Files.readAllBytes(Paths.get("C:/rahulShetty/JIRARestAPI/createIssue.json"))))
                .when().post("/rest/api/2/issue")
                .then().assertThat().statusCode(201).extract().response().asString();
        JsonPath js1 = new JsonPath(issue);
        String id = js1.getString("id");
        System.out.println(id);

        //Delete issue
        given().when().header("cookie",cookie).
                when().delete("/rest/api/2/issue/"+id)
                .then().assertThat().statusCode(204);

    }
}
