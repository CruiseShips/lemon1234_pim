package com.lemon1234.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon1234.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
