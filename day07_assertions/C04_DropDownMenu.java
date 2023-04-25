package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class C04_DropDownMenu {
    /*
    Amozon a gidip
    dropdowndan books secenegini secip
    java aratalim
    ve arama sonuclarinin java icerdigini test edelim
     */

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
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //dropdwn dan bir option secmek icin 3 adim vardir
        //1-dropdown i locate edelim
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));

        //2-Bir select objesi olusturup parametre olarak da yukaridaki dropDownMenu gir
        Select options=new Select(dropDownMenu);

        //3- Dropdown da var olan optionlar istedigimizi secelim Books secelim
        options.selectByVisibleText ("Books");
        //options.selectByIndex(5);
        //options.selectByValue("search-alias=stripbooks-intl-ship");
        // 3 u de ayni yeri locate yi gösteriyor

        // arama kutusuna Java yazdiralim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin java icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String aranacakKelime="Java";
        Assert.assertTrue(sonucYazisiStr.contains(aranacakKelime));


    }
}
