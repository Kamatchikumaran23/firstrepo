package APItests;

import SampleApiPage.pojo;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class sample extends BaseTest{
    public WebDriver driver;

    @Disabled
    @DisplayName("Test case for checking the list")
    @Test
    void getreq() throws IOException {

        ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/sample.spark");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest logger = extent.createTest("Validation Test");
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("");
        response.prettyPrint();
        logger.log(Status.INFO,"Getting the Response");
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        logger.log(Status.PASS, "Verification done");
        System.out.println("====================End====================");
        extent.flush();


    }

    @Disabled
    @DisplayName("Adding the new product to the list")
    @Test
    void PostStringreq(){
        String payload = "{\"id\":23,\"name\":\"RKfrever\",\"qty\":23,\"price\":2323}";
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post()
                .then()
                .statusCode(200);
    }

//    @Disabled
//    @DisplayName("Adding the particular product to the list with pojo (object)")
//    @Test
//    void PostPojoreq(){
//
//        pojo pojo = new pojo();
//        pojo.setId("2309");
//        pojo.setName("RKKN");
//        pojo.setQty("23092306");
//        pojo.setPrice("230906");
//
//        given()
//                .when()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(pojo)
//                .post()
//                .then()
//                .statusCode(200);
//    }

    @Disabled
    @DisplayName("Adding the particular product to the list with pojoFaker")
    @Test
    void PostPojoFakerreq(){

        Faker fake = new Faker();
        pojo pojo = new pojo();
        pojo.setId((fake.number().randomDigitNotZero()));
        pojo.setName(fake.name().fullName());
        pojo.setQty(fake.number().randomDigit());
        pojo.setPrice(fake.number().randomDigitNotZero());

        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(pojo)
                .post()
                .then()
                .statusCode(200);
    }

    @Disabled
    @DisplayName("Adding the particular product to the list")
    @Test
    void getPathParameterreq(){
        Response response =
                given()
                        .pathParams("id",15)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }

    @Disabled
    @DisplayName("Deleting the particular product to the list")
    @Test
    void Delreq() {
        given()
                .when()
                .pathParams("id", 9)
                .contentType(ContentType.JSON)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(200);
    }

    @Disabled
    @DisplayName("Printing the log for request body")
    @Test
    void logreqbody(){

        Faker fake = new Faker();
        pojo pojo = new pojo();
        pojo.setId((fake.number().randomDigitNotZero()));
        pojo.setName(fake.name().fullName());
        pojo.setQty(fake.number().randomDigit());
        pojo.setPrice(fake.number().randomDigitNotZero());

        given()
                .contentType(ContentType.JSON)
                .log()
                .body()
                .when()
                .body(pojo)
                .post()
                .then()
                .statusCode(200);
    }

    @Disabled
    @DisplayName("Printing the all details for the request")
    @Test
    void alllogreqdetails(){

        Faker fake = new Faker();
        pojo pojo = new pojo();
        pojo.setId((fake.number().randomDigitNotZero()));
        pojo.setName(fake.name().fullName());
        pojo.setQty(fake.number().randomDigit());
        pojo.setPrice(fake.number().randomDigitNotZero());

        given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(pojo)
                .post()
                .then()
                .statusCode(200);
    }

    @Disabled
    @DisplayName("Printing the all details for the request")
    @Test
    void logreqdetailsiffails(){

        Faker fake = new Faker();
        pojo pojo = new pojo();
        pojo.setId((fake.number().randomDigitNotZero()));
        pojo.setName(fake.name().fullName());
        pojo.setQty(fake.number().randomDigit());
        pojo.setPrice(fake.number().randomDigitNotZero());

        given()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .when()
                .body(pojo)
                .post()
                .then()
                .statusCode(201);
    }

    @DisplayName("Printing the log details for the response")
    @Test
    void logresponse(){

        given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .log()
                //.headers()
                //.status()
                .body()
                .statusCode(200);

    }




}