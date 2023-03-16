package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


public class HerOkuAppBaseUrl {

    protected RequestSpecification spec;  //extend yapanlar protected e ulasabilir.. spec() request leri spesifikation hale getiriyoruz

    @Before//Her test methodundan önce çalışır.
    public void setUp() {  //setup methodu calismazxcsa RequestSpecification null olur
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }
}