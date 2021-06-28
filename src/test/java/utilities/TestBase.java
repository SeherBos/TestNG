package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    // public : herkes ulasabilir
    // protected ; ayni package veya child claslar ulasabilir
    // default ;package private , ayni package icinde kullanilir , bir sey yazmayinca default kabul edilir
    // private ; sadece class icinde kullanabiliriz

    protected WebDriver driver;

    @BeforeMethod
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

//    @AfterMethod
//    public void tearDown (){
//        driver.close();
//    }

}
