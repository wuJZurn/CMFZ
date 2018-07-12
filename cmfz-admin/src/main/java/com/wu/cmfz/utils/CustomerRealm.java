package com.wu.cmfz.utils;

import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by wu on 2018/7/11.
 */

@Service
public class CustomerRealm extends AuthorizingRealm {
    
    @Autowired
    private ManagerService managerService;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userName = (String) principalCollection.getPrimaryPrincipal();
        Manager manager = managerService.queryManagerByName(userName);
        if(manager.getMgrName().equals(userName)){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("root");
            info.addRole("admin");
            info.addRole("user");

            info.addStringPermission("user:add");
            info.addStringPermission("user:query");
            info.addStringPermission("user:remove");
            return info;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        //char[] password = usernamePasswordToken.getPassword();
        Manager manager = managerService.queryManagerByName(username);
        if(manager!=null){
            return new SimpleAuthenticationInfo(manager.getMgrName(),
                    manager.getMgrPwd(), ByteSource.Util.bytes(manager.getSalt()),this.getName());
        }
        return null;
    }
}
