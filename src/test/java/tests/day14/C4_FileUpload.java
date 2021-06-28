package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C4_FileUpload extends TestBase {

    /*
    1.Tests packagenin altina bir class oluşturun : D14_UploadFile
    2.https://the-internet.herokuapp.com/upload adresine gidelim
    3.chooseFile butonuna basalim
    4.Yuklemek istediginiz dosyayi secelim.
    5.Upload butonuna basalim.
    6.“File Uploaded!” textinin goruntulendigini test edelim.
     */

@Test
    public void upload (){
    driver.get("https://the-internet.herokuapp.com/upload");

    // 1- Dosya sec butonu locate edelim
    WebElement chooseFile = driver.findElement(By.id("file-upload"));

    // 2- Yuklemek istedigimiz dosyanin dosya yolunu kaydedin
    String filePath = System.getProperty("user.home")+"/Desktop/FLOWER.jpg";

    // 3- SendKeys ile dosyayi secelim
    chooseFile.sendKeys(filePath);

    WebElement uploadButton = driver.findElement(By.id("file-submit"));
    uploadButton.click();

    WebElement uploadedText = driver.findElement(By.tagName("h3"));

   Assert.assertTrue(uploadedText.isDisplayed());


    /*
       -  Eger bir sayfada birden fazla Assert.assertTrue yapilacaksa , bastaki ASSERT. yazisini sileriz
             assertTrue(uploadedText.isDisplayed()); == gibi
       -  ardindan CTE veren kismin ustune gidip ALT+ENTER yapip import edersek eger bir sonraki assert islemleriin basina
             surekli Assert. yazmak zorunda kalmayiz.
       -  Eger ayni sayfada assertTrue,assertFalse,assertEquals yapilacak ise ,
            import kismina gidilir
            import org.testng.Assert; yazan kismi
            import org.testng.*; == ile update edilir

       *** Ayni islem SoftAssert icin yapilmaz cunku onun icin obje olusturulmasi gerekir.
     */


}

}
