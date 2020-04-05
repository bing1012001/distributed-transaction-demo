package com.seata.payment.transfer.controller;

import com.seata.payment.transfer.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/paymentTransfer/{transferId}/{receiverId}/{amount}")
    public String paymentTransfer(@PathVariable("transferId") String transferId, @PathVariable("receiverId") String receiverId, @PathVariable("amount") int amount) {
        accountService.updateAccountBalance(transferId, receiverId, amount);
        return "success of transfer";
    }

}
