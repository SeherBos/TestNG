package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_IFramePlay {

    WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

//    @AfterClass
//    public void tearDown(){
//        driver.close();
// }

    @Test

//    public void iframePlay(){
//        driver.get("https://html.com/tags/iframe/");
//        // iframe'i locate ettik
//        WebElement iFrameWE = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
//        // iframe'e gecis yaptik
//        driver.switchTo().frame(iFrameWE);
//        // Video'nun Play butonu'nu locate ettik ve tikladik
//
//        //TIKLANMASI ICIN SCROLL DOWN YAPIP BEKLEMEK LAZIM
//
//        WebElement videoPlayButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
//        videoPlayButton.click();
//        // iframe'den cikis yaptik
//        driver.switchTo().defaultContent();
//
//    }

    public void test01() {
        driver.get("https://html.com/tags/iframe/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

    }

}
