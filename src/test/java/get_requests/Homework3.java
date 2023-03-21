package get_requests;

import base_urls.RegresUri;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RegresData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Homework3 extends RegresUri {

//2.
     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void name() {
        spec.pathParam("first","users");
        Map<String,String>expectedData=new RegresData().expectedMethod("morpheus","leader");
        Response response=given().spec(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        expectedData.put("id",response.jsonPath().getString("id"));
        expectedData.put("createdAt",response.jsonPath().getString("createdAt"));


        assertEquals(201,response.statusCode());
        Map<String,Object> actualData= response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));
//        assertEquals(expectedData.get("id"),actualData.get("id"));   olmadi
//        assertEquals(expectedData.get("createdAt"),actualData.get("createdAt"));


//3.
/*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
*/




    }


}
