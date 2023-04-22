package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//standart yaziyoruz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//standart yazıyoruz


        // Amozon a gidip nutella aratalım
        driver.get("https://www.amazon.com");
        //findElement(By...locator) --> istedigimiz web elementini bize döndürür
        //bizde o webelementini kullanmak icin bir objeye assign ederiz
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //herhangi bir webelementine istedigimiz yaziyi yollamak istersik

        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);



        Thread.sleep(3000);
        driver.close();


    }
}
