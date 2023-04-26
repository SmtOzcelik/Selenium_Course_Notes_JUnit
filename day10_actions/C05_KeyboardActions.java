package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");


        //1- önce arama kusutuna click yapip
        //2- sonra harf harf Nutella yazisini yazdiralim
        //3- sonra da ENTER tuşuna basalim
        Actions actions=new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).keyDown(Keys.SHIFT).sendKeys("n").
                keyUp(Keys.SHIFT).sendKeys("u").sendKeys("t").sendKeys("e").
                sendKeys("l").sendKeys("l").sendKeys("a").sendKeys(Keys.ENTER).perform();





        Thread.sleep(2000);
    }
}
