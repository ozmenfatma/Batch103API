package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
    /*
      Given
          https://restful-booker.herokuapp.com/booking/2279
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {                                  --Inner Map
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
   */

    @Test
    public void test01() {

        //set the Url

        spec.pathParams("first","booking","second",3201);


        //set The expected

        Map<String,String>bookingdatesMap= new HashMap<>();
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");


        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111); //---> burdaki 111 artik obje oldu, bununla islem yapamam.yapnak icin once type casting ile integer e cevirmem lazim
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdatesMap); //Inner map yaptik ,yukardaki map i kullandik
        expectedData.put("additionalneeds","Breakfast");

        System.out.println("expectedData = " + expectedData);

        //send the request and get the response

        Response response =given().spec(spec).get("/{first}/{second}"); //bu kiism parametre belirttigimiz yer
        response.prettyPrint();

        //Do Assertion

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());

        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),(actualData.get("totalprice")));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));// actual data icindeki bookingdate bir object onu once Map e ceviriyorum ki icindeki checkin checkout datasina get() ile ulasabileyim
        assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }


//    @Test
//    public void name() {
//
//        //Set the URL
//        spec.pathParams("first","booking","second",794);
//
//        //Set the expected data
//        Map<String, String> bookingdatesMap = new HashMap<>();
//        bookingdatesMap.put("checkin","2018-01-01");
//        bookingdatesMap.put("checkout","2019-01-01");
//
//        Map<String, Object> expectedData = new HashMap<>();
//        expectedData.put("firstname","John");
//        expectedData.put("lastname","Smith");
//        expectedData.put("totalprice",111);
//        expectedData.put("depositpaid",true);
//        expectedData.put("bookingdates",bookingdatesMap);
//        expectedData.put("additionalneeds","Breakfast");
//
//        System.out.println("expectedData = " + expectedData);
//
//        //Send the request and get the response
//        Response response = given().spec(spec).get("/{first}/{second}");
//        response.prettyPrint();
//
//        //Do Assertion
//        Map<String, Object> actualData = response.as(HashMap.class);
//        System.out.println("actualData = " + actualData);
//
//        assertEquals(200, response.statusCode());
//        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
//        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
//        assertEquals(expectedData.get("totalprice"),(actualData.get("totalprice")));
//        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
//        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
//        assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
//        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));

    }
