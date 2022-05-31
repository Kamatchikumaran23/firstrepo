package com.qa.pages;

import TestBase.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Home extends TestBase {

    public Home UrlValidation() {
        String url = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(url, driver.getCurrentUrl());
        return this;
    }

    public Home Max() {
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> price= new ArrayList<>();
        for(WebElement prce:prices){
            String list = prce.getText();
            Double lst = Double.parseDouble(list.replace("$", ""));
            price.add(lst);
        }
        Double db = price.stream().max(Double::compare).get();
        System.out.println("The Highest price in the list is " +db);
        driver.findElement(By.xpath("//*[normalize-space()='$"+db+"']/following-sibling::button")).click();
        return this;
    }

    public Home Min(){
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> price= new ArrayList<>();
        for(WebElement prce:prices){
            String list = prce.getText();
            Double lst = Double.parseDouble(list.replace("$", ""));
            price.add(lst);
        }
        Double db = price.stream().min(Double::compare).get();
        System.out.println("The Lowest price in the list is " +db);
        driver.findElement(By.xpath("//*[normalize-space()='$"+db+"']/following-sibling::button")).click();
        return this;
    }

    public Home step4() throws IOException {
        WebElement RemoveOption = driver.findElement(By.xpath("//*[text()='Remove']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File src = RemoveOption.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshot/one.png");
        FileUtils.copyFile(src,dest);
        Assert.assertTrue(RemoveOption.isDisplayed());
        return this;
    }
}





