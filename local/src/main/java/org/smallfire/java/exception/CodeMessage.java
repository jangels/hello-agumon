package org.smallfire.java.exception;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/18.
 */

public class CodeMessage {
    private static final String PATTERN = "\\$\\{.*\\}";
    private String code;
    private String message;

    public CodeMessage() {
    }

    public CodeMessage(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(String paramValue) {
        return StringUtils.replace(this.message, "\\$\\{.*\\}", paramValue);
    }

    public String getMessage(Map<String, String> paramValues) {
        String msg = this.message;

        Map.Entry entry;
        for (Iterator var4 = paramValues.entrySet().iterator(); var4.hasNext(); msg = StringUtils.replace(msg, "\\$\\{" + (String) entry.getKey() + "\\}", (String) entry.getValue())) {
            entry = (Map.Entry) var4.next();
        }

        return msg;
    }

    public String toString() {
        return "code = " + this.code + "，message = " + this.message;
    }
}