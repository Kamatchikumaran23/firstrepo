package Sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class first {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.in/search?fromCityName=Bangalore&fromCityId=122&toCityName=Goa&toCityId=210&onward=20-Apr-2022&opId=0&busType=Any#");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[1]")).click();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//canvas[@data-type='lower']"))).perform();
        // driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
        WebElement ele = driver.findElement(By.xpath("//iframe[@src='https://bid.g.doubleclick.net/xbbe/pixel?d=KAE']//following-sibling::div"));
        String ele1 = ele.getText();
        System.out.println(ele1);

    }
}
