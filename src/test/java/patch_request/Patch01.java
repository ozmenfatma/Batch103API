package patch_request;

import base_urls.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Patch01 extends JsonPlaceHolder {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

    @Test
    public void test() {

        //JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();  ilk olarak bu objeyi kullanamadık çünkü diğer parametreleri
//girmezsek hata verir yada null girersek  map a eklenir datalar bozulur.  Fakat bu durum Class'taki hazır methodun içine gidip==>
// if()  kullanarak null değerlerinin eklenmesi önlenebilir hazır methodu kullanmak için
//accept type karsi tarafin kabul ettigi
        //content type bizim gonderdgmz


        //hangi library
        //put get nedir ne islemi yapar
        //biz api ile server daki datayi cagiriyrouz


        //Set the URL
        spec.pathParams("first","todos","second",198);

        //Set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod(null,"Wash the dishes",null);
        System.out.println("expectedData = " + expectedData);




        //Send the request and get the response
        Response response = given().spec(spec).body(expectedData).patch("/{first}/{second}");
        response.prettyPrint();



        //Do Assertion
        Map<String ,Object> actualData =  response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("title"),actualData.get("title"));

        //Eğer tüm body assert edilecekse:
        assertEquals(10, actualData.get("userId"));
        assertEquals(true, actualData.get("completed"));

       // eger simplify assert yapacaksak actualdata object oldugu icin onun wrapper yapmaliyiz onune boolean getirerek
       // assertTrue((boolean) actualData.get("completed"));




    }
}
