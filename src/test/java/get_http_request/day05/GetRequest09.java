package get_http_request.day05;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest09  extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employees url  e git.
    1)Matcher Class ile
    2)JsonPath ile dogrulayin.
     */

    @Test
    public void test09(){
        spek02.pathParams("first", "api",
                "second", "v1",
                "third","employee",
                "fourth","12");
        Response response=given().spec(spek02).when().get("/{first}/{second}/{third}/{fourth}");
        response.prettyPrint();

        //MATCHERS CLASS İLE

        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("data.employee_name", Matchers.equalTo("Quinn Flynn"),
                       "data.employee_salary",Matchers.equalTo(342000),
                        "data.employee_age", Matchers.equalTo(22));

        //JSON PATH
        JsonPath json= response.jsonPath();
        System.out.println(json.getString("data.employee_name"));
        System.out.println(json.getString("data.employee_age"));
        System.out.println(json.getString("data.employee_salary"));
        System.out.println(json.getInt("data.employee_age"));
        System.out.println(json.getInt("data.employee_salary"));
        //hem string hem de int ile oluyor

        assertEquals("Quinn Flynn", json.getString("data.employee_name"));
        assertEquals(342000, json.getInt("data.employee_salary"));
        assertEquals(22,json.getInt(("data.employee_age")));
    }
}
