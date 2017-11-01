package com.example.demo.controller;

import com.example.demo.bean.database.User;
import com.example.demo.bean.response.ResponseDefault;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("")
    @SuppressWarnings("unused")
    List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("")
    @SuppressWarnings("unused")
    ResponseDefault createUser(String account, String password) {
        User user = new User(account, password);
        userService.createUser(user);
        return new ResponseDefault<>("success");
    }

    @PutMapping("/{userId}")
    @SuppressWarnings("unused")
    ResponseDefault changePassword(@PathVariable Long userId, String newPassword) {
        userService.changePassword(userId, newPassword);
        ResponseDefault<String> responseDefault = new ResponseDefault<>("success");
        return responseDefault;
    }

    @DeleteMapping("/{userId}")
    @SuppressWarnings("unused")
    ResponseDefault changePassword(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseDefault<>("success");
    }

    @PostMapping("/correlation")
    @SuppressWarnings("unused")
    ResponseDefault correlation(Long userId, Long roleId) {
        userService.correlationRoles(userId, roleId);
        return new ResponseDefault();
    }

    @DeleteMapping("/correlation")
    @SuppressWarnings("unused")
    ResponseDefault unCorrelation(Long userId, Long roleId) {
        userService.unCorrelationRoles(userId, roleId);
        return new ResponseDefault();
    }
}
