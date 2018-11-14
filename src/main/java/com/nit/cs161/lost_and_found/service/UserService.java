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
    //String signInSystem(UserDTO unSignedUserDTO) throws Exception;

    /**
     * Descriptions: 用户注册<p>
     *
     * @author SailHe
     * @date 2018/10/4 16:41
     */
    String signUpSystem(UserDTO userDTO) throws Exception;
}

