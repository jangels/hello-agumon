package org.web.base.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ItemListByTypeDto implements Serializable {

    /**
     * 类型编码
     */
    private String dictTypeCode;
}
