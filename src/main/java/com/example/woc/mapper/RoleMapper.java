package com.example.woc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.woc.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRoles(Integer account_id);
}
