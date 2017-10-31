package com.example.demo.service;

import com.example.demo.bean.database.SysPermission;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
public interface PermissionService {
    /**
     * 创建权限
     * @param permission 权限符
     * @return SysPermission
     */
    SysPermission createPermission(SysPermission permission);

    /**
     * 删除权限
     * @param permission 权限符
     */
    void deletePermission(SysPermission permission);

    /**
     * 删除权限
     * @param id 编号
     */
    void deletePermission(Long id);
    /**
     *  查找权限
     * @param id 编号
     * @return SysPermission
     */
    SysPermission findPermission(Long id);

}
