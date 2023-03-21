package post_requests;

import base_urls.JsonPlaceHolder;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post05ObjectMapper_Map extends JsonPlaceHolder {

/*
Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
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
    public void name() throws IOException {

        //Set the Url

        spec.pathParam("first","todos");

        //set the expected data

       Map<String,Object> expectedData= new JsonPlaceHolderTestData().expectedDataMethod(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

      Response response= given().spec(spec).body(expectedData).post("{first}");
      response.prettyPrint();


      //Do assertion

        Map<String,Object>actualdata=  new ObjectMapper().readValue(response.asString(), HashMap.class);// string e donen response direk map e cevrilebbilir

        System.out.println("actualdata = " + actualdata);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("userId"), actualdata.get("userId"));
        assertEquals(expectedData.get("title"), actualdata.get("title"));
        assertEquals(expectedData.get("completed"), actualdata.get("completed"));


    }
}
