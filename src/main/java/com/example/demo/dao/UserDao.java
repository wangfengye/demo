package com.example.demo.dao;

import com.example.demo.bean.database.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lenovo on 2017/10/12.
 */
public interface UserDao extends JpaRepository<User,Long>{
    /**
     *验证登录
     * @param account 账号
     * @param password 密码
     * @return User
     */
    User findByAccountAndPassword(String account,String password);

    /**
     * 查询用户
     * @param account 用户
     * @return User
     */
    User findByAccount(String account);
}
