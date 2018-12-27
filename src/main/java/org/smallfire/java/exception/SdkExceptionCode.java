package org.smallfire.java.exception;

/**
 * Created by Administrator on 20017/11/18.
 */
public class SdkExceptionCode {

    private SdkExceptionCode() {
    }

    /**
     * 基础
     */
    public static final CodeMessage PARAM_IS_NULL = new CodeMessage("10000", "参数为空");

    /**
     * 安全
     */
    public static final CodeMessage VERIFY_ERROR = new CodeMessage("20000", "验签失败");
    public static final CodeMessage UNSUPPORT_DIGEST_TYPE = new CodeMessage("20001", "散列类型不支持");
    public static final CodeMessage BEAN_CONVERT_ERROR = new CodeMessage("20002", "bean转化map错误");
    public static final CodeMessage ENCRYPT_ERROR = new CodeMessage("20003", "加密失败");
    public static final CodeMessage DECRYPT_ERROR =new CodeMessage("20004", "解密失败") ;
    public static final CodeMessage DES_UTIS_KEY_GEN_ERROR = new CodeMessage("20005", "DES的key生成失败 ");
    public static final CodeMessage ENCRYPT_SHA_256_FAIL = new CodeMessage("20006", "SHA256加密失败");
    public static final CodeMessage ENCRYPT_DES_FAIL = new CodeMessage("20007", "DES加密失败");
    public static final CodeMessage DECRYPT_DES_FAIL = new CodeMessage("20008", "DES解密失败");
    public static final CodeMessage RSA_UTIS_KEY_GEN_ERROR = new CodeMessage("20008", "RSA的key生成失败 ");
    public static final CodeMessage RSA_CIPHER_GET_FAIL = new CodeMessage("20009", "RSA的获取Cipher失败 ");
    public static final CodeMessage RSA_GENERATOR_KEY_FAIL = new CodeMessage("20010", "RSA生成秘钥对失败 ");
    public static final CodeMessage ENCRYPT_RSA_FAIL = new CodeMessage("20011", "RSA加密失败");
    public static final CodeMessage DECRYPT_RSA_FAIL = new CodeMessage("20012", "RSA解密失败");
    public static final CodeMessage ALGORITHM_IS_ILLEGAL = new CodeMessage("20013", "加密算法不存在");
    public static final CodeMessage BOUNCY_CASTLE_PROVIDER_NO_EXIS = new CodeMessage("20014", "加密算法不存在");
    public static final CodeMessage ENCRYPT_FAIL = new CodeMessage("20015", "加密失败");
    public static final CodeMessage DECRYPT_FAIL = new CodeMessage("20016", "解密失败");
    public static final CodeMessage HTTP_CODE_WRONG = new CodeMessage("SJ61000", "Http请求返回码错误");
}
