package org.smallfire.java.utils.openBeijingStatistics;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class HuijiyeUtils {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("/Users/liuzhenhua/excel/20190910-1.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        int num = 0;
        for (int i = 0; i < 3; i++) {
            HSSFSheet sheetAt = hssfWorkbook.getSheetAt(i);

            HSSFRow title = sheetAt.getRow(0);
            title.createCell(8).setCellValue("测试链接");
            title.createCell(9).setCellValue("toon协议链接");

            String uiasUrl = "http://bjt.beijing.gov.cn/renzheng/open/auth/authorize?client_id=2186&redirect_uri=https://gaj.beijing.gov.cn/rkgl/&response_type=code&scope=user_info&state=";
            for (int rowNum = 1; rowNum <= sheetAt.getLastRowNum(); rowNum++) {
                HSSFRow r = sheetAt.getRow(rowNum);
                String itemName  = r.getCell(3).toString();
                String state = r.getCell(6).toString();
                state = state.substring(0, state.lastIndexOf("."));
                String url = uiasUrl + state + "&toonType=102";
                r.createCell(7).setCellValue(url);
                String urlTest = url + "&personToken=b70cf3ad732ec3d913bf9f895d6a3e789fe6c871df943d9188eb999faef274218caed5a8020d0431dde073f00c509aa2e5b2bf3d317d2c2ee926cd8363b85c600dcaa238f22347f0f6375b3c639673172c786d31eb9caebf860f9f18dddd004c";
                r.createCell(8).setCellValue(urlTest);
                String toonUrl = "toon://homeprovider/jumpapp?params={\"appId\":\"2186\",\"appTitle\":\""+itemName+"\",\"appUrl\":\""+url+"\",\"appType\":0,\"isAuthentication\":1}";
                r.createCell(9).setCellValue(toonUrl);
                num++;
            }
        }

        File xlsFile = new File("/Users/liuzhenhua/excel/20190910-2.xls");
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        hssfWorkbook.write(xlsStream);
//        log.info("导出excel完成。");
        System.out.println("导出excel完成。共" + num + "项.");
    }
}
