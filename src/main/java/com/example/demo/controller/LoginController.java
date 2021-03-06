package com.example.demo.controller;

import com.example.demo.bean.database.User;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfeng
 * Created by lenovo on 2017/10/13.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService service;
    @PostMapping("")
    @SuppressWarnings("unused")
    ResponseDefault<String> logIn (String username, String password){
        ResponseDefault responseDefault =new ResponseDefault<>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            User user=service.findByAccountAndPassword(username,password);
            responseDefault.setData(user.getRoles());
        }catch (AuthenticationException e){
            responseDefault.setStatus(500);
            responseDefault.setMessage("身份验证失败");
        }
        return responseDefault;
    }
    @RequestMapping("/403")
    String fail(){
        return "403";
    }
    @RequestMapping("out")
    String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            subject.logout();
        }
        return "logout";
    }
}
