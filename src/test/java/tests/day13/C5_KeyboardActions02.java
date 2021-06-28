package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C5_KeyboardActions02 extends TestBase {
    /*
    1- Bir Class olusturalim D14_KeyboardActions2
     */

    @Test
    public void pageDown(){

//     2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//     3- video’yu gorecek kadar asagi inin
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
//     4- videoyu izlemek icin Play tusuna basin

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframe);
      driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();






    }

}
