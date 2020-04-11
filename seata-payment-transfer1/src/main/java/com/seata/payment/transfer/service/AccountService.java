package com.seata.payment.transfer.service;

import com.seata.payment.transfer.mapper.AccountMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private RemotePaymentFeignService remotePaymentFeignService;

    @GlobalTransactional
    @Transactional
    public void updateAccountBalance(String transferId, String receiverId, int amount) {
        log.info("Global Transaction XID {}", RootContext.getXID());
        accountMapper.updateAccount(transferId, amount * -1);
        String response = remotePaymentFeignService.updateAccountInfo(receiverId, amount);
        if(response.equals("fallback")) {
            throw new RuntimeException("transfer failed at receiver side");
        }
    }

}
