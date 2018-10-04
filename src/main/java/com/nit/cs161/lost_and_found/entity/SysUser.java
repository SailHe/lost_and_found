package com.nit.cs161.lost_and_found.entity;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.cs161.lost_and_found.entity
 * @author: 何 帆
 * @date: 2018/10/4 19:45
 */
@Entity
@Table(name = "sys_user", schema = "lost_and_found", catalog = "")
public class SysUser {
    private Integer userId;
    private String userUsername;
    private String userPassword;
    private String userRealname;
    private String userNickname;
    private String userAvatarUrl;
    private String userEmailAddress;
    private String userContactWay;
    private String userSex;
    private Date userBirthday;
    private Byte userRole;
    private String userToken;
    private String userSignInIp;
    private Timestamp userSignInTime;
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
    @Column(name = "user_username", nullable = true, length = 50)
    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
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
    @Column(name = "user_avatar_url", nullable = true, length = 128)
    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    @Basic
    @Column(name = "user_email_address", nullable = true, length = 50)
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
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
    @Column(name = "user_sex", nullable = true, length = 4)
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_birthday", nullable = true)
    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
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
    @Column(name = "user_token", nullable = true, length = 60)
    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @Basic
    @Column(name = "user_sign_in_ip", nullable = true, length = 20)
    public String getUserSignInIp() {
        return userSignInIp;
    }

    public void setUserSignInIp(String userSignInIp) {
        this.userSignInIp = userSignInIp;
    }

    @Basic
    @Column(name = "user_sign_in_time", nullable = true)
    public Timestamp getUserSignInTime() {
        return userSignInTime;
    }

    public void setUserSignInTime(Timestamp userSignInTime) {
        this.userSignInTime = userSignInTime;
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
        return Objects.equals(userId, sysUser.userId) &&
                Objects.equals(userUsername, sysUser.userUsername) &&
                Objects.equals(userPassword, sysUser.userPassword) &&
                Objects.equals(userRealname, sysUser.userRealname) &&
                Objects.equals(userNickname, sysUser.userNickname) &&
                Objects.equals(userAvatarUrl, sysUser.userAvatarUrl) &&
                Objects.equals(userEmailAddress, sysUser.userEmailAddress) &&
                Objects.equals(userContactWay, sysUser.userContactWay) &&
                Objects.equals(userSex, sysUser.userSex) &&
                Objects.equals(userBirthday, sysUser.userBirthday) &&
                Objects.equals(userRole, sysUser.userRole) &&
                Objects.equals(userToken, sysUser.userToken) &&
                Objects.equals(userSignInIp, sysUser.userSignInIp) &&
                Objects.equals(userSignInTime, sysUser.userSignInTime) &&
                Objects.equals(createTime, sysUser.createTime) &&
                Objects.equals(editTime, sysUser.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userUsername, userPassword, userRealname, userNickname, userAvatarUrl, userEmailAddress, userContactWay, userSex, userBirthday, userRole, userToken, userSignInIp, userSignInTime, createTime, editTime);
    }
}
