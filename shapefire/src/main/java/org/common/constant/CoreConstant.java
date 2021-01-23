package org.common.constant;

import org.common.exception.CodeMessage;

/**
 * Created by Administrator on 2017/11/18.
 */
public class CoreConstant {
    public static final CodeMessage RETURN_CODE_SUCCESS = new CodeMessage("0", "成功");
    public static final CodeMessage RETURN_CODE_UNKNOWN_ERROR = new CodeMessage("SYS59999", "未知异常");
    public static final CodeMessage RETURN_CODE_PARAM_IS_NULL = new CodeMessage("SYS20001", "参数${paramName}为空！");
    public static final CodeMessage RETURN_CODE_PARAM_IS_INVALID = new CodeMessage("SYS20002", "参数${paramName}为无效！");
    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_DELETED = 1;
    public static final int STATUS_DISABLED = 2;
    public static final int OPERATE_TYPE_ADD = 1;
    public static final int OPERATE_TYPE_UPDATE = 2;
    public static final int OPERATE_TYPE_DELETE = 3;

    public CoreConstant() {
    }
}