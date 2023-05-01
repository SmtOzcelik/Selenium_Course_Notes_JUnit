package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JavaScreipt_Executor extends TestBase {
    // amazono gidelim
    // asagidaki sign in butonunu gorununceye kadar js ile scrool yapalim
    // sign in butonuna js ile click yapalim

    @Test
    public void JSExecutorTest() throws InterruptedException {
        // amazono gidelim
        driver.get("https://www.amazon.com");
        // asagidaki sign in butonunu gorununceye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);


        // sign in butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",signInButonu);

       
    }
}
