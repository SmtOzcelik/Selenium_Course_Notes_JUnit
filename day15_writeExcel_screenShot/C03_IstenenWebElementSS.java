package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {

    @Test
    public void webElemenetSS() throws IOException {
        // amazon a gidip Nutella aratalim
        // ve sonuc sayisinin oldugu web elementinin fotografini cekelim
        driver.get("https://www.amazon.com");
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucFoto=sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        File kayitYeri=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");

        FileUtils.copyFile(sonucFoto,kayitYeri);

    }
}
