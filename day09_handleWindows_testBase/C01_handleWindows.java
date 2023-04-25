package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

    //1-Amazon a gidin
    //2-Nutella icin arama yaptirin
    //3-ilk urunun resmini tiklayarak farkli bir tab olarak acin
    //4-yeni tabda acilan urunun titleni  yazdirin
    WebDriver driver;
    @Before
    public void setUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01(){
        //1-Amazon a gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHanleDegeri=driver.getWindowHandle();
        /*
        E306F30B2C9677D5F74C41B55EC33BEE bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalari arasi geciste bu window handle degerini kullanir

        eger sayfalar arasinda driver imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("E306F30B2C9677D5F74C41B55EC33BEE");
        bu sayfanin windows handle degerini girerek bu sayfaya gecisi saglayabiliriz

         */
        //2-Nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        //3-ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda driver otamatik olarak olusturulan new tab gecer
        Yeni tab da görevi gercekleştirmek icin adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]")).click();

        //4-yeni tabda acilan urunun titleni  yazdirin
        WebElement urunTitleElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());
        //ilk sayfaya gecip url yazdiralim
        driver.switchTo().window(ilkSayfaHanleDegeri);
        System.out.println(driver.getCurrentUrl());

    }

}
