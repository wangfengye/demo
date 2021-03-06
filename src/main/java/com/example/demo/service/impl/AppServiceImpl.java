package com.example.demo.service.impl;

import com.example.demo.bean.database.App;
import com.example.demo.bean.database.AppVersion;
import com.example.demo.bean.vo.AppVo;
import com.example.demo.dao.AppDao;
import com.example.demo.service.AppService;
import com.example.demo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfeng
 * Created by lenovo on 2017/10/13.
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppVersionService appVersionService;
    @Autowired
    private AppDao appDao;

    @Override
    public List<AppVo> findAll() {
        List<App> apps = appDao.findAll();
        List<AppVo> appVos = new ArrayList<>();
        for (App app : apps) {
            AppVo appVo = new AppVo().clone(app);
            AppVersion appVersion = appVersionService.findByAppIdAndCode(app.getId(),app.getLastCode());
            appVo.setVersion(appVersion.getVersion());
            appVo.setApkUrl(appVersion.getApkUrl());
            appVos.add(appVo);
        }
        return appVos;
    }

    @Override
    public App findById(Long id) {
        return appDao.findOne(id);
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
            if (code <= app.getLastCode()){
                return false;}
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
        appVersionService.save(appVersion);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        // delete related history
        appVersionService.deleteByAppId(id);
        appDao.delete(id);
    }

    @Override
    public void changeLastCode(Long id, int code) {
        App app = appDao.findOne(id);
        app.setLastCode(code);
        appDao.save(app);
    }


}
