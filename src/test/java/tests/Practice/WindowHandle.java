package tests.Practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle extends TestBase {


    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> it = tabs.iterator();
        String parent = it.next();
        String child = it.next();
        String child1 = it.next();
        /*driver.switchTo().window(child);
        ArrayList<String> sekmeler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(sekmeler.get(1));
        System.out.println(driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).getText());
        String bos = driver.getWindowHandle();*/
        System.out.println(parent);
        System.out.println(child);
        System.out.println(child1);
    }
}
