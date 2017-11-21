package com.example.demo.service;

import com.example.demo.bean.database.AppVersion;

import java.util.List;

/**
 * @author wangfeng
 * Created by lenovo on 2017/10/13.
 */
public interface AppVersionService {
    /**
     * find appVersions by app name
     * @param name app name
     * @return appVersions
     */
    List<AppVersion> findByName(String name);
}
