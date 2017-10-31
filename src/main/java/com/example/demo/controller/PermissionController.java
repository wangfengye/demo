package com.example.demo.controller;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;
    @PostMapping("")
    @SuppressWarnings("unused")
    ResponseDefault createPermission(String permission, String description){
        SysPermission sysPermission= new SysPermission();
        sysPermission.setPermission(permission);
        sysPermission.setDescription(description);
        permissionService.createPermission(sysPermission);
        return new ResponseDefault();
    }
    @PostMapping("/delete/{permissionId}")
    @SuppressWarnings("unused")
    ResponseDefault deletePermission(@PathVariable Long permissionId){
        permissionService.deletePermission(permissionId);
        return new ResponseDefault();
    }
}
