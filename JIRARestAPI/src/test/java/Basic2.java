import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Basic2 {
    public static void main(String[] args) throws IOException {

        // Header is for sending additional details for the request

        // Getting the session for Jira cookie authentication
        // Use SessionFilter to smartly avoid recreating sessions in subsequent requests
        // relaxedHTTPSValidation() is optional as some websites use strict HTTP/HTTPS certification, hence better to include this with the request
        RestAssured.baseURI = "http://localhost:8080";
        SessionFilter session = new SessionFilter();
        String response = given().relaxedHTTPSValidation().header("content-type", "application/json").
                body("{ \"username\": \"seyiadex1\", \"password\": \"jirapass22\" }").log().all().filter(session).when().post("/rest/auth/1/session").
                then().log().all().assertThat().statusCode(200).extract().response().asString();

        // This isn't needed anymore as SessionFilter is more optimised
        /*JsonPath js = new JsonPath(response);
        String name = js.getString("session.name");
        String value = js.getString("session.value");
        String cookie = (name+"="+value);
        System.out.println(name);
        System.out.println(value);*/

        // Create issue
        /*String issue = given().header("content-type", "application/json").body(new String(Files.readAllBytes(Paths.get("C:/rahulShetty/JIRARestAPI/createIssue.json"))))
                .log().all().filter(session).when().post("/rest/api/2/issue")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();
        JsonPath js1 = new JsonPath(issue);
        String id = js1.getString("id");
        System.out.println(id);*/

        String id = "10016";

        // Add Comment
        String commentResp = given().header("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:/rahulShetty/JIRARestAPI/createComment.json"))))
                .log().all().filter(session).when().post("/rest/api/2/issue/"+id+"/comment")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();
        System.out.println(commentResp);
        JsonPath js2 = new JsonPath(commentResp);
        String commentId = js2.getString("id");
        System.out.println(commentId);


       /* // Update Comment
        String comment2 = given().header("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:/rahulShetty/JIRARestAPI/updateComment.json"))))
                .log().all().filter(session).when().put("/rest/api/2/issue/"+id+"/comment/"+commentId)
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println(comment2);

        // Upload file to the created bug
        given().header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data").log().all().filter(session).pathParam("key",id)
                .multiPart(new File("jira.txt")).when().post("/rest/api/2/issue/{key}/attachments")
                .then().log().all().assertThat().statusCode(200);
*/
        // Get issue type
        // path parameter returns all   /rest/api/2/issue/{key}
        // Query parameter limits the returned response to a certain field (filtering)          ?"fields"="comments"
        String issueDetails = given()
                .filter(session).pathParam("key",id).queryParam("fields","comment").log().all()
                .when().get("/rest/api/2/issue/{key}")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println(issueDetails);

        // Validate response from dynamic response
        JsonPath jsIssue = new JsonPath(issueDetails);
        int getSize = jsIssue.getInt("fields.comment.comments.size()");
        for(int i = 0;i<getSize;i++){
            String issueId = jsIssue.getString("fields.comment.comments["+i+"].id");
            if(issueId.equals(commentId)){
                System.out.println(jsIssue.getString("fields.comment.comments["+i+"].author.name"));
                String commentBody = jsIssue.getString("fields.comment.comments["+i+"].body");
                Assert.assertEquals(commentBody, "My Comment to Assert");
                break;
            }
        }



     //Add Comments         POST        /rest/api/2/issue/{issueIdOrKey}/comment 201
        //Update Comments   PUT     /rest/api/2/issue/{issueIdOrKey}/comment/{id}   200
        // Get comments    GET     GET /rest/api/2/issue/{issueIdOrKey}/comment
     //   GET /rest/api/2/issuetype/{id}
        // curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: no-check" -F "file=@myfile.txt" http://myhost/rest/api/2/issue/TEST-123/attachments



    }
}
