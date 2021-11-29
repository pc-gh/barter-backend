package com.transfar.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zb
 * @version 1.0
 * @date 2021/11/29 15:42
 * @desc TODO
 */

@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器（关联SecurityManager）
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //============== 开始配置拦截：==================
        //1.添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器。用于拦截需要权限才能访问资源的请求。
         *  常用的过滤器：
         *      anon: 无需认证（登录）就可以访问。允许匿名身份访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe的功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        //添加认证过滤器
        //filterMap.put("/api/add","authc");
        //filterMap.put("/api/update","authc");
        filterMap.put("/api/testThymeleaf","anon"); // 放行该请求。
        filterMap.put("/api/login","anon"); // 放行该请求。

        //添加授权过滤器
        filterMap.put("/api/add","perms[user:add]");// 需要权限才能访问。并且要放在拦截所有的上面才有效。
        filterMap.put("/api/update","perms[user:update]");

        filterMap.put("/api/*","authc"); // 拦截/api/所有请求
        //authc模式拦截后默认跳转到login.jsp页面，无论有没有该页面。
        // 修改调整的登陆页面
        shiroFilterFactoryBean.setLoginUrl("/api/toLogin");

        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/api/unAuthorized");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //====================================结束==========================================
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("CustomRealm") CustomRealm customRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm((Realm) customRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     * 我们可以先自定义一个Realm类
     */
    @Bean(name = "CustomRealm")
    public CustomRealm getRealm(){
        return new CustomRealm();
    }


}
