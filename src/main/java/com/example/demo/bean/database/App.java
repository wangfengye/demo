package com.example.demo.bean.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author  wanfeng
 * Created by lenovo on 2017/9/11.
 */
@Entity(name = "app_main")
public class App {
    @Id
    @GeneratedValue
    public Long id;
    //apk name
    @Column(nullable = false, unique = true)
    public String name;
    //last version

    public int lastCode;
    @Column(name = "app_desc")
    public String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLastCode() {
        return lastCode;
    }

    public void setLastCode(int lastCode) {
        this.lastCode = lastCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof App)) {
            return false;
        }

        App app = (App) o;

        if (getLastCode() != app.getLastCode()) {
            return false;
        }
        if (getId() != null ? !getId().equals(app.getId()) : app.getId() != null) {
            return false;
        }
        if (getName() != null ? !getName().equals(app.getName()) : app.getName() != null) {
            return false;
        }
        return !(getDesc() != null ? !getDesc().equals(app.getDesc()) : app.getDesc() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getLastCode();
        result = 31 * result + (getDesc() != null ? getDesc().hashCode() : 0);
        return result;
    }
}

