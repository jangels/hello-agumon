package org.smallfire.java.guava;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.junit.Test;
import org.smallfire.java.utils.http.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 移动公服申请接口工具类
 */
@Data
@Slf4j
public class YdgfUtils {

    public static String sessionId = "zhengtoon_portal_session_c5a043ff5ce24b20be85a289b5b56a24";

    @Test
    public void testAutoApplyInterface() {
        String ydgfUrl = "https://ydgf.bjydgf.cn/zhengtoon-portal-console/report/res/resourceListWithApply";
        String requestJson = "{\"resourceName\":\"\",\"pageNumber\":1,\"pageSize\":10,\"type\":2,\"appId\":\"100100000096\",\"auditState\":1}";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("sessionId", sessionId);
        Headers headers = Headers.of(headerMap);

        String response = HttpUtils.syncPostString(ydgfUrl, headers, requestJson);

        System.out.println("接口返回-->"+response);
    }
}
