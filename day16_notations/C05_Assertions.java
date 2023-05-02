package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilitiesTestNG.TestBase;

public class C05_Assertions extends TestBase {
    // 1-amazon git
    // 2-title in amazon icerdigini test edelim
    // 3-arama kutusunun erisebilirligini old. test edin
    // 4-arama kutusuna nutella yazip arattirin
    // 5-arama yapildigini test edin
    // 6-arama sonucunu Nutella icerdigini test edin

    @Test
    public void test01() {
        // 1-amazon git
        driver.get("https://www.amazon.com");
        // 2-title in Amazon icerdigini test edelim
        String expectedTitle="amazon";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
        // 3-arama kutusunun erisebilirligini old. test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        // 4-arama kutusuna nutella yazip arattirin
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // 5-arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());
        // 6-arama sonucunu Nutella icerdigini test edin
        Assert.assertTrue(sonucYaziElementi.getText().contains("Kutella"));
    }
}
