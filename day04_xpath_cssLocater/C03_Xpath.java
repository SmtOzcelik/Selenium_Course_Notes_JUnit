package day04_xpath_cssLocater;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath {
    public static void main(String[] args) {
        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine git
        //2-Add Element butonuna basin
        //3-Delete butonu nun gorunur oldugunu test edin
        //4-Delete tusuna basin
        //5-"Add/Remove Elements" yazisinin gorunur oldugunu test edin

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine git
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2-Add Element butonuna basin --> Eger 1 kez kullanacaksak tek adimda yaz.click yap
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        //3-Delete butonu nun gorunur oldugunu test edin
        WebElement deleteButon= driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deleteButon.isDisplayed()){
            System.out.println("Delete butonu testi PASSED");
        }else {
            System.out.println("Delete butonu testi FAILED");
        }

        //4-Delete tusuna basin
        deleteButon.click();
        //5-"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveYaziElementi=driver.findElement(By.xpath("//h3")); // icine sadece tag namede yazilabilir
        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("addRemove yazisi testi PASSED");
        }else {
            System.out.println("addRemove yazisi testi FAILED");
        }
        driver.quit();

    }
}
