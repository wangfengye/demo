package com.example.demo.controller;

import com.example.demo.bean.database.AppApply;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.AppApplyService;
import com.example.demo.utils.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangfeng
 *         on 2017/11/21
 */
@RestController
@RequestMapping("/api/app/apply")
public class AppApplyController {
    @Autowired
    AppApplyService service;

    @GetMapping("")
    // @RequiresRoles(value={"admin"})
    @SuppressWarnings("unused")
    public List<AppApply> findAll(){
        return service.findAll();
    }

    @PostMapping("")
    @SuppressWarnings("unused")
    String saveAppApply(@RequestParam String userName, String desc, String imei, String applyDate){
        service.saveApply(userName,desc,imei, applyDate);
        // 申请成功返回 密码
        return Tea.createKey(imei);
    }
    @DeleteMapping("/{id}")
    @SuppressWarnings("unused")
    ResponseDefault deleteById(@PathVariable Long id){
        service.deleteById(id);
        return new ResponseDefault<>("success");
    }
}
