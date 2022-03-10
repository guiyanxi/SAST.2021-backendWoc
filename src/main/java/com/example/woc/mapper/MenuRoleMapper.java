package com.example.woc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.woc.entity.MenuRole;
import org.apache.ibatis.annotations.Param;

public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 根据角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
