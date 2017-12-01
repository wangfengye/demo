package com.example.demo.controller;

import com.example.demo.bean.database.AppVersion;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangfeng
 * Created by lenovo on 2017/10/13.
 */
@RestController
@RequestMapping("api/appVersion")
public class AppVersionController {
    @Autowired
    AppVersionService appVersionService;

    @GetMapping("/{name}")
    @SuppressWarnings("unused")
    List<AppVersion> findByName(@PathVariable String name){
        return  appVersionService.findByName(name);
    }
    @DeleteMapping("/{id}")
    @SuppressWarnings("unused")
    ResponseDefault deleteById(@PathVariable Long id){
        appVersionService.deleteById(id);
        return new ResponseDefault<>("success");
    }
}
