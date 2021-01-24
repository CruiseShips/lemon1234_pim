package com.lemon1234.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon1234.entity.Role;
import com.lemon1234.provider.RoleProvider;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

	@SelectProvider(type = RoleProvider.class, method = "selectRoleByUserId")
	List<Role> selectRoleByUserId(@Param(value = "id") String id);
}
