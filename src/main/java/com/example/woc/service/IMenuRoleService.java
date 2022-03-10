package com.example.woc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.woc.entity.MenuRole;
import com.example.woc.model.RespBean;


public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
