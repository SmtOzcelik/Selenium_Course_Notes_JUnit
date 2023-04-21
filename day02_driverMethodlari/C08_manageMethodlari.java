package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.SortedMap;

public class C08_manageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        // maximize iken boyutlari alalim
        System.out.println("maximize konum :"+driver.manage().window().getPosition());
        System.out.println("maximize boyut :"+driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        // fullscreen boyutlari alalim
        System.out.println("fullscreen konum :"+driver.manage().window().getPosition());
        System.out.println("fullscreen boyut :"+driver.manage().window().getSize());

        driver.close();


    }
}
