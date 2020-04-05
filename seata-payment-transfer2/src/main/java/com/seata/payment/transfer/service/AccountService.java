package com.seata.payment.transfer.service;

import com.seata.payment.transfer.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Transactional
    public void updateAccountBalance(String userId, int amount) {
        accountMapper.updateAccount(userId, amount);
    }

}
