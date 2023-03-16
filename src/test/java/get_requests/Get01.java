package get_requests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class Get01 {
/*
        Given
            https://restful-booker.herokuapp.com/booking/55
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
    public void name() {

//        i)    Set the URL
        String url="  https://restful-booker.herokuapp.com/booking/55";


//        ii)   Set the expected data


//        iii)  Send the request and get the response
Response response= given().when().get(url);
response.prettyPrint();


//        iv)   Do assertion

        //burdaki then methodu assertion gorevi gorur !

        response.
                then().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");


    }
}
