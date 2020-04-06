package com.seata.payment.transfer.mapper;


import com.seata.payment.transfer.entity.Account;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {

    @Update("UPDATE account SET balance = balance + #{amount} WHERE user_id = #{userId}")
    public int updateAccount(@Param("userId") String userId, @Param("amount") int amount);

    @Insert("INSERT INTO account (user_id, balance, update_time) VALUES (#{userId}, #{balance}, #{updateTime})")
    public int AddNewAccount(Account account);

    @Select("SELECT * FROM account WHERE user_id = #{userId}")
    public Account getAccountInfo(String userId);

}
