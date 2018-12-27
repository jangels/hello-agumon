package org.smallfire.java.test;

import com.bjtoon.framework.sdk.config.SDKConfig;
import com.bjtoon.framework.sdk.entity.ToonCodeInfo;
import com.bjtoon.framework.sdk.toon.tooncode.ToonCodeUtils;

import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/2/5.
 */
public class TestSdk {
    public static void main(String[] args) {
        String appSecret = SDKConfig.getPropertyValue("bjtoon.appSecret");
        String code = "W2YbutfOYQKjyuiIJ6X2PN1LxZ8iuDOt5t1nKf0Y8UZ3PK1vjfsg7+WZ6/BWdi2ed37WEs16IHeaaLIQlhQSFy+NgFgBsuvdyWNBAKDM/A5VSO3f7M17urS3V0aURUaqimztwO5l32BrWhPiqrITFw==";
        ToonCodeInfo toonCodeInfo = ToonCodeUtils.decryptToonCode(URLEncoder.encode(code), appSecret);
        System.out.println(toonCodeInfo.toString());
    }
}
