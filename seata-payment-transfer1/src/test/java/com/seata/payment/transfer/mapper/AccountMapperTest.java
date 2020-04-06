package com.seata.payment.transfer.mapper;

import com.seata.payment.transfer.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccountMapperTest {

    @Resource
    private AccountMapper accountMapper;



    @Before
    public void setup() {
        Assert.assertNotNull(accountMapper);

    }

    @Test
    public void accountAddTest() {
        Account account = Account.builder().userId(UUID.randomUUID().toString()).balance(1200).updateTime(Timestamp.valueOf(LocalDateTime.now())).build();
        int i = accountMapper.AddNewAccount(account);
        Assert.assertEquals(1, i);


    }

    @Test
    public void getAccountInfoTest() {
        Account account = accountMapper.getAccountInfo("c0eb0353-5477-44ed-8cde-4bd56552e411");
        Assert.assertNotNull(account);
        Assert.assertEquals(1000, (long)account.getBalance());
    }

    @Test
    public void updateAccountBalanceTest() {
        Account account = accountMapper.getAccountInfo("c0eb0353-5477-44ed-8cde-4bd56552e411");
        log.info(account.toString());
        accountMapper.updateAccount(account.getUserId(),200);

    }

}
