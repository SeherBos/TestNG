package tests.day13;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C3_MouseAction03 extends TestBase {
    /*

    1- https://www.facebook.com adresine gidelim
    2-Yeni hesap olustur butonuna basiniz
    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    4- Kaydol tusuna basalim
     */

    @Test
    public void test1() throws InterruptedException {
        Faker faker = new Faker();
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
        WebElement nameBox= driver.findElement(By.name("firstname"));

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        Actions act = new Actions(driver);
        act.click(nameBox).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(password).sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);



    }


}
