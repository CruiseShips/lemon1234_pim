package com.lemon1234.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.User;
import com.lemon1234.entity.dto.QueryUserListDTO;
import com.lemon1234.mapper.UserMapper;
import com.lemon1234.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Page<User> queryUserList(QueryUserListDTO dto) throws Exception {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		// 只查询某些字段
		queryWrapper.select("id", "name", "email", "phoneNum", "openId", "gender", "photo", "createDt", "spaceSize", "isMembers");
		if(dto.getName() != null) {
			queryWrapper.like("name", dto.getName());
		}
		if(dto.getPhoneNum() != null) {
			queryWrapper.eq("phoneNum", dto.getPhoneNum());
		}
		queryWrapper.orderByDesc("createDt");
		Page<User> userPage = new Page<User>(dto.getCurrentPage(), dto.getPageSize());
		
		Page<User> user = userMapper.selectPage(userPage, queryWrapper);
		return user;
	}
}
