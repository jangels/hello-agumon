package org.smallfire.java.utils.govhallStatistics;

import lombok.Data;

import java.util.ArrayList;

/**
 * @description
 * @author: Created by 韩晓明
 * @Date: 2018/8/23 16:01
 */
@Data
public class ExcelSheetDTO {
    private String sheetName;
    private ArrayList<ArrayList<String>> data;
}
