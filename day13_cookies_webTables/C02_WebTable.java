package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {

    @Test
    public void webTabel() {
        // login() metodu olustusturun ve oturum acin
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //         username : manage   password : Manager1!
            girisYap();
        // table() metodu olusturun
        //    *) Tum table body sinin boyutunu(sutun sayisini) bulun
        List<WebElement>sutunBasliklariListesi=driver.findElements(By.xpath("//thread//tr[1]/th"));
        System.out.println(sutunBasliklariListesi.size());
        //    *) Table daki tum body'I ve başliklari(headers) konsolda yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        // printRows() metodu olusturun//tr
        //    *) table body sinde bulunan toplam satir(row) sayisini bulun
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirlarListesi.size());

        //    *) table body sinde bulunan satirlari(rows) konsolda yazdirin
        for (WebElement each:satirlarListesi
             ) {
            System.out.println(each.getText());
        }
        //    *) 4.satirdaki(row) elementleri konsolda yazdirin
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//td"));
        for (WebElement each:cellList
             ) {
            System.out.println(each.getText());
        }

        // email basligindaki tum elementleri konsalda yazdir
        List<WebElement> basliklariListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklariListesi.size(); i++) {
            if (basliklariListesi.get(i).getText().equals("Email")) {
                emailSutunNo=i;
            }

        }
        List<WebElement>EmailSutunListesi=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each:satirlarListesi
             ) {
            System.out.println(each.getText());
        }

    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions=new Actions(driver);
        WebElement username= driver.findElement(By.id("UserName"));
        actions.click(username).sendKeys("maneger").sendKeys(Keys.TAB)
                .sendKeys("Maneger1!").sendKeys(Keys.ENTER).perform();

    }
}
