package com.seata.payment.transfer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@FeignClient(value = "seata-payment-transfer2", fallback = RemotePaymentFallbackService.class)
public interface RemotePaymentFeignService {

    @GetMapping("/pt2/updateAccountInfo/{userId}/{amount}")
    public String updateAccountInfo(@PathVariable("userId") String userId, @PathVariable("amount") int amount);
}
