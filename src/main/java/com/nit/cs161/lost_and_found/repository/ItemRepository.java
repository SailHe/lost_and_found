package com.nit.cs161.lost_and_found.repository;

import com.nit.cs161.lost_and_found.entity.laf.LafItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Descriptions: 物品持久层<p>
 *
 * @author SailHe
 * @date 2018/10/6 13:50
 */
@Repository
public interface ItemRepository extends JpaRepository<LafItem, Integer>, JpaSpecificationExecutor<LafItem> {

    /**
     * Descriptions: 根据物品名称查询<p>
     *
     * @author SailHe
     * @date 2018/10/6 13:50
     */
    List<LafItem> findAllByItemName(String itemName);
}
