package com.nit.cs161.lost_and_found.repository;

import com.nit.cs161.lost_and_found.entity.laf.LafMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Descriptions: 持久层<p>
 *
 * @author SailHe
 * @date 2018/10/6 13:50
 */
@Repository
public interface MessageRepository extends JpaRepository<LafMessage, Integer>, JpaSpecificationExecutor<LafMessage> {

    /**
     * Descriptions: 查询该物品所有的消息<p>
     *
     * @author SailHe
     * @date 2018/10/6 21:40
     */
    List<LafMessage> findAllByItemId(Integer itemId);
}
