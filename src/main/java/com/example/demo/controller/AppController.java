package com.example.demo.controller;

import com.example.demo.bean.database.App;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.bean.vo.AppVo;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lenovo on 2017/10/13.
 */
@RestController
@RequestMapping("/api/app")
public class AppController {
    @Autowired
    AppService appService;

    @RequestMapping("")
    public List<AppVo> findAllApp() {
        return appService.findAll();
    }

    @RequestMapping("/{name}")
    public App findByName(@PathVariable String name) {
        return appService.findByName(name);
    }

    @PostMapping("")
    ResponseDefault saveApp(@RequestParam String name,
                            @RequestParam String version,
                            @RequestParam int code,
                            @RequestParam String apkUrl,
                            @RequestParam String desc,
                            @RequestParam String updateDate) {
        Boolean isSuccess = appService.saveApp(name, version, code, apkUrl, desc, updateDate);
        ResponseDefault<String> responseDefault = new ResponseDefault<>(null);
        if (!isSuccess) {
            responseDefault.setStatus(400);
            responseDefault.setMessage("error");
        }
        return responseDefault;
    }
}
