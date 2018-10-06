package com.nit.cs161.lost_and_found.repository;

import com.nit.cs161.lost_and_found.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Descriptions: 用户持久层<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:57
 */
@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer>, JpaSpecificationExecutor<SysUser> {

    /*@Query(value = "SELECT userPassword FROM SysUser WHERE userPhone = ?1 ")
    String getPassword(String userPhone) throws Exception;*/

//    List<SysUser> findAllByUserPhone(String userPhone);

    /**
     * Descriptions: 根据用户名查询(用户名应当唯一)<p>
     *
     * @author SailHe
     * @date 2018/10/1 16:18
     */
    List<SysUser> findAllByUserUsername(String userUserName);

    List<SysUser> findAllByUserEmailAddress(String userEmailAddress);

    List<SysUser> findAllByUserUsernameOrUserEmailAddress(String userUserName, String userEmailAddress);

    /**
     * Descriptions: 用于模糊查询<p>
     *
     * @author SailHe
     * @date 2018/10/1 21:49
     */
    List<SysUser> findAllByUserUsernameLikeOrUserNicknameLikeOrUserRealnameLikeOrUserEmailAddressLike(String userUserName, String userRealName, String userNickName, String userEmail);

    List<SysUser> findAllByUserUsernameLike(String userUserName);
}
