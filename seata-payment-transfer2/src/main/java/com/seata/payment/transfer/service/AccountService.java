package com.seata.payment.transfer.service;

import com.seata.payment.transfer.mapper.AccountMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Transactional
    public void updateAccountBalance(String userId, int amount) {
        log.info("Global Transaction XID {}", RootContext.getXID());
        accountMapper.updateAccount(userId, amount);
//        if(amount == 500) {
//            throw new RuntimeException("exception thrown out");
//        }
    }

}
