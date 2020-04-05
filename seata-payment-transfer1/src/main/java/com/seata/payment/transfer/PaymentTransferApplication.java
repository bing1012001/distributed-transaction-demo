package com.seata.payment.transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentTransferApplication.class, args);
    }
}
