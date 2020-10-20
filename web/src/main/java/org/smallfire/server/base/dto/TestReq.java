package org.smallfire.server.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestReq {

    @ApiModelProperty(name = "name", value = "姓名",example = "lzh")
    private String name;
}
