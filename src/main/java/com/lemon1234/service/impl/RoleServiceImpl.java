package com.lemon1234.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lemon1234.entity.Role;
import com.lemon1234.mapper.RoleMapper;
import com.lemon1234.service.RoleService;

/**
 * 权限实现
 * 
 * @date 2021年1月23日
 * @author lemon1234.zhihua
 */
@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectRoleByUserId(String id) {
		return roleMapper.selectRoleByUserId(id);
	}

	
}
