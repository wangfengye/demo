package com.example.demo.service;

import com.example.demo.bean.database.SysRole;

/**
 * Created by lenovo on 2017/10/31.
 */
public interface RoleService {
    /**
     * 创建角色
     * @param role 角色
     * @return SysRole
     */
    SysRole createRole(SysRole role);

    /**
     * 删除角色
     * @param role 角色
     */
    void deleteRole(SysRole role);

    /**
     * 添加角色-权限关系
     * @param roleId role id
     * @param permissionIds permission id数组
     * @return 是否成功
     */
    void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限关系
     * @param roleId 角色id
     * @param permissionIds  permission id数组
     */
    void unCorrelationPermissions(Long roleId,Long... permissionIds);


}
