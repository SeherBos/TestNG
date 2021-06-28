package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class C2_IFrame {

    WebDriver driver;

    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    @AfterClass
//    public void tearDown(){
//        driver.close();
// }
    /*
    Bir class olusturun: D12_IframeTest
     ● https://the-internet.herokuapp.com/iframe adresine gidin.
     ● Bir metod olusturun: iframeTest
     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.

     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

     */

    @Test
    public void iFrameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
     // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.

        WebElement iFrametext = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(iFrametext.isEnabled());
        System.out.println(iFrametext.getText());

     //     ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textbox =driver.findElement(By.cssSelector(".mce-content-body "));
        textbox.clear();
        textbox.sendKeys("Merhaba Dunya!");

     // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

        driver.switchTo().parentFrame();

        WebElement link= driver.findElement(By.linkText("Elemental Selenium")) ;
        softAssert.assertTrue(link.isDisplayed());
        System.out.println(link.getText());






        softAssert.assertAll();
    }

}
