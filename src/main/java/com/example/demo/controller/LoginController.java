package com.example.demo.controller;

import com.example.demo.bean.response.ResponseDefault;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/10/13.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping("/")
    ResponseDefault<String> logIn(String username, String password){
        ResponseDefault<String> responseDefault =new ResponseDefault<>("登录成功");
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);

        }catch (AuthenticationException e){
            responseDefault.setStatus(500);
            responseDefault.setMessage("身份验证失败");
        }


        return responseDefault;
    }
    @RequestMapping("/403")
    String fail(){
        return "error/403";
    }
    @RequestMapping("out")
    String logout(){
        return "logout";
    }
}
