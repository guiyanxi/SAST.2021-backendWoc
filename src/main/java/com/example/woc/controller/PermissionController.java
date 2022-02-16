package com.zdy.yeb.controller;
// 已写好前端&接口文档，022只写了这一个板块
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdy.yeb.pojo.Menu;
import com.zdy.yeb.pojo.MenuRole;
import com.zdy.yeb.pojo.RespBean;
import com.zdy.yeb.pojo.Role;
import com.zdy.yeb.service.IMenuRoleService;
import com.zdy.yeb.service.IMenuService;
import com.zdy.yeb.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/system/basic/permiss") //菜单-权限管理的访问路径
public class PermissionController {

    @Autowired
    private IRoleService roleService;
    /*数据表字段  详见pojo/job level
    ① id  ②职称名称  ③职称等级  ④创建时间  ⑤是否启用
    */
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation("获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_" + role.getName());  // 统一角色的前缀
        }
        if(roleService.save(role)) {
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable("rid") Integer rid) {
        if(roleService.removeById(rid)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation("查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @ApiOperation("根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable("rid") Integer rid) {
        // list查询的是MenuRole对象，所有用stream流获取Mid，然后转换为List
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid", rid)).stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation("更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        return menuRoleService.updateMenuRole(rid, mids);
    }
}
