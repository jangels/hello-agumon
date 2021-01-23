import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.common.utils.http.HttpUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YdgfInitUtils {

    public final static String YDGF_INIT_INTERFACE = "http://service.beijingtoon.com/bjydgf-web-common-auth/resourceApp/insert";
    public final static String YDGF_GET_FULL_URL = "http://service.beijingtoon.com/bjydgf-web-common-auth/api/1.0/getFullYdgfUrl";
    public static final String BJT_KEY = "100100000096";

    public static void main(String[] args) throws IOException {
        new YdgfInitUtils().init();
//        String fullUrl = getFullUrl("https://ydgf.bjydgf.cn/h5gw/api/98dac4ec-2d91-4c99-ae17-4f1746e26d6a");
//        System.out.println("fullUrl-->" + fullUrl);

//        String url = "/Users/liuzhenhua/temail/download/待出售测试机明细.xls";
//        Map<Object, List<String>> obj = (Map<Object, List<String>>) readFromExcel(url);
//        System.out.println(obj);

//        parseFullUrl();
    }

    /**tf
     * 解析移动公服全地址
     */
    private static void parseFullUrl() {

        // read source
        // parse
        // output parse result
    }

    /**
     * excel中读取数据
     * @param url
     * @return
     * @throws IOException
     */
    public static Object readFromExcel(String url) throws IOException {

        InputStream is = new FileInputStream(url);

        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Object, List<String>> rowMap = new HashMap<>();
        // 遍历row
        for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);

            List<String> cellList = new ArrayList<>();
            // 遍历cell
            for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
                String itemName = row.getCell(cellNum).toString();
                cellList.add(itemName);
            }

            rowMap.put(rowNum, cellList);
        }
        return rowMap;
    }

    private void init() {

        // 解析所有接口编码

        File file = new File("/Users/liuzhenhua/Desktop/temp/ydgf.txt");
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 调用公服接口
        System.out.println(lines);

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("appId", BJT_KEY);

        int i = 0;
        for (String item : lines) {
            paramMap.put("resourceNo", item);

            String body = JSON.toJSONString(paramMap);
            System.out.println("入参-->" + body);
            String response = HttpUtils.syncPostString(YDGF_INIT_INTERFACE, null, body);

            System.out.println("出参-->" + response);
            i++;
        }
        System.out.println("初始化成功--> " + i + " 条数据");
    }

    /**
     * 获取全地址
     *
     * @param url
     * @return
     */
    public static String getFullUrl(String url) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("baseUrl", url);
        paramMap.put("toonType", "102");

        String body = JSON.toJSONString(paramMap);

        System.out.println("入参-->" + body);
        String response = HttpUtils.syncPostString(YDGF_GET_FULL_URL, null, body);

        System.out.println("出参-->" + response);

        JSONObject respMap = JSON.parseObject(response, JSONObject.class);
        JSONObject fullUrlMap = JSON.parseObject((respMap.get("data").toString()), JSONObject.class);
        return fullUrlMap.get("fullUrl").toString();
    }
}



