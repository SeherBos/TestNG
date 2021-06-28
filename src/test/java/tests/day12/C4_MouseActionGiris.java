package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import javax.swing.*;
import java.security.Key;

public class C4_MouseActionGiris extends TestBase {

    /*
        https://the-internet.herokuapp.com/iframe adresine git
        "Elemental Selenium" yazisina tikla
        sayfaya kisayol ile gec
        "Sauce Labs" yazisina tikla

     */

    @Test
    public void action (){

        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        WebElement sauceLab = driver.findElement(By.xpath("/html/body/header/div/div/p/a"));
        String expectedLab ="Sauce Labs";





    }



}
