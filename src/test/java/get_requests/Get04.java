package get_requests;

import base_urls.JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolder {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04() {

        // Set The Url

       // String url= "https://jsonplaceholder.typicode.com/todos";
        spec.pathParam("first", "todos");  // parametreye gitmek icin

        // Set the Expected Data

        //Send The request and get the response

        //Response response=given().spec(spec).accept(ContentType.JSON).when().get("/{first}"); //  Accept type is "application/json",karsi tarafin kabul eddevcegi data tipi
        Response response=given().spec(spec).when().get("/{first}");  //endpointi artik spec den alacagimiz icin spec koyduk
        response.prettyPrint();


        response.prettyPrint();

        //Do Assertion
        response.then().statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasSize(200),  //id lerinn 200 oldugunu say
                        "title",hasItem("quis eius est sint explicabo"),  //hasItem contains gibi
                        "userId",hasItems(2,7,9));  // cogul oldugu zaman hasItems


        //hasSıze :eleman sayisini assert edeer
        //hasItem : contains methodu gibi objenin icerilip icerilmedigini assert eder
        //hasItems : containsAll() methodu gibi birdfen fazla objenin assert edip edilmedigini assert eder







    }
}
