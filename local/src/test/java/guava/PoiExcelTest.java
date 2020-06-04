package guava;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * excel工具类测试
 * <p>
 * Created by lzh on 2019-09-10 20:18:36
 */
@Data
public class PoiExcelTest {
    public final static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testCreateExcel() throws Exception {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("haha");
        HSSFRow title =  sheet.createRow(0);
        title.createCell(0).setCellValue("序号");
        title.createCell(1).setCellValue("姓名");

        for(int i = 1; i<100;i++){
            HSSFRow row =  sheet.createRow(i);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue("刘振华"+i);
       }

        File xlsFile = new File("/Users/liuzhenhua/excel/test.xls");
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        hssfWorkbook.write(xlsStream);

        System.out.println("Excel创建完成.");
    }
}
