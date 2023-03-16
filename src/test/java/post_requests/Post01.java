package post_requests;

import base_urls.JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post01 extends JsonPlaceHolder {

    /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
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



      /*
    De-Serialization: Json datanın Java objesine çevrilmesi.
    Serialization: Java objesinin, Json dataya çevrilmesi.
    2 türlü De-Serialization yapacağız:
        i) Gson: Google tarafından üretilmiştir.
        ii) Object Mapper: En popüleri
    */

    @Test
    public void test01() {

       //set the Url
        spec.pathParam("first","todos");

        //set the expected data ==> Payload


        Map<String,Object> expectedData= new HashMap<>();  // burda gonderecegim datalari map e ceviriyorum

        expectedData.put("UserId",55.0);

        expectedData.put("Title","Tidy your room");

        expectedData.put("completed",false);

        System.out.println(expectedData);


        //Send the Request and get the response  // burdaki body gonderecegmz datayi iceren body, expexted data icerir
                                                 //burda once pom xml e dependicies Json , Gson yukluyoruz

       Response response= given().spec(spec).contentType(ContentType.JSON).when().body(expectedData).post("/{first}");

       response.prettyPrint();//


        //do assertion

     Map<String,Object> actualData=  response.as(HashMap.class);    // de-serialization --> json to java

        System.out.println("actual data : " + actualData);

         assertEquals(201,response.statusCode());

        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));

//burda iki datayi da ayni sekilde map e cevirip o sekilde karsilastiriyoruz


    }
}
