package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C2_HandleWindows01 extends TestBase {

    @Test
    public void test01 (){
        driver.get("https://the-internet.herokuapp.com/iframe");

        // click yapilmadan window'un handle'ini alalim
        String firstPageHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        // click yaptiktan sonra tum sayfalarin handle (id) degerlerini alalim

        Set<String> handleList = driver.getWindowHandles();

        // elimizde icinde 2 handle degeri bulunan bir set var
        // bunlardan biri ilk sayfanin degeri ama ikinci sayfanin handle degerini nasil bulabilirim ? Boyle;

        String secondPageHandle="";
        for (String each : handleList){
            if(!each.equals(firstPageHandle)){
                secondPageHandle=each;
            }
        }

            driver.switchTo().window(secondPageHandle);

        System.out.println("CLICK YAPILDI - YENI SEKME ACILDI");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());

        WebElement sourceLab = driver.findElement(By.xpath("//a[text()='Sauce Labs']"));

        System.out.println("sourceLab.getText() = " + sourceLab.getText());


    }
}
