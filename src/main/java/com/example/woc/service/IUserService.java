package com.example.woc.service;

import com.example.woc.entity.AccountLogin;
import com.example.woc.entity.Admin;
import com.example.woc.entity.Role;
import com.example.woc.model.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IAdminService extends IService<Admin> {

    /**登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password, HttpServletRequest request);

    /**根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    /**根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    // 注册功能
    RespBean register(AccountLogin accountLogin);
}
