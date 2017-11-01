package com.example.demo.controller;

import com.example.demo.bean.database.SysRole;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 暂时无法接受非 post get请求参数 添加 使用时使用post方式 添加 字段 _method = 真实请求方式
 *
 * @author wangfeng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    RoleService service;

    @GetMapping("")
    @SuppressWarnings("unused")
    List<SysRole> getRoles() {
        return service.findAll();
    }

    @PostMapping("")
    @SuppressWarnings("unused")
    SysRole createRole(String role, String description) {
        SysRole sysRole = new SysRole();
        sysRole.setRole(role);
        sysRole.setDescription(description);

        return service.createRole(sysRole);
    }

    @DeleteMapping("/{roleId}")
    @SuppressWarnings("unused")
    ResponseDefault deleteRole(@PathVariable Long roleId) {
        service.deleteRole(roleId);
        return new ResponseDefault();
    }

    @PostMapping("/correlation")
    @SuppressWarnings("unused")
    ResponseDefault correlation(Long roleId, Long permissionId) {
        service.correlationPermissions(roleId, permissionId);
        return new ResponseDefault();
    }

    @DeleteMapping("/correlation")
    @SuppressWarnings("unused")
    ResponseDefault unCorrelation(Long roleId, Long permissionId) {
        String info = "unCorrelation: " + roleId + ", " + permissionId;
        logger.info(info);
        service.unCorrelationPermissions(roleId, permissionId);
        return new ResponseDefault();
    }

}
