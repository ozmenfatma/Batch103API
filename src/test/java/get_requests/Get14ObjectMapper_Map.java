package get_requests;

import base_urls.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import util.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get14ObjectMapper_Map extends JsonPlaceHolder {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void test01() {

        //set the url

        spec.pathParams("first","todos","second",198);

        //set the expected data

//       String json ="{\n" +
//            "  \"userId\": 10,\n" +
//            "    \"id\": 198,\n" +                                         //Test classında bunu istemiyoruz
//            "    \"title\": \"quis eius est sint explicabo\",\n" +
//            "   \"completed\": true\n" +
//            " }";
        //yukarda ki yerine asagidaki methodu kullaranak json olusturduk. bu method TestDatada yaptik

        String json= JsonPlaceHolderTestData.expectedDataInString(10,"quis eius est sint explicabo",true);

        //sonra bu joson datayi map e ceviriyrouz
       Map<String,Object> expectedData= ObjectMapperUtils.convertJsonToJava(json, HashMap.class);


       //send the request and get the response

      Response response= given().spec(spec).when().get("/{first}/{second}");
      response.prettyPrint();

     //Do assertion

        Map<String,Object>actualdata =  ObjectMapperUtils.convertJsonToJava(json, HashMap.class);
        System.out.println("actualdata = " + actualdata);


        assertEquals(200,response.statusCode());

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualdata.get("userId"));
        assertEquals(expectedData.get("title"), actualdata.get("title"));
        assertEquals(expectedData.get("completed"), actualdata.get("completed"));




    }
}
