package com.example.demo.service.impl;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.bean.database.SysRole;
import com.example.demo.bean.database.User;
import com.example.demo.dao.UserDao;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UserServiceImpl
 *
 * @author wangfeng
 * @date 2017/10/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleService roleService;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

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
    public void deleteUser(Long userId) {
        userDao.delete(userId);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        User user = userDao.findOne(userId);
        Set<SysRole> roles = user.getRoles();
        if (roles == null){
            roles = new HashSet<>();
        }
        for (int i = 0; i < roleIds.length; i++) {
            SysRole role = roleService.findOne(roleIds[i]);
            roles.add(role);
        }
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public void unCorrelationRoles(Long userId, Long... roleIds) {
        User user = userDao.findOne(userId);
        for (int i = 0; i < roleIds.length; i++) {
            SysRole role  =roleService.findOne(roleIds[i]);
            user.getRoles().remove(role);
        }
        userDao.save(user);
    }

    @Override
    public User findByAccountAndPassword(String account, String password) {
        return userDao.findByAccountAndPassword(account, password);
    }

    @Override
    public Set<String> findRoles(String account) {
        Set<String> sets = new HashSet<>();
        User user = userDao.findByAccount(account);
        Set<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            sets.add(role.getRole());
        }
        return sets;
    }

    @Override
    public Set<String> findPermissions(String account) {
        Set<String> sets = new HashSet<>();
        User user = userDao.findByAccount(account);
        Set<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            Set<SysPermission> permissions = role.getPermissions();
            for (SysPermission permisssion : permissions) {
                sets.add(permisssion.getPermission());
            }
        }
        return sets;
    }
}
