package com.example.demo.config.shiro;

import com.example.demo.bean.database.SysPermission;
import com.example.demo.bean.database.SysRole;
import com.example.demo.bean.database.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by lenovo on 2017/10/12.
 * @author feng
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    /**
     * 授权
     *
     * @param principalCollection principalCollection
     * @return info
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        Set<SysRole> roleList = user.getRoles();
        for (SysRole role : roleList) {
            roleSet.add(role.getRole());
            Set<SysPermission> permissions = role.getPermissions();
            for (SysPermission p : permissions) {
                permissionSet.add(p.getPermission());
            }
        }
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }

    /**
     * 身份认证
     *
     * @param authToken token
     * @return 身份信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        String account = token.getUsername();
        String password = String.valueOf(token.getPassword());
        Map<String, Object> map = new HashMap<>(10);
        User user = userService.findByAccountAndPassword(account, password);
        if (user == null) {
            throw new AccountException("帐号或密码不正确！");
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
