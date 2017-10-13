package com.example.demo.service;

import com.example.demo.bean.dataObject.User;

/**
 * Created by lenovo on 2017/10/13.
 */

public interface UserService {
    User findByAccountAndPassword(String account, String password);

}
