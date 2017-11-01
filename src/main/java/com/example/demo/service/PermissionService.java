package com.example.demo.service;

import com.example.demo.bean.database.SysPermission;

import java.util.List;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
public interface PermissionService {
    /**
     *  查询所有 SysPermission
     * @return List
     */
    List<SysPermission> findAll();
    /**
     * 创建权限
     * @param permission SysPermission
     * @return SysPermission
     */
    SysPermission createPermission(SysPermission permission);

    /**
     * 修改权限
     * @param permission SysPermission
     * @return SysPermission
     */
    SysPermission updatePermission(SysPermission permission);

    /**
     * 删除权限
     * @param permission SysPermission
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
