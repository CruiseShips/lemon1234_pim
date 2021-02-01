package com.lemon1234.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.User;
import com.lemon1234.entity.dto.QueryBankListDTO;
import com.lemon1234.entity.vo.QueryBankListVO;
import com.lemon1234.mapper.BankMapper;
import com.lemon1234.mapper.UserMapper;
import com.lemon1234.service.BankService;

@Transactional
@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankMapper bankMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<QueryBankListVO> queryBankList(QueryBankListDTO dto) throws Exception {
		Page<User> userPage = new Page<User>(dto.getCurrentPage(), dto.getPageSize());
		
		List<QueryBankListVO> voList = userMapper.getUserList(dto.getUsername(), userPage);
		
		// 循环 list
		
		return voList;
	}
	
}
