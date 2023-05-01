package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //ingilizce Baskentler sutununu yazdiralim
        String dosyaYolu="src/reseources/ULKELER.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();

        String satirdakiData="";

        for (int i = 0; i <=sonSatir ; i++) {
            satirdakiData=workbook.getSheet("sayfa1").getRow(i).getCell(1).toString();
            System.out.println(satirdakiData);
        }

    }
}
