package com.example.demo.dao;

import com.example.demo.bean.database.AppApply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangfeng
 * on 2017/11/21
 */
public interface AppApplyDao extends JpaRepository<AppApply,Long> {

}
