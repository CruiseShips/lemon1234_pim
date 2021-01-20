package com.lemon1234.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lemon1234.entity.Admin;
import com.lemon1234.mapper.AdminMapper;
import com.lemon1234.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminMapper.loadUserByUsername(username);
		if(admin == null) {
			return null;
		} else {
			return admin;
		}
	}

}
