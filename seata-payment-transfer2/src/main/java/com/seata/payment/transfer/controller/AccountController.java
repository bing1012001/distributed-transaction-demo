package com.seata.payment.transfer.controller;

import com.seata.payment.transfer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/updateAccountInfo/{userId}/{amount}")
    public String updateAccountInfo(@PathVariable("userId") String userId, @PathVariable("amount") int amount) {
        accountService.updateAccountBalance(userId, amount);
        return "success";
    }

}
