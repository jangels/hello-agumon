package org.smallfire.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.smallfire.web.base.domain.DictType;
import org.smallfire.web.base.dto.DictTypeDto;
import org.smallfire.web.base.dto.TypeByCodeDto;
import org.smallfire.web.base.result.Result;
import org.smallfire.web.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典类型表 前端控制器
 * </p>
 *
 * @author 144637
 * @since 2019-04-29
 */
@Api(tags = "02-字典类型接口")
@RestController
@RequestMapping("/dictType")
public class DictTypeController {

    @Autowired
    DictTypeService dictTypeService;

    @RequestMapping(value = "/getDictTypeByCode", method = RequestMethod.POST)
    @ApiOperation(value = "根据类型编码获取字典类型")
    public Result<DictType> getDictTypeByCode(@RequestBody TypeByCodeDto dto) {
        DictType typeEntity = dictTypeService.getDictTypeByCode(dto.getDictTypeCode());
        return Result.buildOkData(typeEntity);
    }

    @RequestMapping(value = "/getAllType", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有字典类型")
    public Result<List<DictType>> getAllType() {
        List<DictType> typeEntityList = dictTypeService.getAllType();
        return Result.buildOkData(typeEntityList);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "插入和更新字典类型")
    public Result<DictType> save(@RequestBody DictTypeDto dto) {
        return Result.buildOkData(dictTypeService.save(dto));
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除字典类型")
    public Result<DictType> delete(@RequestBody DictTypeDto dto) {
        return Result.buildOkData(dictTypeService.delete(dto));
    }
}

