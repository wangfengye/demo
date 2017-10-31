package com.example.demo.dao;

import com.example.demo.bean.database.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangfeng
 * @date 2017/10/31
 */
public interface SysRoleDao extends JpaRepository<SysRole,Long>{
}
