package com.example.demo.api;

import com.example.demo.bean.dataObject.App;
import com.example.demo.bean.dataObject.AppVersion;
import com.example.demo.bean.responseBean.ResponseDefault;
import com.example.demo.bean.vo.AppVo;
import com.example.demo.dao.AppDao;
import com.example.demo.dao.AppVersionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/6/28.
 */
@RestController
public class AppApi {
    @Autowired
    private AppVersionDao appVersionDao;
    @Autowired
    private AppDao appDao;

    @RequestMapping(value = "/app")
    public ResponseDefault getAllApk() {
        List<App> apps = appDao.findAll();
        List<AppVo> appVos = new ArrayList<>();
        for (App app : apps) {
            AppVo appVo = new AppVo().clone(app);
            AppVersion appVersion = appVersionDao.findByAppIdAndCode(app.getId(), app.getLastCode());
            appVo.setVersion(appVersion.getVersion());
            appVo.setApkUrl(appVersion.getApkUrl());
            appVos.add(appVo);
        }
        ResponseDefault res = new ResponseDefault(appVos);
        return res;
    }

    @RequestMapping("app/{name}")
    ResponseDefault getByName(@PathVariable String name) {
        App app = appDao.findByName(name);
        ResponseDefault result = new ResponseDefault(app);
        return result;
    }

    @RequestMapping(value = "/app", method = RequestMethod.POST)
    ResponseDefault addApk(@RequestParam String name,
                           @RequestParam(required = false) String version,
                           @RequestParam int code,
                           @RequestParam String apkUrl,
                           @RequestParam String desc,
                           @RequestParam String updateDate) {
        App app = appDao.findByName(name);
        if (app == null) {
            App saveApp = new App();
            saveApp.setName(name);
            saveApp.setLastCode(code);
            appDao.save(saveApp);
            app = appDao.findByName(name);
        } else {
            if (code <= app.getLastCode())
                return new ResponseDefault("已存在此版本");
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
        ResponseDefault result = new ResponseDefault("success");
        return result;
    }


}
