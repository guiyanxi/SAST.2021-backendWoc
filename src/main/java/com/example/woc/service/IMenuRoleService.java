package com.zdy.yeb.service;

import com.zdy.yeb.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zdy.yeb.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaody
 * @since 2021-04-19
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
