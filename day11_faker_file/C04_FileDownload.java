package day11_faker_file;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1- https://the-internet.herokuapp.com/download  git
        driver.get("https://the-internet.herokuapp.com/download");
        //2- testing.pdf dosyasini indirelim
        WebElement testingLinki= driver.findElement(By.xpath("//a[text()='testing.pdf']"));
        testingLinki.click();
        Thread.sleep(4000);
        //3- dosyanin basari ile indirilip indirilmediğini test edelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\testing.pdf";

        String arananDosyaYolu=farkliKisim+ortakKisim;
        // geriye  o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));


    }
}
