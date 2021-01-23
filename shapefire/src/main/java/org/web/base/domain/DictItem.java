package org.web.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 字典项表
 * </p>
 *
 * @author cos-lzh
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictItem extends Model<DictItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典项类型编码
     */
    @TableField("dict_type_code")
    private String dictTypeCode;
    /**
     * 字典项编码
     */
    @TableField("dict_code")
    private String dictCode;
    /**
     * 字典项值
     */
    @TableField("dict_value")
    private String dictValue;
    /**
     * 字典项父编码
     */
    @TableField("dict_parent_code")
    private String dictParentCode;
    /**
     * 字典项扩展值
     */
    @TableField("dict_value_extra")
    private String dictValueExtra;

    /**
     * 删除标识
     */
    private Integer deleteFlag;

    /**
     * 主键
     */
    private Long createTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 更新人
     */
    private Long updateBy;

    public static final String ID = "id";

    public static final String DICT_TYPE_CODE = "dict_type_code";

    public static final String DICT_CODE = "dict_code";

    public static final String DICT_VALUE = "dict_value";

    public static final String DICT_PARENT_CODE = "dict_parent_code";

    public static final String DICT_VALUE_EXTRA = "dict_value_extra";

    public static final String DELETE_FLAG = "delete_flag";

    public static final String CREATE_TIME = "create_time";

    public static final String CREATE_BY = "create_by";

    public static final String UPDATE_TIME = "update_time";

    public static final String UPDATE_BY = "update_by";

    protected Serializable pkVal() {
        return this.id;
    }

}
