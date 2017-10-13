package com.example.demo.service.impl;

import com.example.demo.bean.dataObject.App;
import com.example.demo.bean.dataObject.AppVersion;
import com.example.demo.bean.vo.AppVo;
import com.example.demo.dao.AppDao;
import com.example.demo.dao.AppVersionDao;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/10/13.
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppVersionDao appVersionDao;
    @Autowired
    private AppDao appDao;

    @Override
    public List<App> findAll() {
        List<App> apps = appDao.findAll();
        List<AppVo> appVos = new ArrayList<>();
        for (App app : apps) {
            AppVo appVo = new AppVo().clone(app);
            AppVersion appVersion = appVersionDao.findByAppIdAndCode(app.getId(), app.getLastCode());
            appVo.setVersion(appVersion.getVersion());
            appVo.setApkUrl(appVersion.getApkUrl());
            appVos.add(appVo);
        }
        return apps;
    }

    @Override
    public App findByName(String name) {
        return appDao.findByName(name);
    }

    @Override
    public Boolean saveApp(String name, String version, Integer code, String apkUrl, String desc, String updateDate) {
        App app = appDao.findByName(name);
        if (app == null) {
            App saveApp = new App();
            saveApp.setName(name);
            saveApp.setLastCode(code);
            appDao.save(saveApp);
            app = appDao.findByName(name);
        } else {
            if (code <= app.getLastCode())
                return false;
            app.setLastCode(code);
            appDao.save(app);
        }
        Long appId = app.getId();
        AppVersion appVersion = new AppVersion();
        appVersion.setAppId(appId);
        appVersion.setCode(code);
        appVersion.setVersion(version);
        appVersion.setApkUrl(apkUrl);
        appVersion.setDesc(desc);
        appVersion.setUpdateDate(updateDate);
        appVersionDao.save(appVersion);
        return true;
    }


}
