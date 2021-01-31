package com.lemon1234.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon1234.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
