package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUplod extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload   git
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basin
        //Upload butonuna basalim
        /*
        bu islemi selenium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetişir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir
         */
        // 1. adim Choose File butonunu locate edelim
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));
        // 2. adim yuklenecek dosyanin dosya yolunu olusturalim
        // biz masaustundeki dosyayi yukleyelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Dekstop\\text";
        String yuklenecekDosya=farkliKisim+ortakKisim;
        //3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosya);

        //upload butonuna basalim
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();

        //"File Upoaded!" textinin görüntülendigini test edelim
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());

    }
}
