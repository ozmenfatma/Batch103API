package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get13 extends GoRestBaseUrl {

    /*
    Given
        https://gorest.co.in/public/v1/users/247158
    When
        User send GET Request to the URL
    Then
        Status Code should be 200
    And
        Response body should be like
      {
        "meta": null,
        "data": {
            "id": 247158,
            "name": "Chandak Dutta",
            "email": "dutta_chandak@bartoletti.name",
            "gender": "female",
            "status": "inactive"
        }
    }
*/


    @Test
    public void name() {


        //Set the URL
        spec.pathParams("first", "users", "second", 247152);

        //Set the expected data
        //assertion yapmak icin expected burda olusturuyoruz, formati Pojo,

        GoRestDataPojo goRestDataPojo = new GoRestDataPojo("Ujjwal Bandopadhyay", "ujjwal_bandopadhyay@mueller-schoen.net", "male", "active");
        GoRestPojo expectedData = new GoRestPojo(null, goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion

        //burda da actualData yi pojo formatina ceviriyorum
        GoRestPojo actualData = response.as(GoRestPojo.class);
        System.out.println("actualData = " + actualData);

//***Not
       // assertEquals(expectedData.getData().getName(),actualdata.getData().getName());
       // assertEquals(goRestDataPojo.getName(),actualData.getData().getName());// daha kisa olusmus olan pojo kullaniyorum expected icin

        assertEquals(200, response.statusCode());
        assertEquals(goRestDataPojo.getName(), actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(), actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(), actualData.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(), actualData.getData().getStatus());
        assertEquals(expectedData.getMeta(), actualData.getMeta());

    }
}
