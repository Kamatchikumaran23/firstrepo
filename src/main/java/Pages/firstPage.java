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

    private By status = By.xpath("");
    private By id = By.xpath("");
    private By value = By.xpath("");

    private WebDriver driver;
    private elementUtils elementutils;


    public firstPage(WebDriver driver) {
        this.driver = driver;
        elementutils = new elementUtils(this.driver);
    }

    public firstPage getIdValue() {

        return this;
    }

    public firstPage getPageUrl() {

        return this;

    }

    public firstPage getValue() {

        return this;
    }

    public firstPage getname() {

        return this;
    }


    public firstPage validation() {


        return this;
    }
}