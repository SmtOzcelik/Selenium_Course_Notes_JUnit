package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
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
        //1-amazon ana sayfaya gidelim
        //2-url nin amazon icerdigini test edelim
        //3-yeni bir pencere acip bestbuy ana sayfaya gidelim
        //4-title in Best buy icerdigini test edelim
        //5-ilk sayfaya dönüp java aratalim
        //6-arama sonuclarinin java icerdigini test edelim
        //7-yeniden bestbuy in acik oldugu sayfaya gidelim
        //8-logonun gorunurlugunu test edelim

        //1-amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandle=driver.getWindowHandle();
        String expectedUrl="amazon";

        //2-url nin amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));

        //3-yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        //4-title in Best Buy icerdigini test edelim
        String expectedTitle="Best Buy";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
        String ikinciSayfaWindowHandle=driver.getWindowHandle();

        //5-ilk sayfaya dönüp java aratalim
        driver.switchTo().window(ilkSayfaWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //6-arama sonuclarinin java icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aradigimizKelime="Java";
        Assert.assertTrue(sonucYaziElementi.getText().contains(aradigimizKelime));

        //7-yeniden bestbuy in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandle);

        //8-logonun gorunurlugunu test edelim
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }
}
