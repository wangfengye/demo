package com.example.demo.service.impl;

import com.example.demo.bean.database.User;
import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/10/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public User findByAccountAndPassword(String account, String password) {
        return  userDao.findByAccountAndPassword(account,password);
    }
}
