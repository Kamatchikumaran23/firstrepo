package APItests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
public static void init(){

    RestAssured.baseURI = "http://redisdemo-2.cloud.pcftest.com/product";

}

}
