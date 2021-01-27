package com.lemon1234.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lemon1234.entity.AccountLog;
import com.lemon1234.entity.User;
import com.lemon1234.mapper.AccountLogMapper;
import com.lemon1234.mapper.UserMapper;

@SpringBootTest
public class PimApplicationTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AccountLogMapper accountLogMapper;
	
	@Test
	public void addData() {
		User user = new User();
		
		userMapper.insert(user);
	}
	
	@Test
	public void addLog() {
		AccountLog log = new AccountLog();
		
		log.setAccountId("123123");
		
		accountLogMapper.insert(log);
	}
}
