package com.example.demo.controller;

import com.example.demo.bean.dataObject.AppVersion;
import com.example.demo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lenovo on 2017/10/13.
 */
@RestController
@RequestMapping("api/appVersion")
public class AppVersionController {
    @Autowired
    AppVersionService appVersionService;

    @GetMapping("/{name}")
    List<AppVersion> findByName(@PathVariable String name){
        return  appVersionService.findByName(name);
    }

}
