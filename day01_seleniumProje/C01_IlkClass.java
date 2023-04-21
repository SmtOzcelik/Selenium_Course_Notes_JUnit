package day01_seleniumProje;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        driver.get("https://www.sahibinden.com");
        Thread.sleep(3000);

        driver.close();

    }
}
