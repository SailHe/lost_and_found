package com.nit.cs161.lost_and_found.service.general;

/**
 * Description: 增删改查业务逻辑服务接口<p>
 *
 * @Package: com.nit.cs161.lost_and_found.service
 * @author: SailHe
 * @date: 2018/4/1 19:57
 */
public interface CrudService<DTO, PrimaryKey> {
    /**
     * Descriptions: 按主键primaryKey查找一条记录
     *
     * @param primaryKey 记录主键编号
     * @return 返回主键对应的传输对象
     * @throws Exception 数据库日常
     * @author SailHe
     * @date 2018/1/27 15:05
     */
    DTO getRecord(PrimaryKey primaryKey) throws Exception;

    /**
     * Descriptions: 删除primaryKey对应的一条记录<p>
     *
     * @param primaryKey 记录主键编号
     * @return 删除记录条数
     * @throws Exception 数据库日常
     * @author SailHe
     * @date 2018/1/27 21:16
     */
    Integer deleteRecord(PrimaryKey primaryKey) throws Exception;

    /**
     * Descriptions: 按示例的主键分辨记录 将示例的非空内容更新到记录
     *
     * @param record 记录示例
     * @return 更新记录条数
     * @throws Exception 数据库日常
     * @author SailHe
     * @date 2018/1/28 14:32
     */
    Integer updateRecord(DTO record) throws Exception;

    /**
     * Descriptions: 按示例内容新增记录<p>
     *
     * @param record 记录示例
     * @return PrimaryKey.class
     * @throws Exception 数据库日常
     * @author SailHe
     * @date 2018/1/27 15:52
     */
    PrimaryKey saveRecord(DTO record) throws Exception;

    /**
     * Descriptions: 按示例的非空内容新增记录<p>
     *
     * @param record 记录示例
     * @return PrimaryKey.class
     * @throws Exception 数据库日常
     * @author SailHe
     * @date 2018/1/27 15:52
     */
    PrimaryKey insertRecord(DTO record) throws Exception;
}
