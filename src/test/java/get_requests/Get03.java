package get_requests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get03 {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */

    @Test
    public void get03(){
        //set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion

        //1. YOL

        response.
                then().
                statusCode(200).//parantez iicndekuler metadata ,dml oluyor data icnde data
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).//"title" is "et itaque necessitatibus maxime molestiae qui quas velit",
                body("completed",equalTo(false)).  //  "completed" is false
                body("UserId",equalTo(2));  //"userId" is 2  //body de datalari assert ederiz headersleri degil




        //2.YOL SOFT ASSSERTION(coklu asseertion yaparak biz soft assertion a cevirdik

        response.
                then().
                statusCode(200).//parantez iicndekuler metadata ,dml oluyor data icnde data
                contentType(ContentType.JSON).
                body("title",equalTo("Xet itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(23));  //en sondaki hata yi boylelikle ilk hataalra takilmadan gorebildik


    }

}
