package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import Utils.elementUtils;

import java.io.File;
import java.io.IOException;

public class firstPage {

    private By status = By.xpath("//table[@id='instanceInfo']//td[text()='UP']");
    private By id = By.xpath("(//table[@id='instances']//tbody)[3]/tr/td/a");
    private By value = By.xpath("(//table[@id='instances']/tbody)[3]//td");
    private By name = By.xpath("((//table[@id='instances'])[3]/tbody//td)[5]/b");
    private By num = By.xpath("((//table[@id='instances']//tr)[10]/td)[3]");

    private WebDriver driver;
    private elementUtils elementutils;


    public firstPage(WebDriver driver) {
        this.driver = driver;
        elementutils = new elementUtils(this.driver);
    }

    public firstPage getIdValue() {
        String statusId = elementutils.dogetText(id);
        Reporter.log("Test Result: ");
        System.out.println("Test Result: ");
        Reporter.log("StatusId : " + statusId);
        System.out.println("StatusId : " + statusId);
        TakesScreenshot tks = (TakesScreenshot)driver;
        File src = tks.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshot/one.png");
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public firstPage getPageUrl() {
        String pageUrl = elementutils.getPageUrl();
        Reporter.log("URL : " + pageUrl);
        System.out.println("URL : " + pageUrl);
        return this;

    }

    public firstPage getValue() {
        String val = elementutils.dogetText(value);
        Reporter.log("Application : " + val);
        System.out.println("Application : " + val);
        String Expected = ("EUREKA-CLIENT");
        Reporter.log("Expected Application : = " + Expected);
        System.out.println("Expected Application : = " + Expected);
        String Actual = (val);
        Reporter.log("Actual Application : = " + Actual);
        System.out.println("Actual Application : = " + Actual);
        Assert.assertEquals(Actual, Expected);
        return this;
    }

    public firstPage getname() {
        if(elementutils.isElementDisplayed(num)==true) {
            String nam = elementutils.dogetText(name);
            Reporter.log("Application : " + nam);
            System.out.println("Application : " + nam);
            String Expected = ("EUREKA-HYSTRIX");
            Reporter.log("Expected Application : = " + Expected);
            System.out.println("Expected Application : = " + Expected);
            String Actual = (nam);
            Reporter.log("Actual Application : = " + Actual);
            System.out.println("Actual Application : = " + Actual);
            Assert.assertEquals(Actual, Expected);
        }
        return this;
    }


    public firstPage validation() {

        String sts = elementutils.dogetText(status);
        String Expct = ("UP");
        Reporter.log("Expected Result : Status = " + Expct);
        System.out.println("Expected Result : Status = " + Expct);
        String Actl = (sts);
        Reporter.log("Actual Result : Status = " + Actl);
        System.out.println("Actual Result : Status = " + Actl);
        if (Expct.equals(Actl)) {
            Reporter.log("Result : Passed");
            System.out.println("Result : Passed");
        } else {
            Reporter.log("Result : Failed");
            System.out.println("Result : Failed");
        }
        Assert.assertEquals(Actl, Expct);
        return this;
    }
}