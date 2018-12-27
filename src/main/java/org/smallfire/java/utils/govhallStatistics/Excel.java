package org.smallfire.java.utils.govhallStatistics;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: Created by 韩晓明
 * @Date: 2018/8/23 10:17
 */
public class Excel {
    public static void writer(List<ExcelSheetDTO> dataList, String path) throws IOException {
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();

        for (int i = 0; i < dataList.size(); i++) {
            ExcelSheetDTO sheetDTO = dataList.get(i);
            // 创建工作表
            HSSFSheet sheet = workbook.createSheet(sheetDTO.getSheetName());
            for (int row = 0; row < sheetDTO.getData().size(); row++) {
                ArrayList<String> colArray = sheetDTO.getData().get(row);
                HSSFRow rows = sheet.createRow(row);
                for (int col = 0; col < colArray.size(); col++) {
                    // 向工作表中添加数据
                    rows.createCell(col).setCellValue(colArray.get(col));
                }
            }
        }
        File xlsFile = new File(path);
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
    }

    public static void main(String[] args) throws IOException {
//        writer();
    }
}
