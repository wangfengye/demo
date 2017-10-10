package com.example.demo.api;

import com.example.demo.bean.dataObject.User;
import com.example.demo.bean.responseBean.ResponseDefault;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lenovo on 2017/9/15.
 */
@RestController
@RequestMapping(value = "/user")
public class UserApi {
    @Autowired
    UserDao userDao;

    @GetMapping("/check")
    ResponseDefault checkAccount(@RequestParam String account, @RequestParam String password) {
        User user = userDao.findByAccount(account);
        ResponseDefault result = new ResponseDefault(null);
        if (password.equals(user.getPassword())) {
            result.setData(true);
        } else {
            result.setData(false);
        }
        return result;
    }

    @PostMapping("")
    ResponseDefault addAccount(@RequestParam String account, @RequestParam String password) {
        User data = userDao.save(new User(account, password));
        ResponseDefault result = new ResponseDefault(data);
        return result;
    }
}
