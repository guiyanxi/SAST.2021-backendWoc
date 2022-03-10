package com.example.woc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.woc.config.security.component.JwtTokenUitl;
import com.example.woc.entity.Account;
import com.example.woc.mapper.RoleMapper;
import com.example.woc.mapper.UserMapper;
import com.example.woc.service.IUserService;
import com.example.woc.entity.Role;
import com.example.woc.model.RespBean;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 服务实现

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Account> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUitl jwtTokenUitl;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    public RespBean register(Account account){
        String username=account.getUsername();
        String password = account.getPassword();
        String email=account.getEmail();

        //log.info("password{}", password);

        if (StringUtils.isEmpty(username)) {
            return RespBean.error("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return RespBean.error("密码不能为空");
        }

        Account user2=userMapper.selectOne(new QueryWrapper<Account>().eq("username", username));
        if (user2 != null) {
            return RespBean.error("用户已存在~");
        }
        //int resultCount=userMapper.saveUser(username, passwordEncoder.encode(password),email);
        Account account02=new Account();
        account02.setUsername(username);
        account02.setPassword(passwordEncoder.encode(password));
        account02.setEmail(email);
        int resultCount = userMapper.insert(account02);
        if (resultCount== 0) {
            return RespBean.error("注册失败");
        }
        return RespBean.success("注册成功");
    }

    @Override
    public RespBean login(String username, String password, HttpServletRequest request) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号已禁用，请联系管理员");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        String token = jwtTokenUitl.genegrateToken(userDetails);

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public Account getAdminByUserName(String username) {
        return userMapper.selectOne(new QueryWrapper<Account>().eq("username", username));
    }

    /**
     * 根据用户id查询角色列表
     *
     * @param adminId
     * @return
     */
    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }
}
