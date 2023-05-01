package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExceltesti() throws IOException {
        //input olarak verilen
        //satirNo,sutunNo degerlerini parametre olarak alip
        // o cell deki datayi String olarak bana donduren bir method olusturun

        int satirNo=4;
        int sutunNo=4;

        // donen String in cezayir oldugunu test edin
        String expectedData="Cezayir";

        String actualData=banaDataGetir(sutunNo-1,sutunNo-1);// cünkü excel index ile calişir
        Assert.assertEquals(expectedData,actualData);
    }

    private String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu="src/reseources/ULKELER.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook.getSheet("sayfa1").getRow(satirIndex).getCell(sutunIndex).toString();

        return istenenData;
    }
}
