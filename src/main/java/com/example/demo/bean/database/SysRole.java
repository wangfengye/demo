package com.example.demo.bean.database;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lenovo on 2017/10/12.
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,nullable = false)
    private String role;
    private String description;
    /**
     * 是否可用,不可用不添加给用户
     */
    private Boolean available=Boolean.FALSE;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
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

}
