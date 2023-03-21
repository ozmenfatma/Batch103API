package get_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PetStorePojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class HomeWork3_3 extends PetStoreBaseUrl {
/*
 Given
            1) https://petstore.swagger.io/

            2){
  "id": 35,
  "username": "Pati Lisa",
  "firstName": "Kubra",
  "lastName": "Tanribuyurdu",
  "email": "abc@gmail.com",
  "password": "12345",
  "phone": "123454321",
  "userStatus": 0
}

 When
            I send POST Request to the Url
        Then
            Status code is 201
             And response body should be like {
                                                "id": 35,
                                                 "username": "Pati Lisa",
                                                  "firstName": "Kubra",
                                                    "lastName": "Tanribuyurdu",
                                                     "email": "abc@gmail.com",
                                                     "password": "12345",
                                                      "phone": "123454321",
                                                      "userStatus": 0
       */

    @Test
    public void name() {

   spec.pathParam("first","user");

        PetStorePojo expectedData= new PetStorePojo("Pati Lisa","Kubra","TanriBuyurdu","abc@gmail.com","123456","123454321",0);

        Response response= given().spec(spec).body(expectedData).post("{first}");

        response.prettyPrint();



       PetStorePojo actualData= response.as(PetStorePojo.class);

       assertEquals(201,response.statusCode());
        Assert.assertEquals(expectedData.getUsername(), actualData.getUsername());
        Assert.assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(expectedData.getLastName(), actualData.getLastName());
        Assert.assertEquals(expectedData.getEmail(), actualData.getEmail());
        Assert.assertEquals(expectedData.getPassword(), actualData.getPassword());
        Assert.assertEquals(expectedData.getPhone(), actualData.getPhone());
        Assert.assertEquals(expectedData.getUserStatus(), actualData.getUserStatus());





    }
}
