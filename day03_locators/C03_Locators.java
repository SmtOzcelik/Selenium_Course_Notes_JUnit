package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Locators {
    public static <List> void main(String[] args) {
        /*
        görevleri gercekleştirin
        a. http://a.testaddressbook.com  adresine gidin
        b. sign in butonuna basin
        c.email texbox,possword texbox, and signin button elementlerini locate ediniz.
        d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum ac (sign in) butonunu tıkla
           i.username : testtechproed@gmail.com
           ii.password : Test1234!
        e.Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify)
        f. "Addresses" ve "Sign Out" textlerin görüntülendigini(displayed) dogrulayin(verify)
        g. 3. Sayfada kac tane link oldugunu bulun
         */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      //a. http://a.testaddressbook.com  adresine gidin
        driver.get("a.testaddressbook.com");
        //        b. sign in butonuna basin
        WebElement signInLinki=driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        //        c.email texbox,possword texbox, and signin button elementlerini locate ediniz.
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement passwordTextBox =driver.findElement(By.name("session[password]"));
        WebElement signInButton=driver.findElement(By.name("commit"));

        //        d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum ac (sign in) butonunu tıkla
        //           i.username : testtechproed@gmail.com
        //           ii.password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButton.click();
        //        e.Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify)
        WebElement actualKullaniciAdiElementi=driver.findElement(By.className("navbar-text"));
        System.out.println(actualKullaniciAdiElementi.getText());//getText kullandik cunku string degil direk yazdiralim
        //bir webElementin uzerinde ne yazdiğini gormek istersik webElementIsmi.getText() kullanilir.
        String expectedUserMail="testtechproed@gmail.com";
        if(expectedUserMail.equals(actualKullaniciAdiElementi.getText())){
            System.out.println("Expected kullanici testi PASSED");
        }else {
            System.out.println("Expected kullanici testi FAİLED");
        }
        //        f. "Addresses" ve "Sign Out" textlerin görüntülendigini(displayed) dogrulayin(verify)
        WebElement adressesElement=driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi=driver.findElement(By.linkText("Sign out"));
        if (adressesElement.isDisplayed()) {
            System.out.println("adresses testi PASSED");
        }else {
            System.out.println("adresses testi FAİLED");
        }
        if (signOutElementi.isDisplayed()) {
            System.out.println("signOut testi PASSED");
        }else {
            System.out.println("signOut testi FAİLED");
        }


        //        g. 3. Sayfada kac tane link oldugunu bulun
        //List <WebElement> linkListesi=driver.findElements(By.tagName("a"));
        //System.out.println("sayfadaki link sayisi : "+linkListesi.size());


    }
}
