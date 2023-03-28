package delete_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDeleteBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;

public class Delete02 extends DummyRestApiBaseUrl {


/*
Given
  URL: https://dummy.restapiexample.com/api/v1/delete/2
When
  HTTP Request Method: DELETE Request
Then
 Status code is 200
And
"status" is "success"
And
   "data" is "2"
And
  "message" is "Successfully! Record has been deleted"
  */


    @Test
    public void name() {


            //Set the url
            spec.pathParams("first", "delete", "second", 2);

            //Set the expedted data
            DummyRestApiDeleteBodyPojo expedtedData = new DummyRestApiDeleteBodyPojo("success", "2", "Successfully! Record has been deleted");
            System.out.println("expedtedData = " + expedtedData);

            //Send the request and get the response
            Response response = given(spec).delete("{first}/{second}");
            response.prettyPrint();

            //Do assertion
            DummyRestApiDeleteBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiDeleteBodyPojo.class);
            System.out.println("actualData = " + actualData);

            assertEquals(200, response.statusCode());
            assertEquals(expedtedData.getStatus(), actualData.getStatus());
            assertEquals(expedtedData.getData(), actualData.getData());
            assertEquals(expedtedData.getMessage(), actualData.getMessage());


        }
    }




