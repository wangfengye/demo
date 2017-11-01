package com.example.demo.service.impl;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.dao.SysPermissionDao;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@Service
public class PermisssionServiceImpl implements PermissionService {
    @Autowired
    SysPermissionDao dao;

    @Override
    public List<SysPermission> findAll() {
        return dao.findAll();
    }

    @Override
    public SysPermission createPermission(SysPermission permission) {
        SysPermission savedPermission = dao.save(permission);
        return savedPermission;
    }

    @Override
    public SysPermission updatePermission(SysPermission permission) {
        SysPermission permissionSaved = dao.findOne(permission.getId());
        if (permissionSaved ==null){
            return null;
        }
        if (permission.getDescription()!=null){
            permissionSaved.setDescription(permission.getDescription());
        }
        if (permission.getPermission()!=null){
            permissionSaved.setPermission(permission.getPermission());
        }
        if (permission.getAvailable()!=null){
            permissionSaved.setAvailable(permission.getAvailable());
        }
        return dao.save(permissionSaved);
    }

    @Override
    public void deletePermission(SysPermission permission) {
        dao.delete(permission);
    }

    @Override
    public void deletePermission(Long id) {
        dao.delete(id);
    }

    @Override
    public SysPermission findPermission(Long id) {
        return dao.findOne(id);
    }
}
