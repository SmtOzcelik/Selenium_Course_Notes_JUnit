package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
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
        //driver.close();
    }

    @Test
    public void test01(){
        // https://thi-internet.herokuapp.com/basic_auth site ye gidildiginda login kısmi locate olumuyrsa
        // site nin vermis oldugu formül e göre HTML ile direk username ve password yazilarak girilir
        // username:admin   password:1234  formul : https://username:password@url
        driver.get("https://admin:admin@thi-internet.herokuapp.com/basic_auth");

    }

}
