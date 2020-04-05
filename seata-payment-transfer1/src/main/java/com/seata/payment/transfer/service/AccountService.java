package com.seata.payment.transfer.service;

import com.seata.payment.transfer.mapper.AccountMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private RemotePaymentFeignService remotePaymentFeignService;

    @GlobalTransactional
    @Transactional
    public void updateAccountBalance(String transferId, String receiverId, int amount) {
        accountMapper.updateAccount(transferId, amount * -1);
        String response = remotePaymentFeignService.updateAccountInfo(receiverId, amount);
        if(response.equals("fallback")) {
            throw new RuntimeException("transfer failed at receiver side");
        }
    }

}
