package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.dao.PermissionDao;
import com.baizhi.cmfz.dao.RoleDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Created by zxl on 2018/7/11.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerDao md;
    @Autowired
    private RoleDao rd;
    @Autowired
    private PermissionDao pd;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        List<Role> roles = rd.selectRoleByManagerName(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            info.addRole(role.getRoleTag());
        }
        List<Permission> permissions = pd.selectPermissionByManagerName(username);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Manager manager = md.selectById(username);
        if(manager!=null){
            return new SimpleAuthenticationInfo(username,manager.getPassword(), ByteSource.Util.bytes(manager.getSalt()),UUID.randomUUID().toString());
        }
        return null;
    }
}
