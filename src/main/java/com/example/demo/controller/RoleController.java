package com.example.demo.controller;

import com.example.demo.bean.database.SysRole;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    RoleService service;
    @PostMapping("")
    @SuppressWarnings("unused")
    ResponseDefault createRole(String role,String description){
        SysRole sysRole =new SysRole();
        sysRole.setRole(role);
        sysRole.setDescription(description);
        service.createRole(sysRole);
        return  new ResponseDefault();
    }
    @PostMapping("/delete/{role}")
    @SuppressWarnings("unused")
    ResponseDefault deleteRole(@PathVariable String role){
        SysRole sysRole =new SysRole();
        sysRole.setRole(role);
        service.deleteRole(sysRole);
        return  new ResponseDefault();
    }
    @PostMapping("/correlation")
    @SuppressWarnings("unused")
    ResponseDefault correlation(Long roleId,Long permissionId){
        service.correlationPermissions(roleId,permissionId);
        return new ResponseDefault();
    }
    @PostMapping("/delete/unCorrelation")
    @SuppressWarnings("unused")
    ResponseDefault unCorrelation(Long roleId,Long permissionId){
        String info= "unCorrelation: "+roleId+", "+permissionId;
        logger.info(info);
        service.unCorrelationPermissions(roleId,permissionId);
        return new ResponseDefault();
    }

}
