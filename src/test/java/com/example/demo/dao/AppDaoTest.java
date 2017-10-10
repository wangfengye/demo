package com.example.demo.dao;

import com.example.demo.bean.dataObject.App;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 2017/9/11.
 */
public class AppDaoTest {
    @Autowired
    private AppDao dao;
    @Test
    public void testFindByName(){
        String name ="ww";
       App app = dao.findByName(name);
        System.out.println(app.toString());
    }

}