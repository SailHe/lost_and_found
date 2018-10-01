package com.nit.cs161.lost_and_found.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Description: 用户实体<p>
 *
 * @Package: com.nit.cs161.lost_and_found.entity
 * @author: SailHe
 * @date: 2018/10/1 17:00
 */
@Entity
@Table(name = "sys_user", schema = "lost_and_found", catalog = "")
public class SysUser {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_realname", nullable = true, length = 50)
    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    @Basic
    @Column(name = "user_nickname", nullable = true, length = 50)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "user_age", nullable = true)
    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "user_password", nullable = true, length = 50)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_sex", nullable = true, length = 4)
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_role", nullable = true)
    public Byte getUserRole() {
        return userRole;
    }

    public void setUserRole(Byte userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "user_email", nullable = true, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_contact_way", nullable = true, length = 50)
    public String getUserContactWay() {
        return userContactWay;
    }

    public void setUserContactWay(String userContactWay) {
        this.userContactWay = userContactWay;
    }

    @Basic
    @Column(name = "user_avatar_url", nullable = true, length = 128)
    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    @Basic
    @Column(name = "user_token", nullable = true, length = 60)
    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @Basic
    @Column(name = "user_last_login_ip", nullable = true, length = 20)
    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    @Basic
    @Column(name = "user_last_login_time", nullable = true)
    public Timestamp getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Timestamp userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "edit_time", nullable = true)
    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysUser sysUser = (SysUser) o;
        return userId.equals(sysUser.userId) &&
                Objects.equals(userName, sysUser.userName) &&
                Objects.equals(userRealname, sysUser.userRealname) &&
                Objects.equals(userNickname, sysUser.userNickname) &&
                Objects.equals(userAge, sysUser.userAge) &&
                Objects.equals(userPassword, sysUser.userPassword) &&
                Objects.equals(userSex, sysUser.userSex) &&
                Objects.equals(userRole, sysUser.userRole) &&
                Objects.equals(userEmail, sysUser.userEmail) &&
                Objects.equals(userContactWay, sysUser.userContactWay) &&
                Objects.equals(userAvatarUrl, sysUser.userAvatarUrl) &&
                Objects.equals(userToken, sysUser.userToken) &&
                Objects.equals(userLastLoginIp, sysUser.userLastLoginIp) &&
                Objects.equals(userLastLoginTime, sysUser.userLastLoginTime) &&
                Objects.equals(createTime, sysUser.createTime) &&
                Objects.equals(editTime, sysUser.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userRealname, userNickname, userAge, userPassword, userSex, userRole, userEmail, userContactWay, userAvatarUrl, userToken, userLastLoginIp, userLastLoginTime, createTime, editTime);
    }
}
