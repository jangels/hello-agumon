package org.smallfire.web.base.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ItemByIdDto implements Serializable {

    /**
     * 字典项编码
     */
    private Long itemId ;
}
