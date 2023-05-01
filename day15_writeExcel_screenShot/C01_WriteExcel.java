package day15_writeExcel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    // Adimlari takip ederek 1. satira kadar gidelim
    // 5. hucreye yeni bir cell olusturalim
    // olusturdugumuz hucreye "Nufus" yazdiralim
    // 2. satir nufus kolonuna 150000 yazdiralim
    // 10. satir nufus kolonuna 54000 yazdiraim
    // dosyayi kaydedelim
    // dasyayi kapatalim


    @Test
    public void writeExceltest() throws IOException {
        // Adimlari takip ederek 1. satira kadar gidelim
        String dosyaYolu="src/reseources/ULKELER.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // 5. hucreye yeni bir cell olusturalim olusturdugumuz hucreye "Nufus" yazdiralim
        workbook.getSheet("sayfa1").getRow(0)
                .createCell(4).setCellValue("Nufus");

        // 2. satir nufus kolonuna 150000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);

        // 10. satir nufus kolonuna 54000 yazdiraim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(54000);
        // dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        // dasyayi kapatalim

        fis.close();
        fos.close();
    }
}
