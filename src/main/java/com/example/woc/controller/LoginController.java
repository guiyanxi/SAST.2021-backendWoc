package com.zdy.yeb.controller;

import com.zdy.yeb.pojo.Admin;
import com.zdy.yeb.pojo.AdminLoginParam;
import com.zdy.yeb.pojo.RespBean;
import com.zdy.yeb.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
/*不是遥控器，是令牌
* 登录令牌（@RequestBody       User user,Request request）
*      返回service.login实现（User.user, User.password, User.验证码 ）
* */

//登录
@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
    private IAdminService adminService;
    @ApiOperation("登录之后返回token") //swag注解代替注释
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), adminLoginParam.getCaptcha(), request);
    }

    @ApiOperation("获取当前登录用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }

    /**返回成功即可，具体实现在前端进行，因为使用token，退出时在前端把tokenHead删除就行了
     * @return
     */
    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public RespBean logout() {
        return RespBean.success("注销成功！");
    }
}