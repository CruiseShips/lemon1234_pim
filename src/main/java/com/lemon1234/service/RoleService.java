package com.lemon1234.service;

import java.util.List;

import com.lemon1234.entity.Role;

public interface RoleService {

	List<Role> selectRoleByUserId(String id);
}
