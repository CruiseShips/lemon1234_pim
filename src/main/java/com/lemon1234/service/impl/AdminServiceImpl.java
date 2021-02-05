package com.lemon1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.Admin;
import com.lemon1234.entity.Role;
import com.lemon1234.entity.dto.GetAdminListDTO;
import com.lemon1234.mapper.AdminMapper;
import com.lemon1234.mapper.RoleMapper;
import com.lemon1234.service.AdminService;
import com.lemon1234.util.StringUtil;

/**
 * 管理员
 */
@Transactional
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
			// throw new UsernameNotFoundException("用户不存在");
			return null;
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

	@Override
	public Page<Admin> getAdminList(GetAdminListDTO dto) throws Exception {
		Page<Admin> userPage = new Page<Admin>((dto.getCurrentPage()-1)*dto.getPageSize(), dto.getPageSize());
		
		QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>();
		queryWrapper.select("id", "username", "email", "phoneNum", "gender", "name", "img", "ban");
		if(StringUtil.isNotEmpty(dto.getName())) {
			queryWrapper.like("name", dto.getName());
		}
		if(StringUtil.isNotEmpty(dto.getName())) {
			queryWrapper.eq("username", dto.getUsername());
		}
		if(StringUtil.isNotEmpty(dto.getName())) {
			queryWrapper.eq("email", dto.getEmail());
		}
		if(StringUtil.isNotEmpty(dto.getName())) {
			queryWrapper.eq("phoneNum", dto.getPhoneNum());
		}
		
		Page<Admin> adminPage = adminMapper.selectPage(userPage, queryWrapper);
		
		return adminPage;
	}
}
