package get_requests;

import com.sun.codemodel.JCatchBlock;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class Get02 {


    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void name() {

   /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */




            //1. Adım: Set the URL
            String url = "https://restful-booker.herokuapp.com/booking/0";

            //2. Adım: Set the expected data==>(Post, Put, Patch)

            //3. Adım: Send the request get the response
            Response response = given().when().get(url);
            response.prettyPrint();


            //Do Assertion
            response.
                    then().
                    statusCode(404).//HTTP Status code should be 404
                    statusLine("HTTP/1.1 404 Not Found");//Status Line should be HTTP/1.1 404 Not Found

            //Response body contains "Not Found"
            //assertTrue() methodu, method parantezi içindeki değerin false olması durumda test "fail" olur.
            assertTrue(response.asString().contains("Not Found"));

            //Response body does not contain "TechProEd"
            //assertFalse() methodu, method parantezi içindeki değerin true olması durumda test "fail" olur.
            assertFalse(response.asString().contains("TechProEd"));

            //Server is "Cowboy"
            assertEquals("Cowboy",response.header("Server"));

        }


/* hata mesaji alanalar
String url ="https://restful-booker.herokuapp.com/booking/0";
        try {
            Response response= given().when().get(url);
        } catch (Exception e) {
            assert e.getMessage().contains("404");
            assert e.getMessage().contains("Not Found");
            Assert.assertFalse(e.getMessage().contains("TechProEd"));
        }
 */

    /*

     */








        }


