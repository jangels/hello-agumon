package guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.smallfire.java.utils.http.HttpUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YdgfInitUtils {

    public final static String YDGF_INIT_INTERFACE = "http://service.beijingtoon.com/bjydgf-web-common-auth/resourceApp/insert";

    public static void main(String[] args) {
        new YdgfInitUtils().init();
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

        paramMap.put("appId", "100100000096");


        int i = 0 ;
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
}
