package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C2_IsExist extends TestBase {

    @Test
    public void test1(){

        // masaustunuzde flower dosyasinin oldugunu test ediniz.

//        1 - Main path'i string olarak kaydedelim'
        String desktopPath = System.getProperty("user.home") + "/Desktop";

//        2. Dosya yolunu string olarak kaydedelim
        String filePath = desktopPath +"/FLOWER.jpg";

        System.out.println(filePath);

//      3. Assertion yapalim
        Assert.assertTrue(Files.exists(Paths.get(filePath)));



    }

}
