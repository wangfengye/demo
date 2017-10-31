package com.example.demo.service.impl;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.dao.SysPermissionDao;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@Service
public class PermisssionServiceImpl implements PermissionService {
    @Autowired
    SysPermissionDao dao;

    @Override
    public SysPermission createPermission(SysPermission permission) {
        SysPermission savedPermission = dao.save(permission);
        return savedPermission;
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
