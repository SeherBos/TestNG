package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class IFrame {

    WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

//    @AfterClass
//    public void tearDown(){
//        driver.close();
// }



    @Test
    public void iframe () throws InterruptedException {

        /*
    Bir class olusturun: D12_IframeTest
     ● https://the-internet.herokuapp.com/iframe adresine gidin.
     ● Bir metod olusturun: iframeTest
     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
     */

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(header.isEnabled());
        System.out.println("frame.getText() = " + header.getText());

        WebElement frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frame);

        WebElement textbox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textbox.clear();
        textbox.sendKeys("Inside the frame");

        driver.switchTo().parentFrame();

        String firstTab= driver.getWindowHandle();


        WebElement selenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        soft.assertTrue(selenium.isDisplayed());
        System.out.println(selenium.getText());
        selenium.click();

        // sekmelerin ID numaralari alindi
        Set<String> ids = driver.getWindowHandles();

        String secondTab="";
        for (String eachTab: ids) {
            if (!eachTab.equals(firstTab)){
                secondTab=eachTab;
            }

        }
        // ikinci sekmeye gidildi

        driver.switchTo().window(secondTab);

        // Ikinci sekmede ki Sauca Lab linkine tiklandi
        WebElement lab = driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
        lab.click();

        // tiklanan linkin id'si alindi
        String thirdTab="";
        for (String eachTab: ids) {
            if (!eachTab.equals(firstTab) && !eachTab.equals(secondTab)){
                thirdTab=eachTab;
            }

        }
        // driver acilan ucuncu sekmeye gecti
        driver.switchTo().window(thirdTab);




    }
}
