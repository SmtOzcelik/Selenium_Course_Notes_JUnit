package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    //1-https://automationpractice.com/index.php  git   çalismiyor
    //2-sign in butonuna basalim
    //3-email kutusuna @isareti olmayan bir mail yazip enter bastigimizda
    //  "Invalid email address" uyarisinin ciktigini test edelim

    // tek test oldugu icin

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
        //driver.close();
    }
    @Test
    public void test01(){

        driver.get("https://automationpractice.com/index.php");
        //2-sign in butonuna basalim
        driver.findElement(By.xpath("//automationpractice.com/index.php")).click();
        //3-email kutusuna @isareti olmayan bir mail yazip enter bastigimizda
        //  "Invalid email address" uyarisinin ciktigini test edelim
        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com"+ Keys.ENTER);
        WebElement uyariYazisiElementi= driver.findElement(By.xpath("//*[text()='Invalid email address']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());

    }
}
