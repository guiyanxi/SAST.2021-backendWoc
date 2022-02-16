package com.zdy.yeb.mapper;

import com.zdy.yeb.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaody
 * @since 2021-04-19
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 根据角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
