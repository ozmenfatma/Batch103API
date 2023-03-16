package get_requests;

import base_urls.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get08 extends JsonPlaceHolder {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void test() {

        //Set The Url
        spec.pathParams("first","todos","second",2);  //ilk olarak spec icine param koy

       //Set The expected Data   // karsidan gelen data MAp e cevrilir,

        //MAp= coklu datayı entrySet olarak tutmak icin bir yapıdır

         JsonPlaceHolderTestData obj= new JsonPlaceHolderTestData();
         Map<String,Object> expectedData= obj.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);


         expectedData.put("id",2);
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");

        System.out.println("expected " + expectedData);

        //Send The Request and get The response

        Response response=  given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //do Assertion  --ve sonra Json ile karsilastir asMAp ile de-serialization



        Map<String,Object> actualData=  response.as(HashMap.class); //burda HashMap de kullanabilirz

        System.out.println("Actual "+ actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));

        // And header "Via" is "1.1 vegur"
        assertEquals(expectedData.get("Via"),response.header("Via"));

        // And header "Server" is "cloudflare"
        assertEquals(expectedData.get("Server"),response.header("Server"));





    }
}
