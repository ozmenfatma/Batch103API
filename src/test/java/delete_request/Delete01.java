package delete_request;

import base_urls.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Delete01 extends JsonPlaceHolder {

    /*
     Given
         https://jsonplaceholder.typicode.com/todos/198
     When
   I send DELETE Request to the Url
Then
   Status code is 200
   And Response body is { }
  */

    @Test
    public void name() {
        //Set the url
        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data
        Map<String, String> expectedData = new HashMap<>();

        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, String> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        assertEquals(200, response.statusCode());

        //1. Yol
        assertEquals(expectedData, actualData);

        //2. Yol
        assertTrue(actualData.isEmpty());

        //3. Yol
        assertEquals(0, actualData.size());

    }


}