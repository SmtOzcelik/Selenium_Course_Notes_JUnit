package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_getPageSource {
    public static void main(String[] args) {
        //Amazon sitesine gidip kaynak kodlarinda "Gateway" yazdığını test edin

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        String sayfaKaynakKodlari=driver.getPageSource();// butun kaynak kodları atadık
        String aranacakKelime="Gateway";
        if(sayfaKaynakKodlari.contains(aranacakKelime)){
            System.out.println("Kaynak Kodu Testi PASSED");
        }else {
            System.out.println("Kaynak kodlarinda " +aranacakKelime+" yok, test FAILED");
        }

        driver.close();


    }
}
