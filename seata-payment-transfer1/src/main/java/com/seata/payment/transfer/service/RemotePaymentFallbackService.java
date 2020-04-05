package com.seata.payment.transfer.service;

import org.springframework.stereotype.Component;

@Component
public class RemotePaymentFallbackService implements RemotePaymentFeignService {
    @Override
    public String updateAccountInfo(String userId, int amount) {
        return "fallback";
    }
}
