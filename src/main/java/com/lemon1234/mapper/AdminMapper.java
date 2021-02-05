package com.lemon1234.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon1234.entity.Admin;
import com.lemon1234.provider.AdminProvider;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

	@SelectProvider(type = AdminProvider.class, method = "loadUserByUsername")
	Admin loadUserByUsername(@Param(value = "username") String username) throws UsernameNotFoundException;
}
