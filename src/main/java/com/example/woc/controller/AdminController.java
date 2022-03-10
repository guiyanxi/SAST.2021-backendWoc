//package com.example.woc.controller;
//
//import com.example.woc.entity.Role;
//import com.example.woc.model.RespBean;
//import com.example.woc.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.example.woc.entity.Account;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @author: 風楪fy
// * @create: 2022-01-15 04:19
// **/
//@Slf4j
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private UserService userService;
//
//
//    @PostMapping("/test")
//    public List<Role> test(@RequestBody Account account){
//        return userService.test(account);
//    }
//
//    @PostMapping("/login")
//    public RespBean login(@RequestBody Account account){
//        return userService.login(account);
//    }
//
//    @PostMapping("/register")
//    public RespBean register(@RequestBody Account account){
//        return userService.register(account);
//    }
//    @PutMapping("/deleteAccount")
//    public RespBean deleteAccount(@RequestBody Account account) {
//        return userService.deleteAccount(account);
//    }
//    /**
//     * 获取当前的账户总数
//     * @return
//     */
//    @GetMapping("/getAmount")
//    public List<Account> getAmountOfAccounts(){
//
//        return userService.getAmountOfAccounts();
//    }
//
//
//}
