package com.example.demo.bean.database;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限表
 *
 * @author 王枫
 * @date 2017/9/15
 */
@Entity
public class SysPermission implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    /**
     * 权限字符集
     */
    @Column(unique = true, nullable = false)
    private String permission;
    private Boolean available = Boolean.FALSE;

    @ManyToMany(mappedBy = "permissions")
    // private Set<SysRole> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysPermission)) {
            return false;
        }

        SysPermission that = (SysPermission) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
            return false;
        }
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null) {
            return false;
        }
        if (getPermission() != null ? !getPermission().equals(that.getPermission()) : that.getPermission() != null) {
            return false;
        }
        return !(getAvailable() != null ? !getAvailable().equals(that.getAvailable()) : that.getAvailable() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getPermission() != null ? getPermission().hashCode() : 0);
        result = 31 * result + (getAvailable() != null ? getAvailable().hashCode() : 0);
        return result;
    }
}
