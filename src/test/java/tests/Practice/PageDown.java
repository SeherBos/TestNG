package tests.Practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class PageDown extends TestBase {

      /*
 1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test
  */

    @Test
    public void pageDownUp(){
        driver.get("http://webdriveruniversity.com/");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).perform();

        String firstPage = driver.getWindowHandle();
        String firstPageTitle = driver.getTitle();


        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();

        Set<String> handles = driver.getWindowHandles();

        String secondPage ="";
        for (String each: handles) {
            if (!each.equals(firstPage)){
                secondPage = each;
            }
        }
        driver.switchTo().window(secondPage);


        Faker fake = new Faker();

        WebElement user = driver.findElement(By.id("text"));
        user.sendKeys(fake.name().firstName());
        act.sendKeys(Keys.TAB).sendKeys(fake.internet().password()).perform();
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();


       String actualAlert = driver.switchTo().alert().getText();
        String expectedAlert ="validation failed";

        Assert.assertEquals(actualAlert,expectedAlert);

        driver.switchTo().alert().accept();
        driver.switchTo().window(firstPage);












    }



}
