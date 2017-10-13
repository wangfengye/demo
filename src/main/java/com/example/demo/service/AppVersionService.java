package com.example.demo.service;

import com.example.demo.bean.dataObject.AppVersion;

import java.util.List;

/**
 * Created by lenovo on 2017/10/13.
 */
public interface AppVersionService {
    List<AppVersion> findByName(String name);
}
