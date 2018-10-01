package com.nit.cs161.lost_and_found.service.general;

import java.util.List;

/**
 * Description: 可罗列的接口<p>
 *
 * @Package: com.nit.cs161.lost_and_found.service
 * @author: SailHe
 * @date 2018/5/22 16:56
 */
public interface ListAble<DTO, Filter> {
    /**
     * Descriptions: 获取筛选列表
     *
     * @param filter 筛选器
     * @return 经筛选后的记录列表
     * @throws Exception 数据库日常
     * @author SailHe
     * @date 2018/5/22 17:06
     */
    List<DTO> listRecord(Filter filter) throws Exception;

}
