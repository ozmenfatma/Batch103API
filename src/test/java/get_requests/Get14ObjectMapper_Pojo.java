package get_requests;

import base_urls.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get14ObjectMapper_Pojo extends JsonPlaceHolder {
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
    public void name() {

        //1.set the url

        spec.pathParams("first","todos","second",198);

        //2. expected data

        JsonPlaceHolderPojo expecteddata=    new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);
        System.out.println("expecteddata = " + expecteddata);

        //3.send the request and get the response

        Response response=   given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4.Do assertion

       JsonPlaceHolderPojo actualdata= ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
       System.out.println("actualdata = " + actualdata);

       assertEquals(200,response.statusCode());
       assertEquals(expecteddata.getUserId(),actualdata.getUserId());
       assertEquals(expecteddata.getTitle(),actualdata.getTitle());
       assertEquals(expecteddata.getCompleted(),actualdata.getCompleted());


    }
}
