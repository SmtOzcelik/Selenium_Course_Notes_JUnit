package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C001_Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Amozon a gidip nutella aratalım name ile yapalim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.name("field-keywords"));

        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        Thread.sleep(3000);
        driver.quit();
    }
}
