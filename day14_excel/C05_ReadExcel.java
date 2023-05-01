package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu="src/reseources/ULKELER.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //sayfa2 ye gidip
        //satir sayisinin 12, kullanilan satir sayisinin ise 10 oldugunu test edin

        int sonSatirIndex=workbook.getSheet("Sayfa2").getLastRowNum();
        int expectedSatirSayisi=12;
        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex+1);

        int kullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi=10;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);




    }
}
