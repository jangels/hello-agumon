package org.smallfire.server.base.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ItemByDictCodeDto implements Serializable {

    /**
     * 类型编码
     */
    private String dictTypeCode;

    /**
     * 字典项编码
     */
    private String dictCode;
}
