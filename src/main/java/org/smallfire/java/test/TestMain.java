package org.smallfire.java.test;

import com.bjtoon.framework.sdk.entity.ToonCodeInfo;
import com.bjtoon.framework.sdk.toon.tooncode.ToonCodeUtils;
import com.zhengtoon.uia.utils.SignUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/26.
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        String code = "ERM/Jz09WTd7aB8ujuUa69CQB+NTgSzIxk34I4jtNLjbz5P+8jHiXjIeEc3bvgldC2KqYDlgIwl7B1Htu+FqgE+RbDEIbMLcf6sNCEK3OKSK908AyEmEzvq26ZKodLn8RXJF133k1rr+rplV/+yIfA==";
        String appSecret = "fc471af0e469404c8fc5ed2000077e20";
        ToonCodeInfo toonCodeInfo = ToonCodeUtils.decryptToonCode(URLEncoder.encode(code), appSecret);
        System.out.println(toonCodeInfo);

        Map<String, String> requestMap = new HashMap();
        requestMap.put("clientId", "20171226102297");
        requestMap.put("clientSecret", "ecb0120d21ea33d9b76018808ffcc85e");
        requestMap.put("responseType", "code");
        requestMap.put("redirectUri", "http://t100quickgo.zhengtoon.com/uath-demo-ui/index.html");
        requestMap.put("scope", "userInfo");
        requestMap.put("state", "2");
        requestMap.put("personToken", "dcfd9d59bbc7c87305408dce5281e31467bea529bd8b7aed728d3802a3520936a338f6b9e9a17d3e7ec654be96991794906262ceb9046d92d3ca067ee7874a5c78612064ce6c7b27daa0e655b9db09a75ad96ba634ab66b686b2946ee45f726b");

        System.out.println(SignUtils.getSign(requestMap));

    }
}
