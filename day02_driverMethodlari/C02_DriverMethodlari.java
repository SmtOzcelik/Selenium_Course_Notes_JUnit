package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        System.out.println("actuel title : "+driver.getTitle());//actuel title : Amazon.com. Spend less. Smile more.
        System.out.println("actuel url :"+driver.getCurrentUrl());//actuel url :https://www.amazon.com/


        driver.close();

    }
}
