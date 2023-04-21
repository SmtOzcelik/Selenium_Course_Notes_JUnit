package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chorem.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.techproeducation.com");
        Thread.sleep(4000);
        driver.close();
    }
}
