package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilitiesTestNG.TestBase;

public class C06_SoftAssert extends TestBase {

    // 1-amazon git
    // 2-title in amazon icerdigini test edelim
    // 3-arama kutusunun erisebilirligini old. test edin
    // 4-arama kutusuna nutella yazip arattirin
    // 5-arama yapildigini test edin
    // 6-arama sonucunu Kutella icerdigini test edin

    @Test
    public void test01() {
        /*
        Softassertion baklangic ve bitis satirlari arasindaki tum assertionlari yapip
        bitis satirina geldiginde buldugu tum hatalari rapor eder.
         */
        //softassert baslangic obje olusturmaktir.
        SoftAssert softAssert=new SoftAssert();

        // 1-amazon git
        driver.get("https://www.amazon.com");
        // 2-title in amazon icerdigini test edelim
        String expectedTitle="amazon";
        softAssert.assertTrue(driver.getTitle().contains(expectedTitle),"amazon icermiyor");
        // 3-arama kutusunun erisebilirligini old. test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erişilemiyor");
        // 4-arama kutusuna nutella yazip arattirin
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // 5-arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");
        // 6-arama sonucunu Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"sonuc yazisi Kutella icermiyor");

        // softAssert e bitis satirini soylemek icin assertAll() kullanilir
        // bu satir yazilmazsa assertion görevi yapilmamis olur
        softAssert.assertAll();

        /*
        Softassert un hata bulsa bile calismaya devam etme ozelligi assertAll() a kadardir.
        Eger assertAll() da failed rapor edilirse calisma durur ve class in kalan kismi calistirilmaz
         */
        System.out.println("assertion larda fail olan olursa, burasi calismaaaaazzzzz");
    }
}
