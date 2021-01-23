package org.web.base.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class DictTypeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典类型编码
     */
    private String dictTypeCode;
    /**
     * 字典类型名称
     */
    private String dictTypeName;


    private Long id;
}
