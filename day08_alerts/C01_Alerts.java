package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        /*
        herhangi bir web sitesine gidince
        bir websitesinde herhangi bir islem yaptiginizda ortaya cıkan uyarilara alert diyoruz

        Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilabilir
        bu tur alertlere HTML alert denir ve bunlar icin ekstra islem yapmaya gerek yoktur
        tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz

        Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir.
        java script ler locate edilemezler.
        Selenium da JS alertler icin özel bi yontem gelistirilmistir.
        */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //alert te OK tus bas
        driver.switchTo().alert().accept();
        // result kisminda "You successfully clicked an alert" dest et
        String expectedResult="You successfully clicked an alert";
        WebElement actualResultYazisi= driver.findElement(By.xpath("//p[@id='result']"));
        String actualYazi= actualResultYazisi.getText();
        Assert.assertEquals(expectedResult,actualYazi);

    }

}
