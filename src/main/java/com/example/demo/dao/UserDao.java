package com.example.demo.dao;


import com.example.demo.bean.dataObject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lenovo on 2017/9/15.
 */

public interface UserDao extends JpaRepository<User,Long> {
   User findByAccount(String account);

}
