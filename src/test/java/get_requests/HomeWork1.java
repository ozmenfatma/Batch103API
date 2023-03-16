package get_requests;

import base_urls.RegresUri;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;

public class HomeWork1 extends RegresUri {

    /*
     Given
         https://reqres.in/api/users/3
     When
         User sends a GET Request to the url
     Then
         HTTP Status Code should be 200
     And
         Content Type should be JSON
     And
         Status Line should be HTTP/1.1 200 OK
  */
    @Test
    public void test() {
        spec.pathParam("id", 3);

        Response response=given().spec(spec).when().get("/{id}");  //endpointi artik spec den alacagimiz icin spec koyduk
        response.prettyPrint();


        response.prettyPrint();

        //Do Assertion
        response.then().statusCode(200).
                contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void test01(){
         /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */
        spec.pathParam("id", 23);

        Response response=given().spec(spec).when().get("/{id}");  //endpointi artik spec den alacagimiz icin spec koyduk
        response.prettyPrint();

        response.then().statusCode(404).
                contentType(ContentType.JSON).statusLine("HTTP/1.1 404 Not Found").header("Server","cloudflare");
                assertTrue(response.asString().contains(" "));
    }

    @Test
    public void test02(){
         /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

        spec.pathParam("id",2);
      Response response= given().when().spec(spec).get("/{id}");
response.prettyPrint();

response.then().statusCode(200).contentType(ContentType.JSON).
        body("email",hasItem("janet.weaver@reqres.in"),"first_name",hasItem("Janet"),"last_name",hasItem("Weaver"),
                "text",hasItem("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}