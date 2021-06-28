package tests.day14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C3_FileDownload extends TestBase {

    /*
    1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
    2. Iki tane metod oluşturun : isExist() ve downloadTest()
    3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
     - https://the-internet.herokuapp.com/download adresine gidelim.
     - image1.jpg dosyasını indirelim
    4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
     */

    @Test
    public void downloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("code.txt")).click();
        Thread.sleep(2000);

    }

    @Test
    public void isExist(){

    String mainPath =  System.getProperty("user.home");
    String filePath = mainPath + "/Downloads/code.txt";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }


}
