package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {
    protected RequestSpecification spek02;

    @Before
    public void setUp(){
        spek02 = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();
    }
}
