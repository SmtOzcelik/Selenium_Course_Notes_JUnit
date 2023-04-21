package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_navigate {
    public static void main(String[] args) throws InterruptedException {

        /*
        Eger testimiz sirasinda birden fazla sayfa arasında ileri geri hareket edeceksek
        driver.get() yerine driver.navigate.to() methodunu kullanırız.
        Sonrasinda navigate.forward()(ileri) or back()(geri) or refresh()(yenile) kullanilir
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);

        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(2000);

        //amozan a geri dönelim
        driver.navigate().back();
        Thread.sleep(2000);

        //yeniden facebook a gidelim
        driver.navigate().forward();
        Thread.sleep(2000);

        //sayfayi refresh(yenile)
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.close();





    }
}
