package org.smallfire.web.base.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class DictItemDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 字典项类型编码
     */
    private String dictTypeCode;
    /**
     * 字典项编码
     */
    private String dictCode;
    /**
     * 字典项值
     */
    private String dictValue;
    /**
     * 字典项父编码
     */
    private String dictParentCode;
    /**
     * 字典项扩展值
     */
    private String dictValueExtra;
}
