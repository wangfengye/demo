package com.example.demo.controller;

import com.example.demo.bean.database.User;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("")
    ResponseDefault createUser(String account, String password){
        User user =new User(account,password);
        userService.createUser(user);
        ResponseDefault<String> responseDefault= new ResponseDefault<>("success");
        return responseDefault;
    }
    @PostMapping("/{userId}")
    ResponseDefault changePassword(@PathVariable Long userId, String newPassword){
        userService.changePassword(userId,newPassword);
        ResponseDefault<String> responseDefault= new ResponseDefault<>("success");
        return responseDefault;
    }
}
