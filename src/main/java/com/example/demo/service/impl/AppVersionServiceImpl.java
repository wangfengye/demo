package com.example.demo.service.impl;

import com.example.demo.bean.database.App;
import com.example.demo.bean.database.AppVersion;
import com.example.demo.dao.AppVersionDao;
import com.example.demo.service.AppService;
import com.example.demo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangfeng
 * Created by lenovo on 2017/10/13.
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionDao appVersionDao;
    @Autowired
    private AppService appService;
    @Override
    public List<AppVersion> findByName(String name) {
        App app = appService.findByName(name);
        List<AppVersion> list = appVersionDao.findByAppId(app.getId());
        return list;
    }

    @Override
    public AppVersion findById(Long id) {
        return appVersionDao.findOne(id);
    }

    @Override
    public AppVersion findByAppIdAndCode(Long appId, int code) {
        return appVersionDao.findByAppIdAndCode(appId, code);
    }

    @Override
    public void deleteById(Long id) {
        AppVersion appVersion = appVersionDao.findOne(id);
        appVersionDao.delete(id);
        // 如果某app所有历史记录都删除,则删除该app
        Long appId =appVersion.getAppId();
        List<AppVersion> appVersions =appVersionDao.findByAppId(appId);
        if (appVersions ==null || appVersions.size() ==0) {
            if (appService.findById(appId)!=null) {
                appService.deleteById(appId);
            }
        }else {
            // 修改最新版本
            int lastCode = 0;
            for (AppVersion av : appVersions) {
                if (av.getCode()>lastCode){
                    lastCode = (int) av.getCode();
                }
            }
            appService.changeLastCode(appId,lastCode);
        }
    }

    @Override
    public void deleteByAppId(Long id) {
        appVersionDao.deleteByAppId(id);

    }

    @Override
    public void save(AppVersion appVersion) {
        appVersionDao.save(appVersion);
    }

}
