package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    1-Amazon anasayfa gidip dropdown menuden books u secelim
    sectigimiz option i yazdiralim
    2-optionlari hepsini yazdir
    3-dropdown daki opsiyonlarin toplam sayisinin 28 oldugunu test edin
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
       WebElement dropDownMenu= driver.findElement(By.id("searchDropdownBox"));
        Select options=new Select(dropDownMenu);
        options.selectByVisibleText("Books");
        // bir dropdown ile calisiyorken, son secilen optiona ulasmak isterseniz
        //options.getFirstSelectedOption() methodunu kullanmalisiniz
        //bu method bize webelement döndürür
        //uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir
        System.out.println(options.getFirstSelectedOption().getText());


        List<WebElement> optionList=options.getOptions();

        //2-optionlari hepsini yazdir
        for (WebElement each:optionList
             ) {
            System.out.println(each.getText());

        }
        // 3-dropdown daki opsiyonlarin toplam sayisinin 20 oldugunu test edin
        int actualOptionSayisi=optionList.size();
        int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }
}
