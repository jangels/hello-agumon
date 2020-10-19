package org.smallfire.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.smallfire.web.base.domain.DictItem;
import org.smallfire.web.base.mapper.DictItemMapper;
import org.smallfire.web.base.dto.DictItemDto;
import org.smallfire.web.base.dto.ItemListByTypeDto;
import org.smallfire.web.service.DictItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 字典项表 服务实现类
 * </p>
 *
 * @author 144637
 * @since 2019-04-29
 */
@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {


    @Override
    public List<DictItem> getItemListByTypeCode(String typeCode) {

        QueryWrapper wrapper= Wrappers.query();
        wrapper.eq(DictItem.DICT_TYPE_CODE, typeCode);
        wrapper.orderByAsc("create_time");
        List<DictItem> itemEntityList = super.list(wrapper);

        return itemEntityList;
    }

    @Override
    public List<List<DictItem>> getItemListByTypeCodeList(List<ItemListByTypeDto> dto) {
        List<List<DictItem>> itemList = new ArrayList<>();
        for (ItemListByTypeDto item : dto) {
            itemList.add(getItemListByTypeCode(item.getDictTypeCode()));
        }
        return itemList;
    }

    @Override
    public DictItem getDictItemByTypeCodeAndDictCode(String typeCode, String dictCode) {
        QueryWrapper wrapper= Wrappers.query();
        wrapper.eq(DictItem.DICT_TYPE_CODE, typeCode);
        wrapper.eq(DictItem.DICT_CODE, dictCode);
        wrapper.orderByAsc("create_time");
        DictItem itemEntity = super.getOne(wrapper);
        return itemEntity;
    }

    @Override
    public DictItem getDictItemById(Long id) {
        return super.getById(id);
    }

    @Override
    public List<DictItem> getListByTypeCodeAndParentCode(String typeCode, String parentDictCode) {
         QueryWrapper wrapper= Wrappers.query();;
        wrapper.eq(DictItem.DICT_TYPE_CODE, typeCode);
        wrapper.eq(DictItem.DICT_PARENT_CODE, parentDictCode);
        wrapper.orderByAsc("create_time");
        List<DictItem> itemEntityList = super.list(wrapper);

        return itemEntityList;

    }

    @Override
    public DictItem save(DictItemDto DictItemDto) {
        DictItem DictItem = new DictItem();
        BeanUtils.copyProperties(DictItemDto, DictItem);
        super.saveOrUpdate(DictItem);
        return DictItem;
    }

    @Override
    public DictItem delete(DictItemDto DictItemDto) {
        DictItem DictItem = super.getById(DictItemDto.getId());
        DictItem.setDeleteFlag(1);
        super.saveOrUpdate(DictItem);
        return DictItem;
    }
}
