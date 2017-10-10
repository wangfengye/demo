package com.example.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2017/9/13.
 */
@Controller
public class Phone {

    @RequestMapping("/phone")
    public String phoneMy(){
        return "phone/phone";
    }
}
