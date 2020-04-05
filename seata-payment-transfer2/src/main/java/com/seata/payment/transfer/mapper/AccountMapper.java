package com.seata.payment.transfer.mapper;

import com.seata.payment.transfer.entity.AccountInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    @Update("UPDATE  account SET balance = balance + #{amount}, update_time = #{updateTime} WHERE user_id = #{userId}")
    public int updateAccount(String userId, int account);

    @Insert("INSERT INTO account (user_id, balance, update_time) VALUES (#{userId}, #{balance}, #{updateTime})")
    public int AddNewAccount(AccountInfo account);

    @Select("SELECT * FROM account WHERE user_id = #{userId}")
    public AccountInfo getAccountInfo(String userId);

}
