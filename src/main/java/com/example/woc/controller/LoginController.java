package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.entity.AccountLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.woc.service.IUserService;
import com.example.woc.model.RespBean;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


//登录
@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
    private IUserService userService;

    @ApiOperation("角色注册") //swag注解代替注释
    @PostMapping("/register")
    public RespBean uploadUsername(@RequestBody Account account) {
        return userService.register(account);
    }

    @ApiOperation("登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AccountLogin accountLogin, HttpServletRequest request) {
        return userService.login(accountLogin.getUsername()
                , accountLogin.getPassword()
                , request);
    }

    @ApiOperation("获取当前登录用户的信息")
    @GetMapping("/account/info")
    public Account getAdminInfo(Principal principal) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        Account account = userService.getAdminByUserName(username);
        account.setPassword(null);
        account.setRoles(userService.getRoles(account.getId()));
        return account;
    }

    /**token，退出时前端tokenHead删除
     * @return
     */
    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public RespBean logout() {
        return RespBean.success("注销成功！");
    }
}