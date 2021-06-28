package tests.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class KeyboardActions extends TestBase {

    @Test
    public void dragAndDrop(){

        driver.get("https://demoqa.com/droppable");
        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropMe = driver.findElement(By.id("droppable"));

        Actions act = new Actions (driver);
        act.dragAndDrop(dragMe,dropMe).perform();

        WebElement dropped = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String droppedText = dropped.getText();
        String expected = "Dropped!";

        Assert.assertEquals(droppedText,expected);



    }

}
