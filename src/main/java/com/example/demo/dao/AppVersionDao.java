package com.example.demo.dao;

import com.example.demo.bean.dataObject.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lenovo on 2017/6/28.
 */
public interface AppVersionDao extends JpaRepository<AppVersion,Long> {
    List<AppVersion> findByAppId(Long appId);
    AppVersion findByAppIdAndCode(Long appId,long code);
}
