package tests.day14;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_BilgisayardakiDosyalaraUlasma extends TestBase {

    @Test
    public void test01(){
        // user.dir = kullandigimiz satirin ana yolunu verir
        System.out.println(System.getProperty("user.dir")); //      /Users/christian/com.batch13TestNg

        // ana yolu verir
        System.out.println(System.getProperty("user.home")); //     /Users/christian

        // masaustune ulasmak istersek eger
        String desktopFilePath = System.getProperty("user.home") + "/Desktop"; //     /Users/christian
        System.out.println(desktopFilePath);







    }



}
