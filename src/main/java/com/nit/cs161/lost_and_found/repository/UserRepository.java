package com.nit.cs161.lost_and_found.repository;

import com.nit.cs161.lost_and_found.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Descriptions: 用户持久层<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:57
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}
