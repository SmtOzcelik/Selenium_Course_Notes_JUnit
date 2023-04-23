package day04_xpath_cssLocater;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CssSelector {
    public static void main(String[] args) {
        //1-https://a.testaddressbook.com/sign_in
        //2-Locate email textbox
        //3-Locate password textbox
        //4-Locate sign in button
        //5- i) username:testtechproed@gmail.com ii)Password: Test1234! yaz tıkla

        /*
        CssSelector de xpath() den farkı // ve @ yok yani
        tagName[attribute name='value']
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //1-https://a.testaddressbook.com/sign_in
        driver.get("https://a.testaddressbook.com/sign_in");
        //2-Locate email textbox
        WebElement emailTextBox= driver.findElement(By.cssSelector("#session_email"));
        //3-Locate password textbox
        WebElement passwordTextBox= driver.findElement(By.cssSelector("#session_password"));
        //4-Locate sign in button
        WebElement signInButonu= driver.findElement(By.cssSelector("input[value='Sign in']"));
        //5- i) username:testtechproed@gmail.com ii)Password: Test1234! yaz tıkla
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();
        driver.close();
    }
}
