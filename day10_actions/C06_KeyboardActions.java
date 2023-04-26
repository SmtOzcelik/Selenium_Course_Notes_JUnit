package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01() {
        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        //
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate edip
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB İLE dolasarak formu doldurun
        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("taha").sendKeys(Keys.TAB)
                .sendKeys("Usta").sendKeys(Keys.TAB)
                .sendKeys("5456574043").sendKeys(Keys.TAB)
                .sendKeys("ab142790").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("12").sendKeys(Keys.TAB)
                .sendKeys("09").sendKeys(Keys.TAB)
                .sendKeys("1989").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).click().sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .perform();



    }
}
