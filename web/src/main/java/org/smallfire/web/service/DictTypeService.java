package org.smallfire.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.smallfire.web.base.domain.DictType;
import org.smallfire.web.base.dto.DictTypeDto;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author 144637
 * @since 2019-04-29
 */
public interface DictTypeService extends IService<DictType> {

    /**
     * 根据类型编码获取字典类型
     * @param typeCode 类型编码
     * @return DictType 类型实体
     */
    DictType getDictTypeByCode(String typeCode);

    /**
     * 获取所有字典类型
     * @return
     */
    List<DictType> getAllType();

    /**
     * 新增和修改字典类型
     * @param dictTypeDto
     * @return DictType
     */
    DictType save(DictTypeDto dictTypeDto);


    /**
     * 禁用字典类型
     * @param dictTypeDto
     * @return DictType
     */
    DictType delete(DictTypeDto dictTypeDto);
}
