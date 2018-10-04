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
     * Descriptions: 使用手机号登录<p>
     *
     * @author SailHe
     * @date 2018/10/1 16:23
     */
    String signIn(String phone, String password) throws Exception;

    /**
     * Descriptions: 用token获取记录<p>
     *
     * @author SailHe
     * @date 2018/10/1 17:29
     */
    UserDTO getTokenRecord(String token) throws Exception;

    UserDTO findByUserPhone(String userPhone);

    UserDTO getRecord(String userName) throws Exception;

    /**
     * Descriptions: 注册<p>
     *
     * @author SailHe
     * @date 2018/10/4 16:18
     */
    int signUpSystem(String userPhone);

    /**
     * Descriptions: 模糊查询用户<p>
     *
     * @author SailHe
     * @date 2018/10/1 21:53
     */
    List<UserDTO> listFuzzyUser(String search);

}

