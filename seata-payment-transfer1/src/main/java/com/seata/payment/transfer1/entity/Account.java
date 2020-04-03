package com.seata.payment.transfer1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
@ToString
public class Account implements Serializable {
    private String userId;

    private Integer balance;

    private Timestamp updateTime;

}
