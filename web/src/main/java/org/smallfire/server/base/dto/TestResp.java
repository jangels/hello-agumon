package org.smallfire.server.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestResp {

    public TestResp(String result) {
        this.result = result;
    }
    @ApiModelProperty(name = "result", value = "结果",example = "Hello! lzh")
    private String result;
}
