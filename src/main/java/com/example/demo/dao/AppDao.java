package com.example.demo.dao;

import com.example.demo.bean.database.App;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lenovo on 2017/9/11.
 */
public interface AppDao extends JpaRepository<App,Long> {
   App findByName(String name);

}
