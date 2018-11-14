package com.nit.cs161.lost_and_found.dto;

import com.nit.cs161.lost_and_found.entity.User;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.cs161.lost_and_found.dto
 * @author: SailHe
 * @date: 2018/11/13 23:28
 */
public class UserDTO {
    private Integer userId;
    private String userName;
    private String pwd;

    public UserDTO(){}

    public UserDTO(User bean) {
        this.setUserId(bean.getUserId());
        this.setUserName(bean.getUserName());
        this.setPwd(bean.getPwd());
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User toBean() {
        User bean = new User();
        bean.setUserId(this.getUserId());
        bean.setUserName(this.getUserName());
        bean.setPwd(this.getPwd());
        return bean;
    }
}
