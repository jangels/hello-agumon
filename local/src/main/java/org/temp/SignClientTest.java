package org.temp;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SignClientTest {

    /**
     * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br>
     * 注意: 如果参数的值为空则不参与签名
     * 实现步骤:
     * 第一步：对参数按照key=value的格式，并按照参数名ASCII字典序排序
     * 第二步：参数拼接完毕之后,拼接密钥key
     * 第三步：取MD5运算值
     *
     * @return
     */
    public static void main(String[] args) {


        //举例： 我的appid = 123456, secretKey = guangsheng
        // 设接口的参数如下：
        String appId = "100001";
        String secretKey = "guangsheng";
        String name = "栗广生";
        String phone = "17601637175";
        String a = "2";
        String body = "testtesttest";
        // nonce 为不重复的随机字符串，接入方在请求时要保证在60秒内该值不能重复，作用防止接口重复提交
        String nonce = "nonce111";
        long timestamp = System.currentTimeMillis();

        Map<String, Object> map = new HashMap();
        map.put("appId", appId);
        map.put("name", name);
        map.put("phone", phone);
        map.put("a", a);
        map.put("body", body);
        map.put("nonce", nonce);
        map.put("timestamp", timestamp);

        // 第一步：对参数按照key=value的格式，并按照参数名ASCII字典序排序
        StringBuffer stringBuffer = new StringBuffer();

        try {
            Set<String> keySet = map.keySet();
            String[] keyArray = keySet.toArray(new String[keySet.size()]);
            Arrays.sort(keyArray);
            for (String key :
                    keyArray) {

                // 参数值为空，则不参与签名
                String value = map.get(key).toString();
                if (value.trim().length() > 0) {
                    stringBuffer.append(key).append("=").append(value.trim()).append("&");
                }
            }

            // 参数拼接完毕之后,拼接密钥key
            stringBuffer.append("secretKey=").append(secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //最终拼接的结果为  a=2&appId=100001&body=testtesttest&name=栗广生&nonce=nonce111&phone=17601637175&timestamp=1586591507107&secretKey=guangsheng
        String paramString = stringBuffer.toString();
        System.out.println(paramString);

        try {
            String sign = MD5(paramString);
            // 得到MD5結果之后继续放到请求实体里
            map.put("sign", sign);
            // 签名生成完成
            System.out.println("签名值为"+sign);

        } catch (Exception e) {
            // 自行处理异常
            e.printStackTrace();
        }


    }

    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }


}
