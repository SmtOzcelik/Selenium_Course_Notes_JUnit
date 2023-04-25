package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    // https://the-internet.herokuapp.com/iframe git
    // bir method olusturun : iframeTest
    //"An IFramet containing..." textinin erisilebilir oldugunu test edin ve konsola yazdir
    // Teşt Box a "Merhaba Dunya!" yazin.
    //TextBox in altinda bulunan "Elemental Selenium" link görünüyor mu dogrula ve konsola yazdir
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        //"An IFramet containing..." textinin erisilebilir oldugunu test edin ve konsola yazdir
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());

        // Teşt Box a "Merhaba Dunya!" yazin.
        //textbox i dogru olarak locate etmemize ragmen driver bulunamadi
        //bunun üzerine HTML kodlari incelenince textbox in aslinda IFrame icerisinde oldugunu görduk
        //bu durumda once Iframe locate edip switchTo() ile o iframe ye gecmeliyiz
        WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);
        WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //TextBox in altinda bulunan "Elemental Selenium" link görünüyor mu dogrula ve konsola yazdir
        //link yazi elementini dogru locate etmemize ragmen yazdirmadi
        // cunku yukarida iframe e gecis yapmistik once ordan cıkmaliyiz
         driver.switchTo().defaultContent();// iframe cık komutu

        WebElement linkYaziElementi= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());
    }
}
