package com.qa.pages;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class Login extends TestBase {


    public Login() {
        PageFactory.initElements(driver,this);
    }


public Login step1() {
    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(prop.getProperty("username"));
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
    return this;
}

    public Home step2() {
        driver.findElement(By.xpath("//input[@id='login-button']")).sendKeys(Keys.ENTER);
        return new Home();
    }

}
