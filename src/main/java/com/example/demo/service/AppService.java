package com.example.demo.service;

import com.example.demo.bean.database.App;
import com.example.demo.bean.vo.AppVo;

import java.util.List;

/**
 * Created by lenovo on 2017/10/13.
 */
public interface AppService {

    List<AppVo> findAll();
    App findByName(String name);
    Boolean saveApp(String name,String version,Integer code, String apkUrl, String desc, String updateDate);
}
