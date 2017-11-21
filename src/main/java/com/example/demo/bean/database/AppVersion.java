package com.example.demo.bean.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wangfeng
 * Created by lenovo on 2017/6/28.
 */
@Entity
public class AppVersion {
    @Id
    @GeneratedValue
    private Long id;
    private Long appId;
    private long code;
    private String version;
    private String apkUrl;
    //desc 为关键字 ,不能使用
    @Column(name = "app_desc")
    private String desc;
    private String updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppVersion)) {
            return false;
        }

        AppVersion that = (AppVersion) o;

        if (getCode() != that.getCode()) {
            return false;
        }
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
            return false;
        }
        if (getAppId() != null ? !getAppId().equals(that.getAppId()) : that.getAppId() != null) {
            return false;
        }
        if (getVersion() != null ? !getVersion().equals(that.getVersion()) : that.getVersion() != null) {
            return false;
        }
        if (getApkUrl() != null ? !getApkUrl().equals(that.getApkUrl()) : that.getApkUrl() != null) {
            return false;
        }
        if (getDesc() != null ? !getDesc().equals(that.getDesc()) : that.getDesc() != null) {
            return false;
        }
        return !(getUpdateDate() != null ? !getUpdateDate().equals(that.getUpdateDate()) : that.getUpdateDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAppId() != null ? getAppId().hashCode() : 0);
        result = 31 * result + (int) (getCode() ^ (getCode() >>> 32));
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getApkUrl() != null ? getApkUrl().hashCode() : 0);
        result = 31 * result + (getDesc() != null ? getDesc().hashCode() : 0);
        result = 31 * result + (getUpdateDate() != null ? getUpdateDate().hashCode() : 0);
        return result;
    }
}
