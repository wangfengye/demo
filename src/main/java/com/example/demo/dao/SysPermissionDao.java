package com.example.demo.dao;

import com.example.demo.bean.database.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
public interface SysPermissionDao extends JpaRepository<SysPermission,Long> {
}
