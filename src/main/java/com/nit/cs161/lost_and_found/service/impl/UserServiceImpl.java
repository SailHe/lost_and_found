package com.nit.cs161.lost_and_found.service.impl;

import com.nit.cs161.lost_and_found.constant.general.EnumIs;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.entity.SysUser;
import com.nit.cs161.lost_and_found.repository.UserRepository;
import com.nit.cs161.lost_and_found.service.UserService;
import com.nit.cs161.lost_and_found.shiroutils.JWTUtil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
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
        List<SysUser> sysUsers = userRepository.findAllByUserUsername(userName);
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
        List<SysUser> userBeanList = userRepository.findAllByUserUsernameLike(search);
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
    public String signInSystem(String userUsername, String userPassword) throws Exception {
        SysUser userBean = getBeanByUserName(userUsername);
        String token = null;
        if (userPassword.equals(userBean.getUserPassword())) {
            token = JWTUtil.signature(userUsername, userPassword);
            userBean.setUserToken(token + userUsername);
        }
        return token;
    }

    @Override
    public String signUpSystem(UserDTO userDTO) throws Exception {
        String usernameFieldName = "userUsername";
        String emailFieldName = "userEmailAddress";
        String result;
        if (isUserExist(usernameFieldName, userDTO.getUserUsername()).equals(EnumIs.NO)) {
            if (isUserExist(emailFieldName, userDTO.getUserEmailAddress()).equals(EnumIs.NO)) {
                userRepository.save(userDTO.toBean());
                result = "注册成功!";
            } else {
                result = "该邮箱已注册!!";
            }
        } else {
            result = "用户名已存在!";
        }
        return result;
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
        if (userRepository.findAllByUserUsername(userName).isEmpty()) {
            return EnumIs.NO;
        }
        return EnumIs.YES;
    }

    /**
     * Descriptions: 检查传入参数键值对 对应的用户是否已被注册<p>
     *
     * @author SailHe
     * @date 2018/10/4 20:20
     */
    private EnumIs isUserExist(String fieldName, String fieldValue) {
        Specification<SysUser> specification = (root, criteriaQuery, criteriaBuilder) -> {
            //过滤条件
            Predicate filter;
            filter = criteriaBuilder.and(criteriaBuilder.equal(root.get(fieldName), fieldValue));
            return filter;
        };
        return userRepository.findAll(specification).isEmpty() ? EnumIs.NO : EnumIs.YES;
    }
}
