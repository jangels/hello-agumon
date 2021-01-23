package org.common.exception;

import org.common.constant.CoreConstant;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/18.
 */

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;

    public BusinessException(String code, String message) {
        this((String) code, (String) message, (Throwable) null);
    }

    public BusinessException(String code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public BusinessException(Throwable t) {
        this(CoreConstant.RETURN_CODE_UNKNOWN_ERROR, t);
    }

    public BusinessException(CodeMessage codeMessage) {
        this((String) codeMessage.getCode(), (String) codeMessage.getMessage(), (Throwable) null);
    }

    public BusinessException(CodeMessage codeMessage, Throwable t) {
        this(codeMessage.getCode(), codeMessage.getMessage(), t);
    }

    public BusinessException(CodeMessage codeMessage, String paramValue) {
        this((String) codeMessage.getCode(), (String) codeMessage.getMessage(paramValue), (Throwable) null);
    }

    public BusinessException(CodeMessage codeMessage, Throwable t, String paramValue) {
        this(codeMessage.getCode(), codeMessage.getMessage(paramValue), t);
    }

    public BusinessException(CodeMessage codeMessage, Map paramValues) {
        this((String) codeMessage.getCode(), (String) codeMessage.getMessage(paramValues), (Throwable) null);
    }

    public BusinessException(CodeMessage codeMessage, Throwable t, Map paramValues) {
        this(codeMessage.getCode(), codeMessage.getMessage(paramValues), t);
    }

    public String getCode() {
        return this.code;
    }
}