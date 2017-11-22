package com.example.demo.service;

import com.example.demo.bean.database.AppApply;

import java.util.List;

/**
 * @author wangfeng
 * on 2017/11/21
 */
public interface AppApplyService {
    /**
     *  find all appliers
     * @return appliers
     */
    List<AppApply> findAll();

    /**
     * save apply
     * @param userName  用户名
     * @param desc 详情
     * @param imei 手机串号
     * @param  applyDate 申请日期
     */
    void saveApply(String userName, String desc, String imei, String applyDate);
}
