package com.example.demo.service.impl;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.bean.database.SysRole;
import com.example.demo.bean.database.User;
import com.example.demo.dao.UserDao;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class UserServiceImpl implements UserService{

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
        List<SysRole> roles = user.getRoleList();
        if (roles ==null){
            roles = new ArrayList<>();
        }
        for (int i = 0; i < roleIds.length; i++) {
            SysRole role = roleService.findOne(roleIds[i]);
            if (role!=null && !roles.contains(role)){
                roles.add(role);
            }else {
                // 已拥有此权限
            }
        }
        user.setRoleList(roles);
        userDao.save(user);
    }

    @Override
    public void unCorrelationRoles(Long userId, Long... roleIds) {
        User user = userDao.findOne(userId);
        List<SysRole> roles = user.getRoleList();
        if (roles ==null){
            roles = new ArrayList<>();
        }
        for (int i = 0; i < roleIds.length; i++) {
            SysRole role = roleService.findOne(roleIds[i]);
            if (role!=null && !roles.contains(role)){
                // 无此权限
            }else {
                roles.remove(role);
            }
        }
        user.setRoleList(roles);
        userDao.save(user);
    }

    @Override
    public User findByAccountAndPassword(String account, String password) {
        return  userDao.findByAccountAndPassword(account,password);
    }

    @Override
    public Set<String> findRoles(String account) {
        User user = userDao.findByAccount(account);
        Set<String> sets= new HashSet<>();
        List<SysRole> roles = user.getRoleList();
        for (int i = 0; i < roles.size(); i++) {
            sets.add(roles.get(i).getRole());
        }
        return sets;
    }

    @Override
    public Set<String> findPermissions(String account) {
        User user = userDao.findByAccount(account);
        Set<String> sets= new HashSet<>();
        List<SysRole> roles = user.getRoleList();
        for (int i = 0; i < roles.size(); i++) {
            List<SysPermission> permissions = roles.get(i).getPermissions();
            for (int j = 0; j < permissions.size() ; j++) {
                sets.add(permissions.get(j).getPermission());
            }
        }
        return sets;
    }
}
