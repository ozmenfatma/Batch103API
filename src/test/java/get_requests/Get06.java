package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get06 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
     {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-10-27",
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
}
     */

    @Test
    public void name() {


            //Set the URL
            spec.pathParams("first","booking","second",23);

            //Set the expected data

            //Send the request and get the response
            Response response = given().spec(spec).when().get("/{first}/{second}");
            response.prettyPrint();


            //Do Assertion
//            response.then().
//                    statusCode(200).
//                    contentType(ContentType.JSON).
//                    body("firstname",equalTo("Josh"), //body methodun hamcrest methodlar ile kullanimi
//                            "lastname",equalTo("Allen"),
//                            "totalprice", equalTo(111),
//                            "depositpaid",equalTo(true),
//                            "bookingdates.checkin",equalTo("2018-01-01"),
//                            "bookingdates.checkout",equalTo("2019-01-01"),
//                            "additionalneeds",equalTo( "super bowls")
//                    );

//2.YOL

        //2. Yol: JsonPath ile
        JsonPath jsonPath = response.jsonPath();
//
//        assertEquals("Jane",jsonPath.getString("firstname"));
//        assertEquals("Doe",jsonPath.getString("lastname"));
//        assertEquals(111,jsonPath.getInt("totalprice"));
//        assertTrue(jsonPath.getBoolean("depositpaid"));
//        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
//        assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
//        assertEquals("Extra pillows please",jsonPath.getString("additionalneeds"));



//3.YOL  TestNG Soft Assert


        //1. SoftAssert objesi oluştur
        SoftAssert softAssert = new SoftAssert();

         //2. Assertion
        softAssert.assertEquals(jsonPath.getString("firstname"),"Josh","firstname uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Allen","lastname uyuşmadı");
        softAssert.assertEquals(jsonPath.getInt("totalprice"),111,"totalprice uyuşmadı");
        softAssert.assertTrue(jsonPath.getBoolean("depositpaid"),"depositpaid uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01","checkin uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01","checkout uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"),"midnight snack","additionalneeds uyuşmadı");

        //3. softAssert.assertAll() diyerek doğrulamayı kontrol et. Aksi taktirde test hep "PASS" olur.
        softAssert.assertAll();






        //



    }
}
