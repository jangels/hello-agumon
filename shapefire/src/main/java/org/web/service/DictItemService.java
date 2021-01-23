package org.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.web.base.domain.DictItem;
import org.web.base.dto.DictItemDto;
import org.web.base.dto.ItemListByTypeDto;

import java.util.List;

/**
 * <p>
 * 字典项表 服务类
 * </p>
 *
 * @author 144637
 * @since 2019-04-29
 */
public interface DictItemService extends IService<DictItem> {

    /**
     * 根据类型编码获取字典项列表
     *
     * @param typeCode 类型编码
     * @return List<DictItem> 字典项列表
     */
    List<DictItem> getItemListByTypeCode(String typeCode);

    /**
     * 根据类型编码列表获取字典项列表
     *
     * @param dto 类型编码列表
     * @return List<List<DictItem>> 字典项列表
     */
    List<List<DictItem>> getItemListByTypeCodeList(List<ItemListByTypeDto> dto);

    /**
     * 根据类型编码和字典项编码获取字典项
     * @param typeCode 类型编码
     * @param dictCode 字典项编码
     * @return DictItem 字典项
     */
    DictItem getDictItemByTypeCodeAndDictCode(String typeCode, String dictCode);

    /**
     * 根据字典项id获取字典项
     * @param id 字典项id
     * @return DictItem
     */
    DictItem getDictItemById(Long id);

    /**
     * 根据类型编码和字典项父编码获取字典项
     * @param typeCode 类型编码
     * @param parentDictCode 字典项父编码
     * @return List<DictItem> 字典项列表
     */
    List<DictItem> getListByTypeCodeAndParentCode(String typeCode, String parentDictCode);

    /**
     * 新增和修改字典项
     * @param DictItemDto
     * @return DictItem
     */
    DictItem save(DictItemDto DictItemDto);

    /**
     * 禁用字典项
     * @param DictItemDto
     * @return DictItem
     */
    DictItem delete(DictItemDto DictItemDto);

}
