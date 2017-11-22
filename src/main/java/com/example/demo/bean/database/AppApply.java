package com.example.demo.bean.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wangfeng
 * on 2017/11/21
 */
@Entity
public class AppApply {
    @Id
    @GeneratedValue
    private Long id;
    private String user;
    @Column(name = "app_apply_desc")
    private String desc;
    private String applyDate;
    private String imei;

    public AppApply() {
    }

    public AppApply(String user, String desc, String applyDate, String imei) {
        this.user = user;
        this.desc = desc;
        this.applyDate = applyDate;
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }
}
