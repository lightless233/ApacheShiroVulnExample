package me.lightless.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    DefaultSecurityManager defaultSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultSecurityManager());

        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/account/index");
        bean.setUnauthorizedUrl("/index");

        Map<String, String> map = new HashMap<>();
        map.put("/account/**", "authc");
        map.put("/admin/*", "authc");
        bean.setFilterChainDefinitionMap(map);

        return bean;
    }

}
