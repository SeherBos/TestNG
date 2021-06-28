package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C3_SoftAssertTest {
/*
    1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
  "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
  "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
  "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
  "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

*/


    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }
//    @AfterMethod
//    public void tearDown(){
//        driver.close();
//    }

    @Test
    public void logIn(){
        driver.get("http://zero.webappsecurity.com/");
        WebElement signIn= driver.findElement(By.xpath("//button[@id='signin_button']"));
        signIn.click();

        WebElement logIn= driver.findElement(By.xpath("//input[@id='user_login']"));
        logIn.sendKeys("username");

        WebElement password= driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        WebElement submitButton= driver.findElement(By.name("submit"));
        submitButton.submit();

        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        WebElement payBillsDropDown= driver.findElement(By.linkText("Pay Bills"));
        payBillsDropDown.click();

        WebElement dropDownCurrency = driver.findElement(By.linkText("Purchase Foreign Currency"));
        dropDownCurrency.click();

        Select select = new Select(dropDownCurrency);
        select.selectByVisibleText("Eurozone (euro)");

        SoftAssert softAssert = new SoftAssert();
        String actual = select.getFirstSelectedOption().getText();
        String expected = "Eurozone (euro)";
        softAssert.assertEquals(actual , expected);

        softAssert.assertAll();





    }
}

