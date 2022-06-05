package test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import Pages.firstPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Factory.driverFactory;
import Utils.elementUtils;

public class BaseTest {

    public driverFactory driverfactory;
    public WebDriver driver;
    public Properties prop;
    public elementUtils elementutils;
    public Pages.firstPage firstPage;

    @BeforeTest
    public void setup() {
        driverfactory = new driverFactory();
        prop = driverfactory.init_prop();
        driver = driverfactory.init_driver(prop);
        elementutils = new elementUtils(driver);
        firstPage = new firstPage(driver);
    }

    @AfterTest
    public void tearDown() {
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.close();
    }

}
