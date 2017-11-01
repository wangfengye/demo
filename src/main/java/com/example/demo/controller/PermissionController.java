package com.example.demo.controller;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("")
    @SuppressWarnings("unused")
    List<SysPermission> getPermissions() {
        return permissionService.findAll();
    }

    @PostMapping("")
    @SuppressWarnings("unused")
    SysPermission createPermission(String permission, String description) {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setPermission(permission);
        sysPermission.setDescription(description);
        return permissionService.createPermission(sysPermission);
    }

    @PutMapping("/{permissionId}")
    @SuppressWarnings("unused")
    SysPermission updatePermission(@PathVariable Long permissionId, String permission, String description, boolean available) {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setId(permissionId);
        sysPermission.setPermission(permission);
        sysPermission.setDescription(description);
        sysPermission.setAvailable(available);
        return permissionService.updatePermission(sysPermission);
    }

    @DeleteMapping("/{permissionId}")
    @SuppressWarnings("unused")
    ResponseDefault deletePermission(@PathVariable Long permissionId) {
        permissionService.deletePermission(permissionId);
        return new ResponseDefault();
    }
}
