package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // dosya yolunu bir strig degiskene atayalim
        String dosyaYolu="src/reseources/ULKELER.xlsx";
        // FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        // Worksheet objesi olusturun workbook.getSheetAt(index)
        // Row objesi olusturun sheet.getRow(index)
        // Cell objesi olusturun row.getCell(index)
       String actualData= workbook.getSheet("sayfa1")
               .getRow(3)
               .getCell(3)
               .toString();
        System.out.println(actualData);
    }
}
