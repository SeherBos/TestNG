package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertWindow {


    WebDriver driver;

    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
//  @AfterClass
//    public void tearDown(){
//        driver.close();
//    }


    @Test
    public void alert (){

        /*
            Ilk alert'e tiklayin
            "I am a JS alert" yazisini verify yapin
            OK butonuna tiklayin
            "You successfully clicked an alert" verify yapin
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement firstElement = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        firstElement.click();

//        String alertText = driver.switchTo().alert().getText();
//        Assert.assertEquals(alertText,"I am a JS alert", "Actual   :I am a JS Alert");

        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");
        Assert.assertTrue(result.contains("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert (){
        /*
            Ikinci Alert butonuna tiklayin
            "I am a JS Confirm" yazisini verify yapin
            Calcel butonuna tiklayin
            "successfully ICERMEDIGINI" test edin

         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement secondElement = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        secondElement.click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"I am a JS Confirm");

        driver.switchTo().alert().dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertFalse(result.contains("succesfully"));
    //    Assert.assertEquals(result,"You clicked: Cancel");

    }

    @Test
    public void sendKeysToAlert(){

        /*
            Ucuncu Alert butonuna tiklayin
            "I am a JS Prompt" yazisini verify yapin
            Kutucuga "Team QA3 is rocking!"
            OK butonuna tiklayin
            "You entered: Team QA3 is rocking!" yazisinin ciktigini dogrulayin
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement thirdElement = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        thirdElement.click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"I am a JS prompt");

        driver.switchTo().alert().sendKeys("Seher");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered: Seher");


    }


}
