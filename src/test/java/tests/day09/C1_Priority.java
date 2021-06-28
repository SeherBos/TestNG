package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C1_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
/*
    1- PRIORITY YAZILMAYAN METHODLAR EN BASTA CALISIR
    2- PRIORITY YAZILAN METHODLAR ISE ; VERILEN ONCELIK SIRASINA GORE CALISIR
    3- EGER HERHANGI BIR PRIORITY VERILMEDIYSE ALFABETIK SIRAYA GORE CALISIR.
 */
    @Test
    public void test01 (){
        System.out.println("Test01 calisti");
    }

    @Test (priority = 10 )
    public void ikinciTest (){
        System.out.println("Ikinci Test calisti");
    }

    @Test (priority = 2 )
    public void yazdimTest (){
        System.out.println("Yazdim Test calisti");
    }


}
