package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ReqresinBaseUrl {
    protected RequestSpecification spec01;
    @Before
    public void setUp(){
        spec01=new RequestSpecBuilder().setBaseUri("https://reqres.in").build();

    }
}
