package day04_xpath_cssLocater;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_AmazonSearch {
    public static void main(String[] args) throws InterruptedException {
        //Main method olusturun ve asagidaki görevi tamamlayin
        //1-google web sayfasina gidin. https://www.amazon.com/
        //2-Search(ara) "city bike"
        //3-Amazonda görüntülenen ilgili sonuclarin sayisini yazdirin
        //4-Sonra karşiniza cikan ilk sonucun resmine tıklayin

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1-google web sayfasina gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2-Search(ara) "city bike"
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        //3-Amazonda görüntülenen ilgili sonuclarin sayisini yazdirin
        //sg-col-inner classname yapacam ama 24 tane var bizim 1. ci  +list yap --> 1. çek
        List<WebElement> tumWebElementListesi=driver.findElements(By.className("sg-col-inner"));
        WebElement istenenWebElementi=tumWebElementListesi.get(0);
        System.out.println(istenenWebElementi.getText());// direk yazdiramiyoruz getText() metodunu kullandik

        //4-Sonra karşiniza cikan ilk sonucun resmine tıklayin
        //s-image className icin kullanacagım fakat 24 de 1 ---> 1. sectik
        List<WebElement> urunResimleri=driver.findElements(By.className("s-image"));
        WebElement istenenIlkResim=urunResimleri.get(0);
        istenenIlkResim.click();

        Thread.sleep(1000);
        driver.quit();

    }
}
