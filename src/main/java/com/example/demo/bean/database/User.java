package com.example.demo.bean.database;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lenovo on 2017/9/15.
 * 用户表
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,nullable = false)
    private String account;
    private String password;
    /**
     * 加密的盐
     */
    private String salt;
    /**
     * 用户状态: 0:未认证 ,1:正常使用,2:锁定
     */
    private byte state;
    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name="uid")},inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
