package com.example.demo.service.impl;

import com.example.demo.bean.database.AppApply;
import com.example.demo.dao.AppApplyDao;
import com.example.demo.service.AppApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangfeng
 * on 2017/11/21
 */
@Service
public class AppApplyServiceImpl implements AppApplyService{
    @Autowired
    AppApplyDao dao;
    @Override
    public List<AppApply> findAll() {
        return dao.findAll();
    }

    @Override
    public void saveApply(String userName, String desc, String imei, String applyDate) {
        if (userName.isEmpty() || desc.isEmpty() || imei.isEmpty()){
            throw new RuntimeException("missing param");
        }
        AppApply appApply = new AppApply(userName, desc, imei, applyDate);
        dao.save(appApply);
    }

    @Override
    public void deleteById(Long id) {
        dao.delete(id);
    }
}
