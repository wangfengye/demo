package com.example.demo.service;

import com.example.demo.bean.database.App;
import com.example.demo.bean.vo.AppVo;

import java.util.List;

/**
 * @author  wangfeng
 * Created by lenovo on 2017/10/13.
 */
public interface AppService {
    /**
     * find all app
     * @return all AppVo
     */
    List<AppVo> findAll();

    /**
     * find
     * @param id id
     * @return app
     */
    App findById(Long id);

    /**
     * find app by name
     * @param name app name
     * @return app
     */
    App findByName(String name);

    /**
     * save app with all message
     * @param name app name
     * @param version app version
     * @param code app inside version
     * @param apkUrl save url
     * @param desc description
     * @param updateDate date when update
     * @return success or error
     */
    Boolean saveApp(String name,String version,Integer code, String apkUrl, String desc, String updateDate);

    /**
     * delete app
     * @param id id
     */
    void deleteById(Long id);

    /**
     *  change Last code when delete version
     * @param id id
     * @param code last code
     */
    void changeLastCode(Long id, int code);
}
