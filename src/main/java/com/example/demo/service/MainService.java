package com.example.demo.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lenovo on 2017/9/15.
 */
@Controller
public class MainService {
    @RequestMapping("/index")
    String home() {
        return "index";
    }

    @RequestMapping("/history")
    String history(@RequestParam String name) {
        return "/history";
    }

    @RequestMapping("/addApk")
    String addApk() {
        return "/addApk";
    }

    @RequestMapping("/")
    String manage() {
        return "/manage";
    }
    @RequestMapping("/test")
    String test(){
        return "test";
    }
}
