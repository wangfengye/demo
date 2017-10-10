package com.example.demo.api;

import com.example.demo.bean.dataObject.App;
import com.example.demo.bean.dataObject.AppVersion;
import com.example.demo.bean.responseBean.ResponseDefault;
import com.example.demo.dao.AppDao;
import com.example.demo.dao.AppVersionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lenovo on 2017/9/12.
 */
@RestController
@RequestMapping("/appVersion")
public class AppVersionApi {
    @Autowired
    private AppVersionDao appVersionDao;
    @Autowired
    private AppDao appDao;

    @GetMapping("/all")
    ResponseDefault getAll(@RequestParam String name) {
        App app = appDao.findByName(name);
        List<AppVersion> list = appVersionDao.findByAppId(app.getId());
        ResponseDefault result = new ResponseDefault(list);
        return result;
    }

    @GetMapping("/one")
    ResponseDefault get(@RequestParam String name, @RequestParam long code) {
        App app = appDao.findByName(name);
        AppVersion appVersion = appVersionDao.findByAppIdAndCode(app.getId(), code);
        ResponseDefault result = new ResponseDefault(app);
        return result;
    }
}
