package com.example.demo.bean.vo;

import com.example.demo.bean.database.App;

/**
 * @author wangfeng
 * Created by lenovo on 2017/9/11.
 */
public class AppVo extends App {
    String version;
    String apkUrl;
    @SuppressWarnings("unused")
    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public AppVo clone(App app){
        this.id =app.getId();
        this.name =app.name;
        this.lastCode=app.lastCode;
        this.desc=app.desc;
return this;
    }
}
