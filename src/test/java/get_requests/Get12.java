package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get12 extends HerOkuAppBaseUrl {
/*
    Given
    https://restful-booker.herokuapp.com/booking/392
    When
    I send GET Request to the URL
            Then
    Status code is 200
    And
    Response body is like:
   {
    "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
    */


    @Test
    public void name() {

        //1.

        spec.pathParams("first","booking","second",535);


        //2.

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expecteddata=new BookingPojo("John","Smith",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expecteddata = " + expecteddata);

        //3.

       Response response= given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

       //4.

       BookingPojo actualData= response.as(BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expecteddata.getFirstname(),actualData.getFirstname());
        assertEquals(expecteddata.getLastname(),actualData.getLastname());
        assertEquals(expecteddata.getTotalprice(), actualData.getTotalprice());
        assertEquals(expecteddata.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expecteddata.getAdditionalneeds(), actualData.getAdditionalneeds());



    }
}
