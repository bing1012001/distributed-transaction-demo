package com.seata.payment.transfer.mapper;


import com.seata.payment.transfer.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    @Update("UPDATE  account SET balance = balance + #{amount}, update_time = #{updateTime} WHERE user_id = #{userId}")
    public int updateAccount(String userId, int account);

    @Insert("INSERT INTO account (user_id, balance, update_time) VALUES (#{userId}, #{balance}, #{updateTime})")
    public int AddNewAccount(Account account);

    @Select("SELECT * FROM account WHERE user_id = #{userId}")
    public Account getAccountInfo(String userId);

}
