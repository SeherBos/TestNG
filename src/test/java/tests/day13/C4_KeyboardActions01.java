package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C4_KeyboardActions01 extends TestBase {

    /*
    1- Bir Class olusturalim D14_KeyboardActions1
    2- https://www.amazon.com sayfasina gidelim
    3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    4- aramanin dogru yapildigini test edin
     */
    @Test
    public void test1(){

        driver.get("https://www.amazon.com");

        Actions act = new Actions (driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        act.click(searchBox).
                sendKeys("samsung ").
                keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("71").sendKeys(Keys.ENTER).perform();

        String actualTitle = driver.getTitle();
        String expected = "samsung A71";

        Assert.assertTrue(actualTitle.contains(expected));




    }


}
