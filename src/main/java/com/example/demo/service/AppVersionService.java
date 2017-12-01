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

    /**
     *  find by id
     * @param id id
     * @return AppVersion
     */
    AppVersion findById(Long id);

    /**
     * find by appId, code
     * @param appId APP id
     * @param code inside code
     * @return appVersion
     */
    AppVersion findByAppIdAndCode(Long appId,int code);

    /**
     *  delete by id
     * @param id id
     */
    void deleteById(Long id);

    /**
     * delete by app id
     * @param id app id
     */
    void deleteByAppId(Long id);

    /**
     *  save appVersion
     * @param appVersion appVersion
     */
    void save(AppVersion appVersion);
}
