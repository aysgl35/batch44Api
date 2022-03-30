package get_http_request.day05;

import base_url.ReqresinBaseUrl;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest07 extends ReqresinBaseUrl {
    /*
    https://regres.in/api/users URL request olustur.
    body içersindeki id si 5 olan datayi
    1) Matcher CLASS ile
    2) jsonPath ile dogrulayin.
    */
    @Test
    public void test07(){
        spec01.pathParams("parametre1", "api","parametre2", "users");
        // https://reqres.in
     Response response=given().spec(spec01).when().get("/{parametre1}/{parametre2}");
     // "/{parametre1}/{parametre2}" -> /api/users
     response.prettyPrint();
     //1. yol : Matchers Class
     response.then().assertThat().body("data[4].email",
             Matchers.equalTo("charles.morris@reqres.in"), "data[4].first_name",
             Matchers.equalTo("Charles"),"data[4].last_name", Matchers.equalTo("Morris"));

    //2.yol: JsonPath

        JsonPath json = response.jsonPath();
        System.out.println(json.getList("data.email"));
        System.out.println(json.getString("data.first_name"));
        System.out.println(json.getString("data.last_name"));

        assertEquals("charles.morris@reqres.in",json.getString("data[4].email"));
        assertEquals("Charles", json.getString("data[4].first_name"));
        assertEquals("Morris", json.getString("data[4].last_name"));
    }
}
