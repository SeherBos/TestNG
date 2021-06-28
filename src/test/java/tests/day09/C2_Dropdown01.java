package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.select.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C2_Dropdown01 {

    /*
        https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown değerleri(value) yazdırın
        5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
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
    public void index (){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option = new Select(dropDownMenu);
        option.selectByIndex(1);
        System.out.println(option.getFirstSelectedOption().getText());
    }

    @Test
    public void value(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDown);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

    }
    @Test
    public void visible(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownVisibleText = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownVisibleText);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());

    }


    @Test
    public void allList() {

    //    4.Tüm dropdown değerleri(value) yazdırın

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownList = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownList);
        List<WebElement> list = select.getOptions();

        for (WebElement each : list) {
            System.out.println(each.getText());
        }
    }
        @Test
        public void optionsPrint(){
        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
            driver.get("https://the-internet.herokuapp.com/dropdown");
            WebElement getSizel = driver.findElement(By.xpath("//select[@id='dropdown']"));
            Select select = new Select(getSizel);
            select.getOptions();
            System.out.println(select.getOptions().size());

        }







}
