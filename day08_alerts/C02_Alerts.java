package day08_alerts;

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

public class C02_Alerts {

    //https://the-internet.herokuapp.com/javascript_alerts git
    //1- 1.button tikla uyaridaki OK tikla ve result mesaji "You successfully clicked an alert" oldugunu test et
    //2- 2.button tikla uyaridaki OK tikla ve "successfuly" icermediğini test ediniz
    //3- 3.button tikla uyaridaki metin kutusuna isminizi yazin OK butonuna tiklayin
    //   ve isminizi result kisminda oldugunu görüntülendiğini doğrulayin

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
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //1- 1.button tikla uyaridaki OK tikla ve result mesaji "You successfully clicked an alert" oldugunu test et
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement resultMesajElementi= driver.findElement(By.xpath("//p[@id='result']"));
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,resultMesajElementi.getText());
        //2- 2.button tikla uyaridaki OK tikla ve "successfuly" icermediğini test ediniz
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();
        WebElement resultMesajElement= driver.findElement(By.xpath("//*[text()='You clicked: Ok']"));
        String expectedResult2="successfuly";
        Assert.assertFalse(resultMesajElement.getText().contains(expectedResult2));
        //3- 3.button tikla uyaridaki metin kutusuna isminizi yazin OK butonuna tiklayin
        //   ve isminizi result kisminda oldugunu görüntülendiğini doğrulayin
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("samet");
        driver.switchTo().alert().accept();
        WebElement actualResultElementi= driver.findElement(By.xpath("//*[text()='You entered: samet']"));
        String expectedResultYazisi="samet";
        Assert.assertTrue(actualResultElementi.getText().contains(expectedResultYazisi));

    }
}
