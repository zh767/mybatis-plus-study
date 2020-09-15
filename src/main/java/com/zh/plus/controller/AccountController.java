package com.zh.plus.controller;


import com.zh.plus.entity.Account;
import com.zh.plus.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zh
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/plus/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/findAll")
    public List<Account> findAll(){

        return accountService.list(null);
    }
}

