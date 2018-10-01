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
    String loginIn(String phone, String password) throws Exception;

    /**
     * Descriptions: 用token获取记录<p>
     *
     * @author SailHe
     * @date 2018/10/1 17:29
     */
    UserDTO getTokenRecord(String token) throws Exception;

    UserDTO findByUserPhone(String userPhone);

    UserDTO getRecord(String userName) throws Exception;

    /** 用户注发送验证码*/
    int registerToApp(String userPhone);

    /**
     * Descriptions: 模糊查询用户<p>
     *
     * @author SailHe
     * @date 2018/10/1 21:53
     */
    List<UserDTO> listFuzzyUser(String search);

    /** 根据手机号检查用户是否存在 By CaiTieZhu*/
    boolean checkUserExist(String userPhone);
}

