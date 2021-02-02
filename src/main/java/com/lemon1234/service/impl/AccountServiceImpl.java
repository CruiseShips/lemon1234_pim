package com.lemon1234.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon1234.entity.Account;
import com.lemon1234.mapper.AccountMapper;
import com.lemon1234.service.AccountService;
import com.lemon1234.util.StringUtil;

@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Integer getAccountCountByBankId(String bankId) throws Exception {
		if(StringUtil.isEmpty(bankId)) {
			return 0;
		}
		QueryWrapper<Account> queryWrapper = new QueryWrapper<Account>();
		queryWrapper.eq("bankId", bankId);
		return accountMapper.selectCount(queryWrapper);
	}
}
