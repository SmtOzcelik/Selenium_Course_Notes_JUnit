package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    //1-https://www.bestbuy.com/ git ve farkli methodlar olusturarak asagıdakileri yap
    //a-sayfa url nin https://www.bestbuy.com/ a esit oldugunu test ediniz
    //b-titleTest => sayfa basliginin "Rest" icermedigini test ediniz
    //c-logoTest => BestBuy logosunun görüntülendigini test ediniz
    //d-FrancaisLinkTest => Fransizca Linkin görüntülendigini test ediniz

    // 4 tane test oldugu icin @AfterClass ve @BeforeClass kullanacağım static unutma

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //a-sayfa url nin https://www.bestbuy.com/ a esit oldugunu test ediniz
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test02(){
        //b-titleTest => sayfa basliginin "Rest" icermedigini test ediniz
        String expectedTitle="Rest";
        Assert.assertFalse(driver.getTitle().contains(expectedTitle));
    }
    @Test
    public void test03(){
        //c-logoTest => BestBuy logosunun görüntülendigini test ediniz
        WebElement bestBuyLogosu= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(bestBuyLogosu.isDisplayed());
    }
    @Test
    public void test04(){
        //d-FrancaisLinkTest => Fransizca Linkin görüntülendigini test ediniz
        WebElement fransizcaLink=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fransizcaLink.isDisplayed());
    }
}
