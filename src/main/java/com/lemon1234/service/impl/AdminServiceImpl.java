package com.lemon1234.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.lemon1234.entity.dict.Constants;
import com.lemon1234.entity.dto.AddManageDTO;
import com.lemon1234.entity.dto.GetManageListDTO;
import com.lemon1234.mapper.AdminMapper;
import com.lemon1234.mapper.RoleMapper;
import com.lemon1234.service.AdminService;
import com.lemon1234.sys.exception.AppException;
import com.lemon1234.util.RandomCodeUtil;
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
	@Autowired
	private RandomCodeUtil randomCodeUtil;

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
	public Page<Admin> getAdminList(GetManageListDTO dto) throws Exception {
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

	@Override
	public Integer addManage(AddManageDTO dto) throws Exception {
		
		if(StringUtil.isEmpty(dto.getUsername())) {
			throw new AppException("请输入账号");
		}
		if(StringUtil.isEmpty(dto.getEmail())) {
			throw new AppException("请输入邮箱号");
		}
		if(StringUtil.isEmpty(dto.getPhoneNum())) {
			throw new AppException("请输入手机号");
		}
		if(StringUtil.isEmpty(dto.getName())) {
			throw new AppException("请输入昵称");
		}
		
		Admin admin = new Admin();
		admin.setUsername(dto.getUsername());
		admin.setEmail(dto.getEmail());
		admin.setPhoneNum(dto.getPhoneNum());
		admin.setName(dto.getName());
		
		// 默认未知
		admin.setGender(Constants.ALIENS);
		
		Map<String, String> randomCode = randomCodeUtil.randomCode(15);
		
		// TODO 异步发动邮件去往邮箱
		admin.setPassword(randomCode.get(Constants.ENCRYPTCODE));
		// 默认头像
		
		admin.setCreateDt(new Date());
		admin.setBan(Constants.ON);
		
		return adminMapper.insert(admin);
	}

	@Override
	public Integer banAdmin(String id) throws Exception {
		Admin admin = adminMapper.selectById(id);
		if(admin == null) {
			return -1;
		}
		
		if(admin.getBan().equals(Constants.ON)) {
			admin.setBan(Constants.OFF);
		} else {
			admin.setBan(Constants.ON);
		}
		
		return adminMapper.updateById(admin);
	}

	@Override
	public Integer resetPassword(String id) throws Exception {
		Admin admin = adminMapper.selectById(id);
		if(admin == null) {
			return -1;
		}
		
		Map<String, String> randomCode = randomCodeUtil.randomCode(15);
		
		admin.setPassword(randomCode.get(Constants.ENCRYPTCODE));
		
		// TODO 异步发动邮件去往邮箱
		
		return adminMapper.updateById(admin);
	}
}
