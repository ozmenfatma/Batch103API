package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02Hata {
    @Test
    public void name(){
        String url ="https://restful-booker.herokuapp.com/booking/0";
        try {
            Response response= given().when().get(url);
        } catch (Exception e) {
            assert e.getMessage().contains("404");
            assert e.getMessage().contains("Not Found");
            Assert.assertFalse(e.getMessage().contains("TechProEd"));
        }
    }
}
