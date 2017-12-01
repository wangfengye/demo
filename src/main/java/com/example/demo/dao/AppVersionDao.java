package com.example.demo.dao;

import com.example.demo.bean.database.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author wangfeng
 * Created by lenovo on 2017/6/28.
 */
public interface AppVersionDao extends JpaRepository<AppVersion,Long> {
    /**
     * find appVersions by app id
     * @param appId app id
     * @return appVersion
     */
    List<AppVersion> findByAppId(Long appId);

    /**
     * find appVersion by app id and app code
     * @param appId app id
     * @param code inside version
     * @return appVersion
     */
    AppVersion findByAppIdAndCode(Long appId,long code);

    /**
     * delete by app id
     * @param id APP id
     */
    @Transactional
    @Modifying
    @Query("delete from AppVersion where appId = ?1")
    void deleteByAppId(Long id);
}
