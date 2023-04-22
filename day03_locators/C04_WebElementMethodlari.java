package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElementMethodlari {
    public static void main(String[] args) {
        /*
        1-amazon.com gidip arama kutusunu locate ediniz
        2-Arama kutusunun tagName inin input oldugunu test edin
        3-Arama kutusunun name attribute nun degerinin field-keywords oldugunu test edin
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-amazon.com gidip arama kutusunu locate ediniz
        driver.get("https:www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //2-Arama kutusunun tagName inin input oldugunu test edin
        String expectedTagName="input";
        String actualTagName=aramaKutusu.getTagName();
        if (expectedTagName.equals(actualTagName)){
            System.out.println("TagName tesit PASSED");
        }else {
            System.out.println("TagName testi FAİLED");
        }

        //3-Arama kutusunun name attribute nun degerinin field-keywords oldugunu test edin
        String expectedNameDegeri="field-key";
        String actualNameDegeri=aramaKutusu.getAttribute("name");
        if (expectedNameDegeri.equals(actualNameDegeri)){
            System.out.println("name attribute testi PASSED");
        }else {
            System.out.println("name attribute testi FAİLED");
        }

        driver.quit();





        driver.quit();
    }
}
