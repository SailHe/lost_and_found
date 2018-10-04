package com.nit.cs161.lost_and_found.service.impl;

import com.nit.cs161.lost_and_found.constant.general.EnumIs;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.entity.SysUser;
import com.nit.cs161.lost_and_found.repository.UserRepository;
import com.nit.cs161.lost_and_found.service.UserService;
import com.nit.cs161.lost_and_found.shiroutils.JWTUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

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

    private SysUser getBeanByUserName(String userName) throws Exception {
        List<SysUser> sysUsers = userRepository.findAllByUserName(userName);
        SysUser resultUser = null;
        if (sysUsers.size() > 1) {
            throw new Exception("用户名重复!");
        } else if (sysUsers.isEmpty()) {
            // do nothing
        } else {
            resultUser = sysUsers.get(0);
        }
        return resultUser;
    }

    @Override
    public UserDTO getRecord(String userName) throws Exception {
        return new UserDTO(getBeanByUserName(userName));
    }

    @Override
    public List<UserDTO> listFuzzyUser(String search) {
        List<UserDTO> userDTOList = new LinkedList<>();
//        List<SysUser> userBeanList = userRepository.findAllByUserNameLikeOrUserNicknameLikeOrUserRealnameLikeOrUserEmailLike(search, search, search, search);
        List<SysUser> userBeanList = userRepository.findAllByUserNameLike(search);
        userBeanList.forEach(bean -> userDTOList.add(new UserDTO(bean)));
        return userDTOList;
    }

    @Override
    public UserDTO getRecord(Integer integer) throws Exception {
        return new UserDTO(userRepository.findOne(integer));
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

    /**
     * Descriptions: 登录<p>
     *
     * @author SailHe
     * @date 2018/10/1 17:14
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String signInSystem(String userName, String userPassword) throws Exception {
        SysUser userBean = getBeanByUserName(userName);
        String token  = null;
        if (userPassword.equals(userBean.getUserPassword())) {
            token = JWTUtil.signature(userName, userPassword);
            userBean.setUserToken(token + userName);
        }
        return token;
    }

    @Override
    public String signUpSystem(String userName, String signUpPassword) throws Exception {
        if (isUserExist(userName).equals(EnumIs.NO)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(userName);
            userDTO.setUserPassword(signUpPassword);
            userRepository.save(userDTO.toBean());
            //向phoneMessage 插入验证码短信
            //phoneMessageRepository.sendMessageToApp(userName);
            return "注册成功!";
        } else {
            return "用户名已存在!";
        }
    }

    @Override
    public UserDTO getTokenRecord(String token) throws Exception {
        String username = JWTUtil.getUsernameInToken(token);
        return getRecord(username);
    }

    /**
     * Descriptions: 检查用户是否已被注册<p>
     *
     * @author SailHe
     * @date 2018/10/1 16:29
     */
    private EnumIs isUserExist(String userName) {
        if (userRepository.findAllByUserName(userName).isEmpty()){
            return EnumIs.NO;
        }
        return EnumIs.YES;
    }
}
