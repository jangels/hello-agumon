package org.smallfire.server.base.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class TypeByCodeDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 类型编码
     */
    private String dictTypeCode;
}
