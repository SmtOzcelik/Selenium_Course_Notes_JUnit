package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTest {
    public static void main(String[] args) {
        /*
        1- https://www.amazon.com  url sine gidin
        2- Basliğın amozon kelimesi icerdigini test edin
        3- url in https://www.amazon.com a esit oldugunu test ediniz
        4- sayfayi kapatın
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();// hata almamak icin tam ekran yapmayi alıskanlık yap


        //1- https://www.amazon.com  url sine gidin
        driver.get("https://www.amazon.com");

        //2- Basliğın amozon kelimesi icerdigini test edin
        String actualTitle=driver.getTitle();
        String arananKelime="Amazon";
        if(actualTitle.contains(arananKelime)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title : "+arananKelime+" yi icermiyor,title testi FAILED");
        }


        //3- url in https://www.amazon.com a esit oldugunu test ediniz
        String actualURL = driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if (actualURL.equals(expectedUrl)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("actual Url: " +actualURL+ " beklenen URL den farklı, test FAILED");
        }

        // 4- sayfayi kapatın
        driver.close();


        System.out.println("actual url");

    }
}
