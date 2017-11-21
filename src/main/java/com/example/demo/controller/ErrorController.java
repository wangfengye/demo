package com.example.demo.controller;

/**
 * @author wangfeng
 * Created by lenovo on 2017/10/13.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/403")
    String error403() {
        return "error/403";
    }
}
