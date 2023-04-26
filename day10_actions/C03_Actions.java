package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/context_menu  git
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Cizili olan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();
        //Alert te cikan yazinin "You selected a context menu" oludugunu test edelim
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //tamam diyerek alert i kapatalim
        driver.switchTo().alert().accept();


        //Elemental Selenium linkine tiklayalim
        String ilksayfaWindowHandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti=driver.getWindowHandles();
        String ikinciWindowHandle="";
        for (String each:handleSeti
             ) {
            if (!each.equals(ikinciWindowHandle)){
                ikinciWindowHandle=each;
            }
        }

        //Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        driver.switchTo().window(ikinciWindowHandle);
        WebElement yaziElementi= driver.findElement(By.tagName("h1"));
        String expectedYazikinci="Elemental Selenium";
        String actualYazikinci=yaziElementi.getText();
        Assert.assertEquals(expectedYazikinci,actualYazikinci);

    }
}
