package com.example.demo.service;

import com.example.demo.bean.dataObject.App;

import java.util.List;

/**
 * Created by lenovo on 2017/10/13.
 */
public interface AppService {

    List<App> findAll();
    App findByName(String name);
    Boolean saveApp(String name,String version,Integer code, String apkUrl, String desc, String updateDate);
}
