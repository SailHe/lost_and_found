package com.nit.cs161.lost_and_found.service;

import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.service.general.CrudService;

import java.util.List;

/**
 * Descriptions: 用户业务逻辑<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:43
 */
public interface UserService extends CrudService<UserDTO, Integer> {

    /**
     * Descriptions: 登录<p>
     *
     * @author SailHe
     * @date 2018/10/1 17:14
     */
    String signInSystem(UserDTO unSignedUserDTO) throws Exception;

    /**
     * Descriptions: 用户注册<p>
     *
     * @author SailHe
     * @date 2018/10/4 16:41
     */
    String signUpSystem(UserDTO userDTO) throws Exception;
    /**
     * Descriptions: 用户注销<p>
     *
     * @author SailHe
     * @date 2018/12/4 19:02
     */
    String signOutSystem(UserDTO userDTO) throws Exception;

    /**
     * Descriptions: 用token获取记录<p>
     *
     * @author SailHe
     * @date 2018/10/1 17:29
     */
    UserDTO getTokenRecord(String token) throws Exception;

    UserDTO getRecord(String userName) throws Exception;

    /**
     * Descriptions: 模糊查询用户<p>
     *
     * @author SailHe
     * @date 2018/10/1 21:53
     */
    List<UserDTO> listFuzzyUser(String search);

    /**
     * Descriptions: 重置密码<p>
     *
     * @author SailHe
     * @date 2018/11/13 18:59
     */
    String resetPassword(String userUsername, String userEmailAddress) throws Exception;

}

