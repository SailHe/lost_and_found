package com.nit.cs161.lost_and_found.dto;

import com.nit.cs161.lost_and_found.constant.general.ProjectConstants;
import com.nit.cs161.lost_and_found.entity.SysUser;
import com.nit.cs161.lost_and_found.utility.BaseDTO;
import com.nit.cs161.lost_and_found.utility.DateGenerator;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
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
    private String userUsername;
    private String userPassword;
    private String userRealname;
    private String userNickname;
    private String userAvatarUrl;
    private String userEmailAddress;
    private String userContactWay;
    private String userSex;
    private String userBirthday;
    private Byte userRole;
    private String userToken;
    private String userSignInIp;
    private Timestamp userSignInTime;
    private Timestamp createTime;
    private Timestamp editTime;

    public UserDTO() {
        super(SysUser.class);
        setEditTime(new Timestamp(System.currentTimeMillis()));
    }

    public UserDTO(SysUser bean) {
        super(SysUser.class);
        //如果有此类字段一定记得要手动实现转换toBean和bean的构造器两处方法
        this.setUserBirthday(new DateGenerator(bean.getUserBirthday()).toString());
        BeanUtils.copyProperties(bean, this);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserContactWay() {
        return userContactWay;
    }

    public void setUserContactWay(String userContactWay) {
        this.userContactWay = userContactWay;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Byte getUserRole() {
        return userRole;
    }

    public void setUserRole(Byte userRole) {
        this.userRole = userRole;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserSignInIp() {
        return userSignInIp;
    }

    public void setUserSignInIp(String userSignInIp) {
        this.userSignInIp = userSignInIp;
    }

    public Timestamp getUserSignInTime() {
        return userSignInTime;
    }

    public void setUserSignInTime(Timestamp userSignInTime) {
        this.userSignInTime = userSignInTime;
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
    public SysUser toBean() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SysUser bean = super.toBean();
        // 由于前端貌似无法传入时间戳类型, 于是如果存在需要前端传参的时间类型的话
        // 可考虑在DTO内使用Long(对应时间戳) 或 String(对应java.sql.Timestamp或java.util.Date), 然后重写父类方法, 将这些字段做手动转换
        // editTime之类的系统字段就不必这么做, 它目的主要是方便生成编辑时间, 而且构造器内不建议做其余任何逻辑计算
        // PS: 如果担心这种系统字段存在DTO内, 直接作为接口参数时会影响安全性, 可考虑从验证, 以及新建xxDataDTO类作为专属的参数数据类
        bean.setUserBirthday(new DateGenerator(ProjectConstants.DATE_FORMAT, this.getUserBirthday()).toTimestamp());
        return bean;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userUsername='" + userUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                ", userEmailAddress='" + userEmailAddress + '\'' +
                ", userContactWay='" + userContactWay + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userRole=" + userRole +
                ", userToken='" + userToken + '\'' +
                ", userSignInIp='" + userSignInIp + '\'' +
                ", userSignInTime=" + userSignInTime +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                '}';
    }
}
