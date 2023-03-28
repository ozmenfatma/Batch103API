package get_requests;

import base_urls.AutomationexerciseBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class HomeWorkYasin2 extends AutomationexerciseBaseUrl {
/*
    Given
    https://automationexercise.com/api/productsList
    When
    User sends Get request
    Then
    Assert that number of "Women" usertype is 12
            (Kadın usertype sayısının 12 olduğunu doğrulayın)
            */


    @Test
    public void name() {
        spec.pathParam("first","productsList");

        Response response=given().when().spec(spec).contentType(ContentType.JSON).get("{first}");
        response.jsonPath().prettyPrint();

        assert response.jsonPath().getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype").size() == 12;
    }



}
