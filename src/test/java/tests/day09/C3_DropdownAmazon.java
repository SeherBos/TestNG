package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_DropdownAmazon {
/*
        Bir class oluşturun: D10_DropDownAmazon
         https://www.amazon.com/ adresine gidin.
- Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
-Test 2
    1. Kategori menusunden Books secenegini  secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
 */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
//    @AfterMethod
//    public void tearDown(){
//        driver.close();
//    }

    @Test
    public void optionsPrint(){
        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        driver.get("https://www.amazon.com/");
        WebElement getSizelist = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(getSizelist);
        List<WebElement> options = select.getOptions();
        System.out.println(select.getOptions().size());

        int expected = 45;
        int actual = select.getOptions().size();

        Assert.assertEquals(actual,expected," Expected Result did not match");
    }

    @Test
    public void search (){

        driver.get("https://www.amazon.com/");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select((dropDown));

        select.selectByVisibleText("Books");

        WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchbox.sendKeys("Java" + Keys.ENTER);


        WebElement searchResult=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(searchResult.getText());



        Assert.assertTrue(searchResult.getText().contains("Java"));



    }





}
