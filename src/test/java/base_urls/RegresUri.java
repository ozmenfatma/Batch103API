package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RegresUri {

    protected RequestSpecification spec;  //extend yapanlar protected e ulasabilir.. spec() request leri spesifikation hale getiriyoruz

    @Before//Her test methodundan önce çalışır.
    public void setUp() {  //setup methodu calismazxcsa RequestSpecification null olur
        spec = new RequestSpecBuilder().setAccept(ContentType.JSON).setBaseUri("https://reqres.in/api/users/").build();

        //artik accept type ve url hep burda,authenticvation, surekli gonderecegim body ,content type hepsini burda olusturabilirz

    }
}