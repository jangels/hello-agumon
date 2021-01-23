package org.smallfire.java.security.digest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.common.exception.BusinessException;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by Administrator on 2017/11/18.
 */
public class SignUtils {

    private static String DEFAULTCHARSET = "UTF-8";

    public static String sign(String content) {
        return sign(content, DigestType.MD5);
    }

    public static String sign(JSONObject bean, String appSecret) {
        return sign(appSecret + getSortParams(bean) + appSecret);
    }

    public static String sign(String content, DigestType type) {
        if (DigestType.NONE.equals(type)) {
            return "";
        } else {

            if (DigestType.MD5.equals(type)) {
                return DigestUtils.md5Hex(content).toUpperCase();
            }

            throw new BusinessException("20001", "散列类型不支持");
        }
    }

    public static boolean verify(String sign, String content) {
        return verify(sign, content, DigestType.MD5);
    }

    public static boolean verify(String sign, JSONObject bean,String appSecret) {
        return verify(sign, appSecret + getSortParams(bean)+appSecret, DigestType.MD5);
    }

    public static boolean verify(String sign, String content, DigestType type) {
        try {
            String result = sign(content, type);
            return result.equals(sign);
        } catch (Exception e) {
            throw new BusinessException("20000", "验签失败");
        }
    }


    public static String getSortParams(Map<String, String> params) {
        if (params != null && !params.isEmpty()) {
            params.remove("sign");
            String contnt = "";
            Set keySet = params.keySet();
            ArrayList keyList = new ArrayList();
            Iterator i = keySet.iterator();

            String key;
            while (i.hasNext()) {
                key = (String) i.next();
                String value = params.get(key);
                if (!StringUtils.isEmpty(value)) {
                    keyList.add(key);
                }
            }
            Collections.sort(keyList, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    int length = Math.min(o1.length(), o2.length());

                    for (int i = 0; i < length; ++i) {
                        char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i);
                        int r = c1 - c2;
                        if (r != 0) {
                            return r;
                        }
                    }

                    return o1.length() - o2.length();
                }

            });

            for (int var7 = 0; var7 < keyList.size(); ++var7) {
                key = (String) keyList.get(var7);
                contnt = contnt + key + (String) params.get(key);
            }

            return contnt;
        } else {
            return "";
        }
    }


    public static String getSortParams(JSONObject params) {
        if (params != null && !params.isEmpty()) {
            params.remove("sign");
            String contnt = "";
            Set keySet = params.keySet();
            ArrayList keyList = new ArrayList();
            Iterator i = keySet.iterator();

            String key;
            while (i.hasNext()) {
                key = (String) i.next();
                String value =params.get(key).toString();
                if (!StringUtils.isEmpty(value)) {
                    keyList.add(key);
                }
            }
            Collections.sort(keyList, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    int length = Math.min(o1.length(), o2.length());

                    for (int i = 0; i < length; ++i) {
                        char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i);
                        int r = c1 - c2;
                        if (r != 0) {
                            return r;
                        }
                    }

                    return o1.length() - o2.length();
                }

            });

            for (int var7 = 0; var7 < keyList.size(); ++var7) {
                key = (String) keyList.get(var7);
                contnt = contnt + key + params.get(key).toString();
            }

            return contnt;
        } else {
            return "";
        }
    }

    public static String getSortParams(Object bean) {
        Map<String, String> beanMap = null;
        try {
            beanMap = BeanUtils.describe(bean);
        } catch (Exception e) {
            throw new BusinessException("20002", "bean转化map错误");
        }
        beanMap.remove("class");
        return getSortParams(beanMap);
    }

    public enum DigestType {
        MD5("MD5"),
        SHA256("SHA-256"),
        NONE("NONE");

        private String value;

        private DigestType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        String appSecret = UUID.randomUUID().toString();

        JSONObject bean = new JSONObject();
        bean.put("k1","v1");
        bean.put("k2",2);

        System.out.println(getSortParams(bean));
        // 签名
        String sign = sign(bean,appSecret);
        System.out.println("签名为=====>" + sign);

        // 验签
        boolean verifyResult = verify(sign, bean,appSecret);
        System.out.println("验签结果=====>" + verifyResult);
    }
}
