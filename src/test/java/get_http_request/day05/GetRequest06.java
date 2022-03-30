package get_http_request.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 {
    /*
    https://restful-booker.herokuapp.com/booking/5 url ine
    accept type i "application/json" olan GET request i yolladigimda
    gelen response un
    status kodunun 200
    ve content type inin "application/json"
    ve  "firstname": "Susan",
    ve  "totalprice": 726,
    ve "checkin": "2017-05-13",
       test edin
     */
@Test
    public void test06(){
    //String url =" https://restful-booker.herokuapp.com/booking/5";
    //String kullanmadan da yazabiliriz
    Response response=given().when().get(" https://restful-booker.herokuapp.com/booking/5");
    response.prettyPrint();
    response.then().assertThat().contentType(ContentType.JSON).statusCode(200);
    response.then().assertThat().body("firstname", Matchers.equalTo("Susan"),
            "totalprice" , Matchers.equalTo(726),
            "bookingdates.checkin",Matchers.equalTo("2017-05-13"));
}
}
