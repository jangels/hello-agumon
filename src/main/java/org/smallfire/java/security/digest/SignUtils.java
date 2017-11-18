package org.smallfire.java.security.digest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.smallfire.java.exception.BusinessException;
import org.smallfire.java.exception.SdkExceptionCode;

import java.util.*;

/**
 * Created by Administrator on 2017/11/18.
 */
public class SignUtils {

    private static String DEFAULTCHARSET = "UTF-8";

    public static String sign(String content) {
        return sign(content, SignUtils.DigestType.MD5);
    }


    public static String sign(String content, SignUtils.DigestType type) {
        if (SignUtils.DigestType.NONE.equals(type)) {
            return "";
        } else {

            if (DigestType.MD5.equals(type)) {
                return DigestUtils.md5Hex(content).toUpperCase();
            }
            if (DigestType.SHA256.equals(type)) {
                return DigestUtils.sha256Hex(content).toUpperCase();
            }

            throw new BusinessException(SdkExceptionCode.UNSUPPORT_DIGEST_TYPE);
        }
    }

    public static boolean verify(String sign, String content, SignUtils.DigestType type) {
        try {
            String result = sign(content, type);
            return result.equals(sign);
        } catch (Exception e) {
            throw new BusinessException(SdkExceptionCode.VERIFY_ERROR);
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
            Collections.sort(keyList, new Comparator() {
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
}
