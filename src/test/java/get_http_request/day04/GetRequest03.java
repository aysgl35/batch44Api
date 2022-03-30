package get_http_request.day04;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {
    /*
     String url = "https://restful-booker.herokuapp.com/booking/7" url ine GET requesti
     yolladigimda gelen response un status kodunun 200
     ve content type inin "application/json"
     ve firstname in "Mary"
     ve lastname in "Smith"
     ve checkin date in 2015-02-12
     ve checkout date in 2021-12-18 oldugunu test edin
     */
    @Test
    public void test03(){
        String url = "https://restful-booker.herokuapp.com/booking/7";
        Response response= given().when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType("application/json");
        //assertThat() olmasa da oluyor
        response.then().assertThat().body("firstname", equalTo("Sally"),"lastname",equalTo("Jones")
                ,"bookingdates.checkin",equalTo("2020-12-09"),"bookingdates.checkout",equalTo("2021-12-27"));
        //response.then().body("firstname",)

    }
}
