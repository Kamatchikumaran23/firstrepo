package stepDef;

import TestBase.TestBase;
import com.qa.pages.Home;
import com.qa.pages.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Addtocart extends TestBase {
    public WebDriver driver;
    public Login login;
    public Home home;


    @Given("User should login with the url")
    public void step1() {
        TestBase.init_driver();
    }


    @When("the user enters the username and password")
    public void step2() {
        login = new Login();
        login.step1();
    }

    @Then("Click on the login button")
    public void step3() {
        login.step2();
    }

    @And("check the url matches with the expected one")
    public void step4() {
        home = new Home();
        home.UrlValidation();
    }

    @Then("To get the Maximum price from the listed price")
    public void step5() {
        home.Max();
    }

    @Then("To get the Minimum price from the listed price")
    public void step6() {
        home.Min();
    }

    @And("Validation of the button using assertion")
    public void step7() throws IOException {
        home.step4();
    }
}


