package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PetStoreBaseUrl {

    protected RequestSpecification spec;

    @Before//Her test methodundan önce çalışır.
    public void setUp() {  //setup methodu calismazxcsa RequestSpecification null olur

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON).setBaseUri("https://petstore.swagger.io/v2").build();

    }
}