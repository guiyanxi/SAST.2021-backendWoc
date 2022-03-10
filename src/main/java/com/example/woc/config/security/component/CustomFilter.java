package com.example.woc.config.security.component;

import com.example.woc.entity.Menu;
import com.example.woc.entity.Role;
import com.example.woc.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 *  017
 * 权限控制
 * -URL -> 角色
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        // 获取请求的rul
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        List<Menu> menus = menuService.getMenusWithRole();

        for (Menu menu : menus) {
            if(antPathMatcher.match(menu.getPath(), requestUrl)){

                String[] str = menu.getRoles().stream().map(Role::getUsername).toArray(String[]::new);
                System.out.println("权限-------------"+SecurityConfig.createList(str));
                return SecurityConfig.createList(str);
            }
        }
        // 没匹配的url 则是默认登录角色 即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
