package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
            (Data içerisinde firstname değeri "Aaron", lastname değeri "Chen" olan biri olmalı)
     */

    @Test
    public void get05(){
        //Set the URL

        spec.
                pathParam("first","booking").
                queryParams("firstname","Sally","lastname","Brown");

        //set the expected



        //Send the request and get the response

      Response response=  given().spec(spec).when().get("/{first}");

      response.prettyPrint();


      ///Do Assertion

        response.then().statusCode(200);// Status code is 200

//        Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
//        (Data içerisinde firstname değeri "Aaron", lastname değeri "Chen" olan biri olmalı)


        assertTrue(response.asString().contains("bookingid"));// herhangi bir id geliyosa bos olmadigi anlamina gelir

        //dokumanda isim olmadigi sadece id oldugu icin id lere bakip varmi yokmu diyebilirz







    }

}
