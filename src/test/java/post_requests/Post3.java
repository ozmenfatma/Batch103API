package post_requests;

import base_urls.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post3 extends JsonPlaceHolder {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
                                    */

    @Test
    public void name() {

        //Set the Url
        spec.pathParam("first","todos");

        //set the expected data
        JsonPlaceHolderPojo expectedData= new JsonPlaceHolderPojo(55,"Tidy your room",false); // icinde userId title compeletd iceren obje olustu , her clas bir data tipidir
        System.out.println("expectedData = " + expectedData);

        //burda pojoclas olusturup obje ile datalari olusturdum

   //

      Response response= given().spec(spec).body(expectedData).post("{first}");
      response.prettyPrint();

     //Do Assertion

       JsonPlaceHolderPojo actualData=  response.as(JsonPlaceHolderPojo.class) ;
        System.out.println("actualData = " + actualData);

      assertEquals(200,response.statusCode());

        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());



    }
}
