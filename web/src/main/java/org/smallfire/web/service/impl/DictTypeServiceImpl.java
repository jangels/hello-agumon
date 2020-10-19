package org.smallfire.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.smallfire.web.base.domain.DictType;
import org.smallfire.web.base.mapper.DictTypeMapper;
import org.smallfire.web.base.dto.DictTypeDto;
import org.smallfire.web.service.DictTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author 144637
 * @since 2019-04-29
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {


    @Override
    public DictType getDictTypeByCode(String typeCode) {
        QueryWrapper wrapper= Wrappers.query();
        wrapper.eq(DictType.DICT_TYPE_CODE, typeCode);
        DictType dict = super.getOne(wrapper);
        return dict;
    }

    @Override
    public List<DictType> getAllType() {
        QueryWrapper wrapper= Wrappers.query();
        wrapper.orderByAsc("create_time");
        List<DictType> entityList = super.list(wrapper);
        return entityList;
    }

    @Override
    public DictType save(DictTypeDto dictTypeDto) {
        DictType DictType = new DictType();
        BeanUtils.copyProperties(dictTypeDto, DictType);
        super.saveOrUpdate(DictType);
        return DictType;
    }

    @Override
    public DictType delete(DictTypeDto dictTypeDto) {
        DictType DictType = super.getById(dictTypeDto.getId());
        DictType.setDeleteFlag(1);
        super.saveOrUpdate(DictType);
        return DictType;
    }
}
