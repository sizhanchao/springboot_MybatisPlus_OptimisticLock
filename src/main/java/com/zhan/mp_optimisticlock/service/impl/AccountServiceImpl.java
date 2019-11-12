package com.zhan.mp_optimisticlock.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhan.mp_optimisticlock.entity.Account;
import com.zhan.mp_optimisticlock.mapper.AccountMapper;
import com.zhan.mp_optimisticlock.service.AccountService;

/**
 * @author zhan
 * @since 2019-11-12 11:20
 */
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}
