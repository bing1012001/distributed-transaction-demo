package com.seata.payment.transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentTransfer2Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentTransfer2Application.class, args);
    }
}
