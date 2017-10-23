package com.example.demo.dao;

import com.example.demo.bean.database.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lenovo on 2017/10/12.
 */
public interface UserDao extends JpaRepository<User,Long>{
    public User findByAccountAndPassword(String account,String password);
}
