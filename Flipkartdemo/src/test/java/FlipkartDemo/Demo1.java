package FlipkartDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo1 {

    static int Min = 100000;
    public WebDriver driver;

    //To find the maximum price and to return those product names
    @Test
    public void Step1()  {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Redmi" + Keys.ENTER);
        List<WebElement> Pricelist = driver.findElements(By.xpath("//div[@class='_2kHMtA']//div[@class='_30jeq3 _1_WHN1']"));
        List<Double> price1= new ArrayList<>();
        for (WebElement newpricelist : Pricelist){
            String Prices = newpricelist.getText();
            Integer lst = Integer.parseInt(Prices.replace("₹","").replace(",",""));
            if (lst<Min){
                Min=lst;
            }
        }
        System.out.println(Min);

        List<WebElement> Productlist = driver.findElements(By.xpath("//*[normalize-space()='₹8,999']/../../../preceding-sibling::div/div[@class='_4rR01T']"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (WebElement products:Productlist){
            System.out.println(products.getText());
        }

        }

        //To take the screenshot of the maximum price product
        @Test
        public void Step2() throws IOException, InterruptedException {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Redmi" + Keys.ENTER);
            List<WebElement> Pricelist = driver.findElements(By.xpath("//div[@class='_2kHMtA']//div[@class='_30jeq3 _1_WHN1']"));
            List<Double> price1 = new ArrayList<>();
            for (WebElement newpricelist : Pricelist) {
                String Prices = newpricelist.getText();
                Integer lst = Integer.parseInt(Prices.replace("₹", "").replace(",", ""));
                if (lst < Min) {
                    Min = lst;
                }
            }
            System.out.println(Min);

            List<WebElement> Productimages = driver.findElements(By.xpath("//*[normalize-space()='₹8,799']/../../../preceding-sibling::div/../preceding-sibling::div/*/*/*/img[@class='_396cs4 _3exPp9']"));

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            for (WebElement prdimg : Productimages) {
                Thread.sleep(1000);
                File src = prdimg.getScreenshotAs(OutputType.FILE);
                File dest =  new File("./screenshot"+sdf.format(d)+".png");
                FileUtils.copyFile(src,dest);
                Thread.sleep(2000);

            }
        }



        @Test
        public void step3() throws AWTException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement input = driver.findElement(By.xpath("//input[@name='q']"));
            Robot robo = new Robot();
            robo.keyPress(KeyEvent.VK_D);
            robo.keyRelease(KeyEvent.VK_D);
            Thread.sleep(1000);
            List <String> finallist1=new ArrayList<>();
            List<WebElement> list1 =  driver.findElements(By.xpath("//div[@class='OBMEnb']//div[@class='eIPGRd']"));
            for (WebElement newlist1:list1){
                String lists1 = newlist1.getText();
                finallist1.add(lists1);
            }
            System.out.println(finallist1);
            robo.keyPress(KeyEvent.VK_H);
            robo.keyRelease(KeyEvent.VK_H);
            Thread.sleep(1000);
            List <String> finallist2=new ArrayList<>();
            List<WebElement> list2 =  driver.findElements(By.xpath("//div[@class='OBMEnb']//div[@class='eIPGRd']"));
            for (WebElement newlist2:list2){
                String lists2 = newlist2.getText();
                finallist2.add(lists2);

            }
            System.out.println(finallist2);
            finallist1.retainAll(finallist2);
            System.out.println("=============================Common Elements ==================================");
            System.out.println(finallist1);
            System.out.println("=============================END===============================================");

            robo.keyPress(KeyEvent.VK_O);
            robo.keyRelease(KeyEvent.VK_O);
            Thread.sleep(1000);
            List <String> finallist3=new ArrayList<>();
            List<WebElement> list3 =  driver.findElements(By.xpath("//div[@class='OBMEnb']//div[@class='eIPGRd']"));
            for (WebElement newlist3:list3){
                String lists3 = newlist3.getText();
                finallist3.add(lists3);

            }
            System.out.println(finallist3);
            finallist2.retainAll(finallist3);
            System.out.println("=============================Common Elements===================================");
            System.out.println(finallist2);
            System.out.println("=============================END===============================================");
            robo.keyPress(KeyEvent.VK_N);
            robo.keyRelease(KeyEvent.VK_N);
            Thread.sleep(1000);
            List <String> finallist4=new ArrayList<>();
            List<WebElement> list4 =  driver.findElements(By.xpath("//div[@class='OBMEnb']//div[@class='eIPGRd']"));
            for (WebElement newlist4:list4){
                String lists4 = newlist4.getText();
                finallist4.add(lists4);

            }
            System.out.println(finallist4);
            finallist3.retainAll(finallist4);
            System.out.println("=============================Common Elements ==================================");
            System.out.println(finallist3);
            System.out.println("=============================END===============================================");
            robo.keyPress(KeyEvent.VK_I);
            robo.keyRelease(KeyEvent.VK_I);
            Thread.sleep(1000);
            List <String> finallist5=new ArrayList<>();
            List<WebElement> list5 =  driver.findElements(By.xpath("//div[@class='OBMEnb']//div[@class='eIPGRd']"));
            for (WebElement newlist5:list5){
                String lists5 = newlist5.getText();
                finallist5.add(lists5);

            }
            System.out.println(finallist5);
            finallist4.retainAll(finallist5);
            System.out.println("=============================Common Elements ==================================");
            System.out.println(finallist4);
            System.out.println("=============================END===============================================");
        }


    @BeforeTest
    public void step4() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }
    @Test
    public void step5() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.get("https://www.google.com/");
    }



    }



