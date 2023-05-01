package day14_excel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    // dosya yolunu bir strig degiskene atayalim
    // FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
    // workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim
    // WorkbookFactory.create(fileInputStream)
    // Worksheet objesi olusturun workbook.getSheetAt(index)
    // Row objesi olusturun sheet.getRow(index)
    // Cell objesi olusturun row.getCell(index)


    @Test
    public void readExcelTest() throws IOException {
        // dosya yolunu bir strig degiskene atayalim
        String dosyaYolu="src/reseources/ULKELER.xlsx";
        // FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu);
        // workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        // WorkbookFactory.create(fileInputStream)

        // sheet objesi olusturun workbook.getSheetAt(index)
           Sheet sheet=workbook.getSheet("Sayfa1");
        // Row objesi olusturun sheet.getRow(index)
           Row row=sheet.getRow(3);
        // Cell objesi olusturun row.getCell(index)
           Cell cell =row.getCell(3);

        System.out.println(cell);

        //3. index deki satirin 3.index indeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();   // cell data sini string yaptik ki karşilastiralim
        Assert.assertEquals(expectedData,actualData);

    }
}
