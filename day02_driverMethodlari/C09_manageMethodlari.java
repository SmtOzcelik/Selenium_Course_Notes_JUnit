package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_manageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    /*
    Ilerde wait konusunu daha genis olarak ele alacağız
    Bir sayfa acılırken ilk basta sayfanin icinde bulunan elementlere göre bir yuklenme süresine ihtiyac vardir
    Veya bir web elementinin kullanilabilmesi icin zamana ihtiyacımız olabilir.
    implicitWait bize sayfanin yuklenmesi ve sayfadaki elementlere ulasim icin beklenecek
    MAXIMUM  sureyi belirleme olanagı tanır
    illa 15 sn beklemeyecek acılmazsa
      */
        driver.close();
    }
}
