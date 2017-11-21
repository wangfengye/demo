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
     * @param userName
     * @param desc
     * @param imei
     */
    void saveApply(String userName, String desc, String imei);
}
