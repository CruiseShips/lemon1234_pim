package com.lemon1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lemon1234.entity.Admin;
import com.lemon1234.entity.Role;
import com.lemon1234.mapper.AdminMapper;
import com.lemon1234.mapper.RoleMapper;
import com.lemon1234.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminMapper.loadUserByUsername(username);
		if(admin == null) {
			throw new UsernameNotFoundException("用户不存在");
		} else {
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			List<Role> roleList = roleMapper.selectRoleByUserId(admin.getId());
			for(Role role : roleList) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getEngName());
				authorities.add(authority);
			}
			
			admin.setAuthorities(authorities);
			return admin;
		}
	}

}
