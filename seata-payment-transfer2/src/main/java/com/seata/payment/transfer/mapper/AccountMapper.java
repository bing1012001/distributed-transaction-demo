package com.seata.payment.transfer.mapper;

import com.seata.payment.transfer.entity.AccountInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {

    @Update("UPDATE  account_info SET balance = balance + #{amount} WHERE user_id = #{userId}")
    public int updateAccount(@Param("userId") String userId, @Param("amount") int amount);

    @Insert("INSERT INTO account_info (user_id, balance, update_time) VALUES (#{userId}, #{balance}, #{updateTime})")
    public int AddNewAccount(AccountInfo account);

    @Select("SELECT * FROM account_info WHERE user_id = #{userId}")
    public AccountInfo getAccountInfo(String userId);

}
