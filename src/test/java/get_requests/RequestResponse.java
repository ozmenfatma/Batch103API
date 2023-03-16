package get_requests;
import io.restassured.response.Response;

import java.sql.Connection;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {
//API uygulamalari birbiri ile konusturma

    //Tum webservice ler bir API dir ama Tum API lar Web Service degildir
    //Web service World Wide Web www uzerinden brbrleriyle iletisim kuran yapilar
    //Api internet olmadan da iletisim saglayabilir(microsoft word farkli uygualamlar ile iletisim icin kendi Api kullanir
    //EndPoint Kaynaga nasil erisecegimizi gosteren URI lardir(Uniform Resource Identifiers)
    //endpoint ulasmak istedigimiz datayi belirliyoruz


    /*

    1)Postman manuel API testi için kullanilir.

    2)API otomasyonu için Rest-Assured Library kullanacagiz.

    3)Otomasyon kodlarının yazımı için şu adımları izliyoruz:
       a) Gereksinimleri anlama

       b) Test case i yazma:
          -Test case i yazmak için "Gherkin Language" kullaniyoruz.
           x) Given: Ön koşullar  --> Endpoint, body
           y) When : İşlemler --> Get,Put,Delete...
           z) Then : Dönütler --> Assert
           t) And --> Çoklu işlemlerin art arda yazilacağı yerlerde kullanilir.
        c) Test kodunu yazarken şu adımları izleriz:
           i)    Set the URL
           ii)   Set the expected data
           iii)  Send the request and get the response
           iv)   Do assertion
     */

    public static void main(String[] args) {

        String url="https://restful-booker.herokuapp.com/booking/55";

        //Get request nasıl yapılır:

        Response response = given().when().get(url);



        response.prettyPrint(); //prettyPrint() methodu response datayı yazdırır.

        // ilk yapılması gereken Status Codu öğrenmektir.

        //Status Code nasil yazdiirilir

        System.out.println("status Code :" + response.statusCode());  //

        //Content Type nasil
        System.out.println("Content Type : "+response.contentType());

        //Status Line nasil
        System.out.println("response.statusLine() = " + response.statusLine()); //basari codu


        //Header nasil yazdirilir :

        System.out.println("response.header = " + response.header("Connection"));

        System.out.println("response.header = " + response.header("Server"));

        //Headers nasil yazdirilir :

        System.out.println("response.headers() = " + response.headers());

        // time nasil calisir

        System.out.println("response.getTime() = " + response.getTime());


    }
}
