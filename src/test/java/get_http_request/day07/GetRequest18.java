package get_http_request.day07;

import base_url.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest18 extends GMIBankBaseUrl {

    /*
           http://www.gmibank.com/api/tp-customers/43703
           "firstName": "Alda",
           "lastName": "Monahan",
           "middleInitial": "Nichelle Hermann Kohler",
           "email": "com.github.javafaker.Name@7c011174@gmail.com",
           "mobilePhoneNumber": "909-162-8114",
           "city": "St Louis",
           "ssn": "108-53-6655"
           1) MATCHERS CLASS
           2) JSON PATH
           3) De-Serialization
     */
    @Test
    public void test18(){
        //1) URL OLUŞTUR
    spec03.pathParams("bir", "tp-customers", "iki", "43703");


        //2) EXPECTED DATA OLUŞTUR
        Map<String, Object> expectedData= new HashMap<>();
        expectedData.put("firstName","Alda");
        expectedData.put("lastName", "Monahan");
        expectedData.put("middleInitial", "Nichelle Hermann Kohler");
        expectedData.put("email", "com.github.javafaker.Name@7c011174@gmail.com");
        expectedData.put("mobilePhoneNumber", "909-162-8114");
        expectedData.put("city", "St Louis");
        expectedData.put("ssn", "108-53-6655");

        System.out.println("EXPECTED DATA: " +expectedData);
        //3)REQUEST VE RESPONSE
        Response response = given()
                .spec(spec03)
                .header("Authorization","Bearer " + generateToken())
                .when()
                .get("/{bir}/{iki}");

        response.prettyPrint();

        //3) DOGRULAMA

        // 1.YOL MATCHER CLASS İLE
        response.then().assertThat().body("firstName", equalTo("Alda"), "lastName",equalTo("Monahan"),
                "middleInitial", equalTo("Nichelle Hermann Kohler"),
                "email",equalTo("com.github.javafaker.Name@7c011174@gmail.com"),
                "mobilePhoneNumber",    equalTo("909-162-8114"),
                "city", equalTo("St Louis"),
                "ssn", equalTo("108-53-6655"));
        // 2. YOL JSON PATH İLE
        //3. YOL DE-SERİALİZATİON

    }
}
