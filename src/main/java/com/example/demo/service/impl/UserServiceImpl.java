package com.example.demo.service.impl;

import com.example.demo.bean.database.User;
import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * UserServiceImpl
 *
 * @author wangfeng
 * @date 2017/10/23
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User createUser(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        userDao.save(user);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void unCorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public User findByAccountAndPassword(String account, String password) {
        return  userDao.findByAccountAndPassword(account,password);
    }

    @Override
    public Set<String> findRoles(String account) {
        User user = userDao.findByAccount(account);
        return null;
    }

    @Override
    public Set<String> findPermissions(String account) {
        return null;
    }
}
