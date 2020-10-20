package org.smallfire.server.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.smallfire.server.base.dto.TestReq;
import org.smallfire.server.base.dto.TestResp;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzh
 */
@RestController
@Api(tags = "01-测试接口")
public class TestController {

    @ApiOperation(value = "测试接口", httpMethod = "POST", notes = "测试接口")
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    @ResponseBody
    public TestResp test(
            @ApiParam(required = true, name = "测试接口参数", value = "测试接口参数")
            @RequestBody TestReq req) {

        return new TestResp("Hello! " + req.getName());
    }
}
