package com.zh.plus.service.impl;

import com.zh.plus.entity.Account;
import com.zh.plus.mapper.AccountMapper;
import com.zh.plus.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zh
 * @since 2020-04-23
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
