package com.transfar.config;

import com.transfar.entity.User;
import com.transfar.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author zb
 * @version 1.0
 * @date 2021/11/29 15:47
 * @desc TODO
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //从数据库中获取授权字符串
        Subject subject = SecurityUtils.getSubject();

        //subject.getPrincipal()获取的实际上是认证逻辑中return new SimpleAuthenticationInfo(user,user.getPassword(),"")第一个参数
        User user = (User) subject.getPrincipal();
        User dbUser = (User) userService.getUserByName(user.getUserName()).getData();
        //添加资源的授权字符串
        info.addStringPermission(dbUser.toString());
        return info;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //数据库中的username：admin和 password:123456
        User user = (User) userService.getUserByName(token.getUsername()).getData();
        //1.判断用户名
        if (user==null){
            //用户名不存在
            return null;  // shiro底层会抛出UnknowAccountException异常;
        }

        //2.判断密码。我们只需要返回AuthenticationInfo的一个子类SimpleAuthenticationInfo
        //第一个参数：返回登录逻辑中login方法结果的数据；第二个参数：数据库密码；第三个参数：shiro的名字
        //return new SimpleAuthenticationInfo("",user.getPassword(),"");
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }

}
