package APItests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class seleniumRecall {

//    @Test
//    void sample() throws AWTException, InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
//        WebElement Testbox = driver.findElement(By.xpath("//input[@name='q']"));
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_D);
//        robot.keyRelease(KeyEvent.VK_D);
//        Thread.sleep(2000);
//        List<WebElement> List1 = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
//        for (WebElement two:List1 ){
//
//            System.out.println(two.getText());
//
//        }
//        robot.keyPress(KeyEvent.VK_H);
//        robot.keyRelease(KeyEvent.VK_H);
//        Thread.sleep(2000);
//        List<WebElement> List2 = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
//        for (WebElement two:List2 ){
//
//            System.out.println(two.getText());
//
//        }
//        robot.keyPress(KeyEvent.VK_O);
//        robot.keyRelease(KeyEvent.VK_O);
//        Thread.sleep(2000);
//        List<WebElement> List3 = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
//        for (WebElement two:List3 ){
//
//            System.out.println(two.getText());
//
//        }
//        robot.keyPress(KeyEvent.VK_N);
//        robot.keyRelease(KeyEvent.VK_N);
//        Thread.sleep(2000);
//        List<WebElement> List4 = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
//        for (WebElement two:List4 ){
//
//            System.out.println(two.getText());
//
//        }
//        robot.keyPress(KeyEvent.VK_I);
//        robot.keyRelease(KeyEvent.VK_I);
//        List<WebElement> List5 = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
//        for (WebElement two:List5 ){
//            String list5 = two.getText();
//            System.out.println(list5);
//            if(list5.equals("dhoni hairstyle")){
//                two.click();
//            }
//        }
//    }

    @Test
    void two() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://emicalculator.net/");
        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1250)", "");
        List<WebElement> graph = driver.findElements(By.xpath("(//*[name()='g' and @class = 'highcharts-series-group'])[2]/*[local-name()='g']/*[local-name()='rect']"));
        String textXpath = ("//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[local-name()='text']");
        Actions action = new Actions(driver);
        for (WebElement grph : graph){
            action.moveToElement(grph).perform();
            Thread.sleep(500);
            String text = driver.findElement(By.xpath(textXpath)).getText();
            System.out.println(text);
        }
    }

}
