package org.smallfire.server.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    @ApiOperation(value = "测试数字", httpMethod = "POST", notes = "测试数字")
    @RequestMapping(path = "/testResult", method = RequestMethod.GET)
    @ResponseBody
    public String test(@ApiParam(required = true, name = "输入", value = "输入")
                               String data) {

        JSONObject jsonObject = JSON.parseObject(data);
        String data1 = jsonObject.getString("data");

        String binaryStr = Integer.toBinaryString(Integer.valueOf(data1));

        return binaryStr;
    }
}
