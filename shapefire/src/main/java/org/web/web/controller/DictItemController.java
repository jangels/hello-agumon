package org.web.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web.base.domain.DictItem;
import org.web.base.dto.*;
import org.web.base.result.Result;
import org.web.service.DictItemService;

import java.util.List;

/**
 * <p>
 * 字典项表 前端控制器
 * </p>
 *
 * @author 144637
 * @since 2019-04-29
 */
@Api(tags = "03-字典项接口")
@RestController
@RequestMapping("/dictItem")
public class DictItemController {

    @Autowired
    DictItemService dictItemService;

    @RequestMapping(value = "/getItemListByTypeCode", method = RequestMethod.POST)
    @ApiOperation(value = "根据类型编码获取字典项列表")
    public Result<List<DictItem>> getItemListByTypeCode(@RequestBody ItemListByTypeDto dto) {
        List<DictItem> itemList = dictItemService.getItemListByTypeCode(dto.getDictTypeCode());
        return Result.buildOkData(itemList);
    }

    @RequestMapping(value = "/getItemListByTypeCodeList", method = RequestMethod.POST)
    @ApiOperation(value = "根据类型编码获取字典项列表")
    public Result<List<List<DictItem>>> getItemListByTypeCodeList(@RequestBody List<ItemListByTypeDto> dto) {
        List<List<DictItem>> itemList = dictItemService.getItemListByTypeCodeList(dto);
        return Result.buildOkData(itemList);
    }

    @RequestMapping(value = "/getItemByTypeCodeAndDictCode", method = RequestMethod.POST)
    @ApiOperation(value = "根据类型编码和字典项编码获取字典项")
    public Result<DictItem> getItemByTypeCodeAndDictCode(@RequestBody ItemByDictCodeDto dto) {
        DictItem itemEntity = dictItemService.getDictItemByTypeCodeAndDictCode(dto.getDictTypeCode(), dto.getDictCode());
        return Result.buildOkData(itemEntity);
    }

    @RequestMapping(value = "/getItemById", method = RequestMethod.POST)
    @ApiOperation(value = "根据字典项id获取字典项")
    public Result<DictItem> getItemById(@RequestBody ItemByIdDto dto) {
        DictItem itemEntity = dictItemService.getDictItemById(dto.getItemId());
        return Result.buildOkData(itemEntity);
    }

    @RequestMapping(value = "/getListByTypeCodeAndParentCode", method = RequestMethod.POST)
    @ApiOperation(value = "根据类型编码和字典项父编码获取字典项")
    public Result<List<DictItem>> getListByTypeCodeAndParentCode(@RequestBody ItemByParentCodeDto dto) {
        List<DictItem> itemEntity = dictItemService.getListByTypeCodeAndParentCode(dto.getDictTypeCode(), dto.getParentCode());
        return Result.buildOkData(itemEntity);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存和更新字典项")
    public Result<DictItem> save(@RequestBody DictItemDto dto) {
        return Result.buildOkData(dictItemService.save(dto));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除字典项")
    public Result<DictItem> delete(@RequestBody DictItemDto dto) {
        return Result.buildOkData(dictItemService.delete(dto));
    }
}

