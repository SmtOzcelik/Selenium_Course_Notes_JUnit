package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    Amazon ana sayfaya gidin
    3 farklı test methodu olusturarak asagıdaki görevleri yapin
    1-url in amazon icerdigini test edin.
    2-title in facebook icermedigini test edin
    3-sol ust kosede amazon lagosunun görünürlügünü test edin
     */

    //3 tane test metodu olusturun dedigi icin @AfterClass ve @BeforeClass daha mantıklı
    // baglantıyi saglamak icin static method yapiyoruz unutma

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com"); // butun tesler icin ortak ve bagimsiz calismasi icin buraya aldik
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){

       // 1-url in amazon icerdigini test edin.
        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }
    @Test
    public void test02(){
        //2-title in facebook icermedigini test edin
        String istenmeyenKelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03(){
       // 3-sol ust kosede amazon lagosunun görünürlügünü test edin
        WebElement logoElementi= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
