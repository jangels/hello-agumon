package org.smallfire.java.utils.openBeijingStatistics;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @description
 * @author: Created by lzh
 * @Date: 2018/12/27
 */
@Slf4j
public class ExcelOpen {
    public static void writer(List<OpenType> dataList, String path) throws IOException {
        System.out.println("开始导出excel...");
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("开放北京事项统计");
        HSSFRow firstRow =  sheet.createRow(0);
        firstRow.createCell(0).setCellValue("事项类型");
        firstRow.createCell(1).setCellValue("事项");
        firstRow.createCell(2).setCellValue("子事项");
        int rowscount = 0;
        for (int i = 0; i < dataList.size(); i++) {
            OpenType sheetDTO = dataList.get(i);
            for (int row = 0; row < sheetDTO.getTypeList().size(); row++) {
                TypeList colArray = sheetDTO.getTypeList().get(row);
                for(int j = 0;j<colArray.getChildDetailList().size();j++){
                    rowscount++;
                    HSSFRow rows = sheet.createRow(rowscount);
                    // 向工作表中添加数据
                    rows.createCell(0).setCellValue(sheetDTO.getTypeName());
                    rows.createCell(1).setCellValue(colArray.getTypeDetailName());
                    rows.createCell(2).setCellValue(colArray.getChildDetailList().get(j));
                }
            }
        }
        File xlsFile = new File(path);
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
//        log.info("导出excel完成。");
        System.out.println("导出excel完成。");
    }


    public static void main(String[] args) throws IOException {
//        writer();
    }
}
