package com.nit.cs161.lost_and_found.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.cs161.lost_and_found.entity
 * @author: SailHe
 * @date: 2018/11/13 23:24
 */
@Entity
public class User {

    private Integer userId;
    private String userName;
    private String pwd;


    @Id
    //自增忘加了
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //使用hiberbate名称不能带大写
    @Basic
    @Column(name = "user_name", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "pwd", nullable = true, length = 30)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, pwd);
    }
}
