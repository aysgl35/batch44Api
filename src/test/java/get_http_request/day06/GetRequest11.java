package get_http_request.day06;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest11 {
    String endPoint = "http://www.gmibank.com/api/tp-customers";
    String bearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDQ0YXBpIiwiYXV0aCI6IlJPTEVfQ1VTVE9NRVIiLCJleHAiOjE2NDgyMjEyODl9.Y8qUccvQcK7EkvwnpVJlWCeehSnb-wdOqnLtb6uKCpJkgVvXK71POwGE6mb_gBIM0YH5pzh85FF77zp1KouQuw";

    @Test
    public void test() {

        Response response = given().accept(ContentType.JSON)
                .header("Authorization", "Bearer " + bearerToken)
                .when().get(endPoint).then().extract().response();
//"Bearer " burda boşluk bırakmamız gerekiyor güvenlik onlemi olarak yapmışlar
        response.prettyPrint();
    }
}