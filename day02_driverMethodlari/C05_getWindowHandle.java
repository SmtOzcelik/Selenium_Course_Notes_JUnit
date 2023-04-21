package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_getWindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println(driver.getWindowHandle());
        //3067BCAC20345B32F57F34973A31EC94 acılan her pencerin hash kodu,her seferinde yeni kod uretir


    }
}
