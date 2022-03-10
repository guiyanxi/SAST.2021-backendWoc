package com.example.woc.service;

import com.example.woc.entity.Account;
import com.example.woc.entity.Role;
import com.example.woc.model.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService extends IService<Account> {

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
    Account getAdminByUserName(String username);

    /**根据用户id查询角色列表
     * @param accountId
     * @return
     */
    List<Role> getRoles(Integer accountId);

    // 注册功能
    RespBean register(Account account);
}
