package com.lemon1234.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.Bank;
import com.lemon1234.entity.User;
import com.lemon1234.mapper.BankMapper;
import com.lemon1234.service.BankService;

@Transactional
@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankMapper bankMapper;
	
	public Page<Bank> queryBankList() throws Exception {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		
		// Page<User> userPage = new Page<User>(dto.getCurrentPage(), dto.getPageSize());
		
		// bankMapper.selectPage(page, queryWrapper);
		return null;
	}
}
