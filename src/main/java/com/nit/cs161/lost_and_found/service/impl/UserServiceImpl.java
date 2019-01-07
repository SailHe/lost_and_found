package com.nit.cs161.lost_and_found.service.impl;

import com.nit.cs161.lost_and_found.constant.general.EnumIs;
import com.nit.cs161.lost_and_found.constant.general.EnumUserType;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.entity.SysUser;
import com.nit.cs161.lost_and_found.repository.UserRepository;
import com.nit.cs161.lost_and_found.service.UserService;
import com.nit.cs161.lost_and_found.shiroutils.JWTUtil;
import com.nit.cs161.lost_and_found.utility.SecureHashStandard;
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

    private SecureHashStandard sha512 = new SecureHashStandard(SecureHashStandard.EnumSHAType.SHA_512);

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

    private SysUser getBeanByUserEmailAddress(String userEmailAddress) throws Exception {
        List<SysUser> sysUsers = userRepository.findAllByUserEmailAddress(userEmailAddress);
        SysUser resultUser = null;
        if (sysUsers.size() > 1) {
            throw new Exception("用户邮箱地址重复!");
        } else if (sysUsers.isEmpty()) {
            // do nothing
        } else {
            resultUser = sysUsers.get(0);
        }
        return resultUser;
    }

    private SysUser getBeanByIdentityField(String identityField) throws Exception {
        List<SysUser> sysUsers = userRepository.findAllByUserUsernameOrUserEmailAddress(identityField, identityField);
        SysUser resultUser = null;
        if (sysUsers.size() > 1) {
            throw new Exception("标识域重复!");
        } else if (sysUsers.isEmpty()) {
            // do nothing
        } else {
            resultUser = sysUsers.get(0);
        }
        return resultUser;
    }

    @Override
    public UserDTO getRecord(String userName) throws Exception {
        SysUser bean = getBeanByUserName(userName);
        return bean == null ? null : new UserDTO(bean);
    }

    @Override
    public List<UserDTO> listFuzzyUser(String search) {
        List<UserDTO> userDTOList = new LinkedList<>();
        List<SysUser> userBeanList = userRepository.findAllByUserUsernameLike(search);
        userBeanList.forEach(bean -> userDTOList.add(new UserDTO(bean)));
        return userDTOList;
    }

    @Override
    public String resetPassword(String userUsername, String userEmailAddress) throws Exception {
        String result;
        SysUser user = getBeanByUserName(userUsername);
        if (user.getUserEmailAddress().equals(userEmailAddress)) {
            user.setUserPassword(sha512.calcHashValue("123456"));
            userRepository.save(user);
            //其实该发送给这个用户的邮箱 或者让用户重填 此处只是简略实现
            result = "重置成功!新密码123456";
        } else {
            result = "邮箱与用户名不符!";
        }
        return result;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String signInSystem(UserDTO unSignedUserDTO) throws Exception {
        String result;
        SysUser userBean = null;
        if (unSignedUserDTO.getUserUsername() != null) {
            userBean = getBeanByUserName(unSignedUserDTO.getUserUsername());
        } else if (userBean.getUserEmailAddress() != null) {
            userBean = getBeanByUserEmailAddress(unSignedUserDTO.getUserEmailAddress());
        } else {
            //identityField
            throw new Exception("支持且仅支持[用户名 或 邮箱地址]登录!");
        }

        if (userBean == null) {
            result = "用户不存在!";
        } else {
            String token, userUsername = userBean.getUserUsername();
            if (sha512.calcHashValue(unSignedUserDTO.getUserPassword())
                    .equals(userBean.getUserPassword())
            ) {
                token = JWTUtil.signature(userUsername, unSignedUserDTO.getUserPassword());
                userBean.setUserToken(token + userUsername);
                unSignedUserDTO.setUserToken(token);
                result = "登录成功!";
            } else {
                result = "密码错误!";
            }
        }
        return result;
    }

    @Override
    public String signUpSystem(UserDTO userDTO) throws Exception {
        String usernameFieldName = "userUsername";
        String emailFieldName = "userEmailAddress";
        String result;
        if (isUserExist(usernameFieldName, userDTO.getUserUsername()).equals(EnumIs.NO)) {
            if (isUserExist(emailFieldName, userDTO.getUserEmailAddress()).equals(EnumIs.NO)) {
                if (userDTO.getUserRole() == null) {
                    userDTO.setUserRole(EnumUserType.NORMAL.getValue());
                }
                userDTO.setUserPassword(sha512.calcHashValue(userDTO.getUserPassword()));
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
    public String signOutSystem(UserDTO userDTO) throws Exception {
        return "假装成功退出...";
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
