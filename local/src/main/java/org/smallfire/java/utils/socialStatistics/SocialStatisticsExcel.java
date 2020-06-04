package org.smallfire.java.utils.socialStatistics;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.smallfire.java.cipher.Decrypt;
import org.smallfire.java.cipher.impl.AES256Cipher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 社保认证数据处理
 *
 * @description
 */
public class SocialStatisticsExcel {
    public static void write(String path) throws IOException {

        File file = new File("F://social.txt");
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("社保认证名单");
        HSSFRow title = sheet.createRow(0);
        title.createCell(0).setCellValue("姓名");
        title.createCell(1).setCellValue("身份证加密");
        title.createCell(2).setCellValue("身份证解密");

        for (int i = 0; i < lines.size(); i++) {
            String item = lines.get(i);
            HSSFRow rows = sheet.createRow(i + 1);
            rows.createCell(0).setCellValue(item.split("\t")[0]);

            String idEncrypt = item.split("\t")[1];
            rows.createCell(1).setCellValue(idEncrypt);
            rows.createCell(2).setCellValue(getDecryptIdNo(idEncrypt));
        }

        File xlsFile = new File(path);
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
        System.out.println("数据处理完毕...,共" + lines.size() + "条");
    }

    private static String getDecryptIdNo(String idEncrypt) {

        AES256Cipher cipherb64 = new AES256Cipher("6f6ffe02131a4d0fb9649794dc2df5a8", Decrypt.HEX);

        return cipherb64.decrypt2UTF8(idEncrypt, Decrypt.HEX);
    }

    public static void main(String[] args) throws IOException {

//        AES256Cipher cipherb64 = new AES256Cipher("8d537926b4b447b2b54d50a3fa7833ed", Decrypt.HEX);
//
//        System.out.println(cipherb64.encrypt2Hex("37148219901214483X"));
//        System.out.println(getDecryptIdNo("D84620818061DE4B4A6338B01B8E8E28AC102969ED1DD788087FD3B2CB4495BA"));
        write("F://socialData.xls");
    }
}
