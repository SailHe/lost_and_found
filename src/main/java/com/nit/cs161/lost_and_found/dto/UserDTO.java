package com.nit.cs161.lost_and_found.dto;

import com.nit.cs161.lost_and_found.entity.SysUser;
import com.nit.cs161.lost_and_found.utility.BaseDTO;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * Description: 用户传输类<p>
 *
 * @Package: com.nit.cs161.lost_and_found.entity
 * @author: SailHe
 * @date: 2018/10/1 15:15
 */
public class UserDTO extends BaseDTO<SysUser> {
    private Integer userId;
    private String userName;
    private String userRealname;
    private String userNickname;
    private Integer userAge;
    private String userPassword;
    private String userSex;
    private Byte userRole;
    private String userEmail;
    private String userContactWay;
    private String userAvatarUrl;
    private String userToken;
    private String userLastLoginIp;
    private Timestamp userLastLoginTime;
    private Timestamp createTime;
    private Timestamp editTime;

    public UserDTO() {
        super(SysUser.class);
    }

    public UserDTO(SysUser bean) {
        super(SysUser.class);
        BeanUtils.copyProperties(bean, this);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Byte getUserRole() {
        return userRole;
    }

    public void setUserRole(Byte userRole) {
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContactWay() {
        return userContactWay;
    }

    public void setUserContactWay(String userContactWay) {
        this.userContactWay = userContactWay;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    public Timestamp getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Timestamp userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userAge=" + userAge +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userRole=" + userRole +
                ", userEmail='" + userEmail + '\'' +
                ", userContactWay='" + userContactWay + '\'' +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                ", userToken='" + userToken + '\'' +
                ", userLastLoginIp='" + userLastLoginIp + '\'' +
                ", userLastLoginTime=" + userLastLoginTime +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                '}';
    }
}
