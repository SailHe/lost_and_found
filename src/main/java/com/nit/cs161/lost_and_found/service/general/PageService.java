package com.nit.cs161.lost_and_found.service.general;

import com.nit.cs161.lost_and_found.dto.general.DtRequestDTO;
import com.nit.cs161.lost_and_found.dto.general.DtResponseDTO;


/**
 * Description: 页面业务逻辑服务接口<p>
 *
 * @Package: com.nit.cs161.lost_and_found.service
 * @author: SailHe
 * @date 2018/4/23 18:30
 */
public interface PageService<DTO, PrimaryKey> extends CrudService<DTO, PrimaryKey>{
    /**
     * Descriptions: 根据请求获取一个页面
     *
     * @param dtRequestDTO 页面请求对象
     * @return 返回页面响应对象
     * @throws Exception 数据库日常
     * @author SailHe
     * @date 2018/1/27 15:05
     */
    DtResponseDTO getPageResponse(DtRequestDTO dtRequestDTO) throws Exception;

}
