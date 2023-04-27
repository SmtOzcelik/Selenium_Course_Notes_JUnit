package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {
    // 1- method olusturun : isEnabled()
    // 2- https://the-internet.herokuapp.com/dynamic_controls
    // 3- TextBox in etkin olmadiğini(enabled) dogrulayin
    // 4- Enable butonuna tıklayin ve textbox etkin oluncaya kadar bekleyin
    // 5- "Its's enable!" mesajinin görüntülendiğini dogrulayin
    //6-Textbox in etkin oldugunu(enabled) dogrulayin


    @Test
    public void EnabledTest01() {
        // 2- https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 3- TextBox in etkin olmadiğini(enabled) dogrulayin
        WebElement enableKusutu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKusutu.isEnabled());
        // 4- Enable butonuna tıklayin ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enableKusutu));

        // 5- "Its's enable!" mesajinin görüntülendiğini dogrulayin
        WebElement mesajElementi= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(mesajElementi.isDisplayed());
        //6-Textbox in etkin oldugunu(enabled) dogrulayin
        Assert.assertTrue(enableKusutu.isEnabled());

    }
}
