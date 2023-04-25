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

public class C06_DropDown {
    //https://the-internet.herokuapp.com/dropdown git
    //1-Index kullanarak Secenek 1 i (Option 1) secin ve yazdirin
    //2-Value kullanarak Seçenek 2 yi (Option 2) seçin ve yazdirin
    //3-Visible Text(Görünen metin) kullanarak Seçenek 1 i (Option 1) secin ve yazdirin
    //4-Tum dropdown options yazdirin
    //5-Dropdown un boyutunu bulun,Dropdown da 4 öğe varsa konsolda True,degilse False Yazdirin

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //1-Index kullanarak Secenek 1 i (Option 1) secin ve yazdirin
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(dropDownMenu);
        options.selectByIndex(1);//sectik
        System.out.println(options.getFirstSelectedOption().getText());//Option 1 yazdirdi

    }
    @Test
    public void test02(){
        //2-Value kullanarak Seçenek 2 yi (Option 2) seçin ve yazdirin
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(dropDownMenu);
        options.selectByValue("2");
        System.out.println(options.getFirstSelectedOption().getText());
    }
    @Test
    public void test03(){
        //3-Visible Text(Görünen metin) kullanarak Seçenek 1 i (Option 1) secin ve yazdirin
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(dropDownMenu);
        options.selectByVisibleText("Option 1");
        System.out.println(options.getFirstSelectedOption().getText());
    }
    @Test
    public void test04(){
        //4-Tum dropdown options yazdirin
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(dropDownMenu);
        List<WebElement>optionsList=options.getOptions();
        for (WebElement each:optionsList
             ) {
            System.out.println(each.getText());
        }
    }
    @Test
    public void test05(){
        //5-Dropdown un boyutunu bulun,Dropdown da 4 öğe varsa konsolda True,degilse False Yazdirin
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(dropDownMenu);
        List<WebElement>optionsList=options.getOptions();
        if (optionsList.size()==4){
            System.out.println("true");
        }else {
            System.out.println("false");
        }



    }
}
