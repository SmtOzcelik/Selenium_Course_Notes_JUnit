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

public class C02_CheckBox {
    //1.Gerekli yapiyi olusturun ve asagidaki göreve tamamlayin
    //a.https://theinternet.herokuapp.com/checkboxes git
    //b.Checkbox1 ve checkbox2 elementlerini locate edin.
    //c.Checkbox1 secili degilse onay kutusunu tıklayin
    //d.Checkbox2 secili degilse onay kutusunu tıklayin

    WebDriver driver;
    //1.Gerekli yapiyi olusturun ve asagidaki göreve tamamlayin
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //a.https://theinternet.herokuapp.com/checkboxes git
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b.Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //c.Checkbox1 secili degilse onay kutusunu tıklayin
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        //d.Checkbox2 secili degilse onay kutusunu tıklayin
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }
    }

