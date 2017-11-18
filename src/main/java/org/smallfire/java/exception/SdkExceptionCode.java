package org.smallfire.java.exception;

/**
 * Created by Administrator on 2017/11/18.
 */
public class SdkExceptionCode {

    private SdkExceptionCode() {
    }

    /**
     * 基础
     */
    public static final CodeMessage PARAM_IS_NULL = new CodeMessage("1000", "参数为空");

    /**
     * 安全
     */
    public static final CodeMessage VERIFY_ERROR = new CodeMessage("2000", "验签失败");
    public static final CodeMessage UNSUPPORT_DIGEST_TYPE =new CodeMessage("2001", "散列类型不支持") ;
}
