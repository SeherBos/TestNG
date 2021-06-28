package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C1_MouseActions01 extends TestBase {

    /*
    1- Yeni bir class olusturalim: D14_MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim


     */

    @Test
    public void rightClick(){

        driver.get("https://the-internet.herokuapp.com/context_menu");
//      3- Cizili alan uzerinde sag click yapalim
        // a - ilk once action objesi olusturur
        Actions act = new Actions(driver);
        // b - mouse action yapacagim web elementini locate edilir
        WebElement stripedBox = driver.findElement(By.id("hot-spot"));
        // c - actions objesi ve locate ettigimiz webelementini kullanarak istedigimiz islemi yapalim
        act.contextClick(stripedBox).perform();

//      4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alertText =driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(alertText,expectedText);

//      5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();


//      6- Elemental Selenium linkine tiklayalim

        String firstHandle = driver.getWindowHandle();

        WebElement selenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));

        act.click(selenium).perform();



//      7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(firstHandle);

        String secondHandle ="";
        for(String each : windowHandles){
            if(!firstHandle.equals(each)){
                secondHandle=each;
            }
        }
            driver.switchTo().window(secondHandle);
        WebElement h1 = driver.findElement(By.tagName("h1"));
        String actual = h1.getText();
        String expected = "Elemental Selenium";

        WebElement seleniumText = driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));
        act.moveToElement(seleniumText).perform();

        Assert.assertEquals(actual,expected);

    }


}
