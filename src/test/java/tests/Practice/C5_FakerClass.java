package tests.Practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C5_FakerClass extends TestBase {
    /*
    1."https://facebook.com" Adresine gidin
2.“create new account” butonuna basin
3.“firstName” giris kutusuna bir isim yazin
4.“surname” giris kutusuna bir soyisim yazin
5.“email” giris kutusuna bir email yazin
6.“email” onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
     */

    @Test
    public void test1() throws InterruptedException {
        Faker faker = new Faker();
        Actions act = new Actions(driver);



        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
        WebElement nameBox= driver.findElement(By.name("firstname"));

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        act.click(nameBox).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(password).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("OCT").
                sendKeys(Keys.TAB).sendKeys("5").
                sendKeys(Keys.TAB).sendKeys("1994").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).    // TAB ile buttonlara tiklanmayabilir o yuzden arrow ile denedik.
                sendKeys(Keys.ARROW_LEFT).     // Female secmesi icin once Right sonra Left yaptik
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        Thread.sleep(3000);



    }
}
