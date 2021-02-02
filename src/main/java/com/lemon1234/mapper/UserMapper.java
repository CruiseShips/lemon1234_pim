package com.lemon1234.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.User;
import com.lemon1234.entity.vo.QueryBankListVO;
import com.lemon1234.provider.UserProvider;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	
	@SelectProvider(type = UserProvider.class, method = "getUserList")
	List<QueryBankListVO> getUserList(@Param(value = "username")String username, Page<User> page) throws Exception;
	
	@SelectProvider(type = UserProvider.class, method = "getUserCount")
	Integer getUserCount(@Param(value = "username")String username) throws Exception;
}
