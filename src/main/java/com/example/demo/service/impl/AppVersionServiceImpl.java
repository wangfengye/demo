package com.example.demo.service.impl;

import com.example.demo.bean.database.App;
import com.example.demo.bean.database.AppVersion;
import com.example.demo.dao.AppDao;
import com.example.demo.dao.AppVersionDao;
import com.example.demo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/10/13.
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionDao appVersionDao;
    @Autowired
    private AppDao appDao;

    @Override
    public List<AppVersion> findByName(String name) {
        App app = appDao.findByName(name);
        List<AppVersion> list = appVersionDao.findByAppId(app.getId());
        return list;
    }

}
