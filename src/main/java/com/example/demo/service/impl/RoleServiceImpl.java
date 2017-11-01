package com.example.demo.service.impl;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.bean.database.SysRole;
import com.example.demo.dao.SysRoleDao;
import com.example.demo.service.PermissionService;
import com.example.demo.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@Service
public class RoleServiceImpl implements RoleService {
    Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    SysRoleDao dao;
    @Autowired
    PermissionService permissionService;

    @Override
    public List<SysRole> findAll() {
        return dao.findAll();
    }

    @Override
    public SysRole findOne(Long id) {
        return dao.findOne(id);
    }

    @Override
    public SysRole createRole(SysRole role) {
        return dao.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        dao.delete(id);
    }

    @Override
    public void deleteRole(SysRole role) {
        dao.delete(role);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        SysRole role = dao.findOne(roleId);
        List<SysPermission> permissions = role.getPermissions();
        if (permissions == null) {
            permissions = new ArrayList<>();
        }
        for (int i = 0; i < permissionIds.length; i++) {
            SysPermission permission = permissionService.findPermission(permissionIds[i]);
            if (permission != null && !permissions.contains(permission)) {
                permissions.add(permission);
                logger.info("添加成功");
            } else {
                logger.info("重复权限");
            }
        }
        role.setPermissions(permissions);
        dao.save(role);
    }

    @Override
    public void unCorrelationPermissions(Long roleId, Long... permissionIds) {
        SysRole role = dao.findOne(roleId);
        List<SysPermission> permissions = role.getPermissions();
        if (permissions == null) {
            permissions = new ArrayList<>();
        }
        for (int i = 0; i < permissionIds.length; i++) {
            SysPermission permission = permissionService.findPermission(permissionIds[i]);
            if (permission != null && !permissions.contains(permission)) {
                logger.info("无此权限");
            } else {
                permissions.remove(permission);
                logger.info("删除权限");
            }
        }
        role.setPermissions(permissions);
        dao.save(role);
    }
}
