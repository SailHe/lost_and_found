package com.nit.cs161.lost_and_found.service.impl;

import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.repository.UserRepository;
import com.nit.cs161.lost_and_found.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Descriptions: 用户业务逻辑实现<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:56
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserRepository userRepository;

    @Override
    public String signUpSystem(UserDTO userDTO) throws Exception {
        userRepository.save(userDTO.toBean());
        return "注册成功!";
    }

    @Override
    public UserDTO getRecord(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Integer deleteRecord(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Integer updateRecord(UserDTO record) throws Exception {
        return null;
    }

    @Override
    public Integer saveRecord(UserDTO record) throws Exception {
        return null;
    }

    @Override
    public Integer insertRecord(UserDTO record) throws Exception {
        return null;
    }
}
