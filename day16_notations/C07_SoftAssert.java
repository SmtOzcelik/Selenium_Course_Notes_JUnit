package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilitiesTestNG.TestBase;

import java.util.List;

public class C07_SoftAssert extends TestBase {
    // 1-https://zero.webappsecurity.com adresine gidin
    // 2-Sign in butonuna basin
    // 3-Login kutusuna username yazin
    // 4-Password kismina password yazin
    // 5-Sign in tusuna basin
    // 6-Online banking menusu icinde Pay Bills sayfasina gidin
    // 7-Purchase Foreign Currency tusuna basin
    // 8-Currency dop down menusunden Eurozone u secin
    // 9-soft assert kullanarak Eurozone (Euro) secildigini test edin
    //10-soft assert kullanarak DropDown listesinin su secenekler oldugunu test edin

    @Test
    public void test01() throws InterruptedException {
        // 1-http://zero.webappsecurity.com adresine gidin
        driver.get("http://zero.webappsecurity.com");
        // 2-Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        // 3-Login kutusuna username yazin
        WebElement loginKutusuElementi=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusuElementi.click();
        loginKutusuElementi.sendKeys("username");

        // 4-Password kismina password yazin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("password").perform();

        // 5-Sign in tusuna basin
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        // 6-Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[teşt()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        // 7-Purchase Foreign Currency tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        // 8-Currency dop down menusunden Eurozone u secin
        WebElement ddo= driver.findElement(By.xpath("//select[@name='currency']"));
        Select select=new Select(ddo);
        select.selectByVisibleText("Eurozone (euro)");
        // 9-soft assert kullanarak Eurozone (Euro) secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String secilenOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (Euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"secilen option uygun degil");
        //10-soft assert kullanarak DropDown listesinin su secenekler oldugunu test edin
        List<WebElement> optionList=select.getOptions();
    }
}
