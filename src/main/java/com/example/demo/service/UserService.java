package com.example.demo.service;

import com.example.demo.bean.database.User;

import java.util.Set;

/**
 * @author wangfeng
 * @date 2017/10/23
 */
public interface UserService {
    /**
     * 创建用户
     * @param user 用户
     * @return User
     */
    User createUser(User user);

    /**
     * 修改密码
     * @param userId 用户id
     * @param newPassword 用户密码
     */
    void changePassword(Long userId,String newPassword);

    /**
     * 添加 用户-角色关系
     * @param userId 用户id
     * @param roleIds 角色id
     */
    void correlationRoles(Long userId,Long... roleIds);

    /**
     * 删除用户-角色关系
     * @param userId 用户id
     * @param roleIds 角色id
     */
    void unCorrelationRoles(Long userId,Long... roleIds);

    /**
     * 验证登录
     * @param account 账号
     * @param password 密码
     * @return User
     */
    User findByAccountAndPassword(String account, String password);

    /**
     * 账号名查角色
     * @param account 账号
     * @return 角色集合
     */
    Set<String> findRoles(String account);

    /**
     * 账号查权限
     * @param account 账号
     * @return 权限集合
     */
    Set<String> findPermissions(String account);

}
