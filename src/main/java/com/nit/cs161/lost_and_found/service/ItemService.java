package com.nit.cs161.lost_and_found.service;

import com.nit.cs161.lost_and_found.dto.ItemDTO;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.service.general.CrudService;
import com.nit.cs161.lost_and_found.service.general.PageService;

import java.util.List;

/**
 * Descriptions: 物品业务逻辑<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:43
 */
public interface ItemService extends PageService<ItemDTO, Integer> {
    ItemDTO getRecord(String itemName) throws Exception;

    /**
     * Descriptions: 模糊查询物品<p>
     *
     * @author SailHe
     * @date 2018/10/6 13:35
     */
    List<ItemDTO> listFuzzyItem(String search);

}

