package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
    WebDriver driver;
    @Before
    public void setUp(){
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/windows git
        driver.get("https://the-internet.herokuapp.com/windows");
        // sayfadiki textin "Opening a new window" old. dogrulayin
        WebElement sayfadakiYaziElementi=driver.findElement(By.xpath("//h3"));
        String expectedYazi="Opening a new window";
        Assert.assertEquals(sayfadakiYaziElementi.getText(),expectedYazi);

        // sayfa basligini(title) "The Internet" old. dogrulayin
        String expectedTitle="The Internet";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        /*
        eger kontrolsüz acilan tab veya window varsa sayfalarin window handle degerlerini
        elde etmem gerekir.
        Öncelikle 2. sayfa acilmadan ilk sayfanin window handle degerini bir String atayalim
         */
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);




        // Click Here tusuna basin
        driver.findElement(By.linkText("Click Here")).click();
        /*
        switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
        biz driver a yeni sayfaya gec demedikce, dirver eski sayfada kalir ve yeni sayfa ile ilgili
        hicbir islem yapamaz. yeni sayfada driver i calistirmak isterseniz
        önce driver i yeni sayfaya yollamalisinz
        */

        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() methodu kullanarak acik olan tum
        sayfalari window handle degerlerini alip bir set e assign ederiz

        ilk sayfanin window handle degerini zaten biliyoruz
        Set deki window handle degerlerini kontrol edip ilk sayfanin handle degerine eşit
        olmayan ikinci sayfanin handle degeridir deriz

         */
        Set<String> windowHandleseti=driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each:windowHandleseti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
        // artik ikinci sayfanin window handle biliyoruz sayfalar arasi geciş yapariz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);



        // acilan yeni pencerenin sayfa basliğinin (title) "New Window" old. dogrulayin
        String expectedikinciTitle="New Window";
        Assert.assertEquals(driver.getTitle(),expectedikinciTitle);
        // sayfadaki textin "New Window" oldugunu dogrulayin
        WebElement ikinciSayfaYaziElementi=driver.findElement(By.xpath("//h3"));
        String expectedikinciYazi="New Window";
        Assert.assertEquals(ikinciSayfaYaziElementi.getText(),expectedikinciYazi);
        // Bir önceki pencereye geri döndükten sonra sayfa başliğinin "The Internet" old. dogrulayin
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        String expectedilkSayfaBaslikYazi="The Internet";
        Assert.assertEquals(driver.getTitle(),expectedilkSayfaBaslikYazi);

    }
}
