package com.example.woc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.woc.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户id查询菜单列表
     *
     * @return
     */
    List<Menu> getMenusByAdminId();
    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
