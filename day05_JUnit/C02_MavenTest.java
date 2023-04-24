package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {

        //1-https://zero.webappsecurity.com git
        //2-sign in button tikla
        //3-login alanina "username" yazdirin
        //4-password alanina "password" yazdirin
        //5-sign in buttonuna tiklayin
        //6-pay bills sayfasina gidin
        //7-amount kismina yatırmak istediginiz herhangi bir miktari yaziniz
        //8-tarih kismina "2020-09-10" yazdirin
        //9-pay buttonuna tıklayin
        //10-"The payment was successfully submitted." mesajinin ciktigini control edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://zero.webappsecurity.com git
        driver.get("https://zero.webappsecurity.com");
        //2-sign in button tikla
        driver.findElement(By.xpath("//button[@id='signin_button']"));
        //3-login alanina "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("user name");
        //4-password alanina "password" yazdirin
        driver.findElement(By.xpath("//inuput[@id='user_password']")).sendKeys("password");
        //5-sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //6-pay bills sayfasina gidin
        //7-amount kismina yatırmak istediginiz herhangi bir miktari yaziniz
        //8-tarih kismina "2020-09-10" yazdirin
        //9-pay buttonuna tıklayin
        //10-"The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement sonucYazisiElement=driver.findElement(By.xpath("//div[@id='alert_content']"));
        if (sonucYazisiElement.isDisplayed()){
            System.out.println("test PASSED");
        }else {
            System.out.println("test FAILED");
        }

        driver.close();
    }
}
