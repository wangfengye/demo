package com.example.demo.dao;

import com.example.demo.bean.database.App;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wangfeng
 * @date 2016/10/31
 */
public interface AppDao extends JpaRepository<App,Long> {
   /**
    * find app by app name
    * @param name app名称
    * @return app object
     */
   App findByName(String name);
}
