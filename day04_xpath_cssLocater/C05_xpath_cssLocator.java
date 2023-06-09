package day04_xpath_cssLocater;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_xpath_cssLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        WebElement bostonWE=driver.findElement(By.id("pid6_thumb"));
        WebElement sailorWE=driver.findElement(By.id("pid11_thumb"));
        //Mountie yerini digerlerine göre bulalilim. Boston aşagisinda,soilor un solunda
        WebElement mountie=driver.findElement(RelativeLocator.with(By.tagName("img")).below(bostonWE).toLeftOf(sailorWE));
        System.out.println(mountie.getAttribute("id"));//pid10_thumb
    }

}
