import files.payload2;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

// Self Implemented
public class Basic2 {
    @Test(dataProvider = "BookData")
    public void getApi(String isbn, String aisle){
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response=given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("Content Type", ContentType.TEXT))).
                contentType("Content Type;charset = UTF-8").body(payload2.addBook(isbn,aisle)).
                when().post("/Library/Addbook.php").then().assertThat().statusCode(200).
                extract().response().asString();
        JsonPath js = new JsonPath(response);
        String id = js.getString("ID");
        System.out.println(id);


        String resDelete = given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("Content Type", ContentType.TEXT))).
                contentType("Content Type;charset = UTF-8").body("{\"ID\" : \""+id+"\"}").
                when().post("/Library/DeleteBook.php").then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js2 = new JsonPath(resDelete);
        System.out.println(js.getString("msg"));

    }

    @DataProvider(name="BookData")
    public Object[][] getData(){
        return new Object[][] {{"kdsk","610"},{"sfdg","810"},{"sfpg","810"} };
    }
}


