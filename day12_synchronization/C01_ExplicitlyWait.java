package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    //1-iki tane method olusturun : implicitWait , explicitWait() asagidaki adimleri test et
    //2-https://the-internet.herokuapp.com/dynamic_controls  git
    //3-Remove butonuna basin
    //4-"It's gone!" mesajinin görüntülendiğini dogrulayin
    //5- Add buttonuna basin
    //6-It's back mesajinin gorundugunu test edin

    ////p[@id='message']
    @Test
    public void implicitWaitTesit() {
        //2-https://the-internet.herokuapp.com/dynamic_controls  git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //3-Remove butonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //4-"It's gone!" mesajinin görüntülendiğini dogrulayin
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        //5- Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //6-It's back mesajinin gorundugunu test edin
        WebElement mesajElementi= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(mesajElementi.isDisplayed());

    }

    @Test
    public void explicitlywaitTesti() {
        //2-https://the-internet.herokuapp.com/dynamic_controls  git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //3-Remove butonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //4-"It's gone!" mesajinin görüntülendiğini dogrulayin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        yazinin gorunur olmasini beklerken yazinin locatini kullanmak sorun oluşturur
        cunku görünmeyen bi yazinin mumukun olmayabilir (HTML yazan dev. farkli uygulama yapabili)
        bu durumda bekleme işlemi ve locate birlikte yapmaliyiz
         */
        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        //5- Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //6-It's back mesajinin gorundugunu test edin
        WebElement mesajElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(mesajElementi.isDisplayed());
    }
}
