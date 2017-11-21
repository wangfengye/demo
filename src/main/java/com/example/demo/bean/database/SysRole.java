package com.example.demo.bean.database;

import javax.persistence.*;
import java.util.Set;

/**
 * 系统角色
 * @author wangfeng
 * Created by lenovo on 2017/10/12.
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String role;
    private String description;
    /**
     * 是否可用,不可用不添加给用户
     */
    private Boolean available = Boolean.FALSE;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private Set<SysPermission> permissions;

    /**
     * roles user表使用的字段名
     */
    @ManyToMany(mappedBy = "roles")
    // private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Set<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<SysPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof SysRole)) {
            return false;
        }

        SysRole sysRole = (SysRole) o;

        if (getId() != null ? !getId().equals(sysRole.getId()) : sysRole.getId() != null) {
            return false;
        }
        if (getRole() != null ? !getRole().equals(sysRole.getRole()) : sysRole.getRole() != null) {
            return false;
        }
        if (getDescription() != null ? !getDescription().equals(sysRole.getDescription()) : sysRole.getDescription() != null) {
            return false;
        }
        if (getAvailable() != null ? !getAvailable().equals(sysRole.getAvailable()) : sysRole.getAvailable() != null) {
            return false;
        }
        return !(getPermissions() != null ? !getPermissions().equals(sysRole.getPermissions()) : sysRole.getPermissions() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getAvailable() != null ? getAvailable().hashCode() : 0);
        result = 31 * result + (getPermissions() != null ? getPermissions().hashCode() : 0);
        return result;
    }
}
