package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //1-Gerekli yapiyi olusturun ve asagidaki görevi tamamlayin
    //a-https://www.facebook.com git
    //b-"Create an Account" buttonuna basin
    //c-"radio buttons" elementleri locate edin
    //Secili degilse cinsiyet butonundan size uygun olani secin

    //1-Gerekli yapiyi olusturun ve asagidaki görevi tamamlayin
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //a-https://www.facebook.com git
        driver.get("https://www.facebook.com");
        //b-"Create an Account" buttonuna basin
        //bu butonun uzerine gelip sag tus yapamadik kodlari gör sol üst ok tik mavi yap üzerine git
        driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']")).click();
        //c-"radio buttons" elementleri locate edin
        WebElement kadinButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelButton=driver.findElement(By.xpath("//input[@value='-1']"));
        //Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!erkekButton.isSelected()){
            erkekButton.click();
        }
        Thread.sleep(3000);
    }


}
